package com.itheima.controller;
import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



@Controller
public class FileUploadController {
	
	@RequestMapping(value="/fileUpload",method=RequestMethod.POST)
	public String handleFormUpload(@RequestParam("name") String name,
			@RequestParam("uploadfile") List<MultipartFile> uploadfile,
			HttpServletRequest request) {
		
		if (!uploadfile.isEmpty() && uploadfile.size() > 0) {
			
			for (MultipartFile file : uploadfile) {
				
				String originalFilename = file.getOriginalFilename();
				
				String dirPath = 
                       request.getServletContext().getRealPath("/upload/");
				File filePath = new File(dirPath);
				
				if (!filePath.exists()) {
					filePath.mkdirs();
				}
			
				String newFilename = name+ "_"+UUID.randomUUID() + 
                                                   "_"+originalFilename;
				try {
	
					file.transferTo(new File(dirPath + newFilename));
				} catch (Exception e) {
					e.printStackTrace();
                       return"error";
				}
			}
			return "success";
		}else{
			return"error";
		}
		
	}
	@RequestMapping("/download")
	public ResponseEntity<byte[]> fileDownload(HttpServletRequest request,String filename)throws Exception{
		System.out.println(filename);
		String path=request.getServletContext().getRealPath("/upload/");
		File file=new File(path+filename);
		System.out.println(File.separator+"测试");
		HttpHeaders headers=new HttpHeaders();
		filename=this.getFilename(request, filename);
		System.out.println("修改后的名字:"+filename);
		//通知浏览器以下载方式
		headers.setContentDispositionFormData("attachment", filename);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.OK);
		
	}
	
	public String getFilename(HttpServletRequest request,
            String filename) throws Exception { 
		// IE不同版本User-Agent中出现的关键词
		String[] IEBrowserKeyWords = {"MSIE", "Trident", "Edge"};  
		// 获取请求头代理信息
		String userAgent = request.getHeader("User-Agent");  
		for (String keyWord : IEBrowserKeyWords) { 
		if (userAgent.contains(keyWord)) { 
		//IE内核浏览器，统一为UTF-8编码显示
		return URLEncoder.encode(filename, "UTF-8");
		}
		}  
		//火狐等其它浏览器统一为ISO-8859-1编码显示
		return new String(filename.getBytes("UTF-8"), "ISO-8859-1");  
}  


}
