package com.api.book.helper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	
//	// Static Path
//	public final String UPLOAD_DIR="C:\\Users\\preety.banerjee\\eclipse-workspace\\bootrestapibookResponseEntity\\src\\main\\resources\\static\\pdf";
	
	// Dynamic Path
	public final String UPLOAD_DIR=new ClassPathResource("static/pdf").getFile().getAbsolutePath();
	
	public FileUploadHelper() throws IOException{
		
	}
	
	public boolean uploadFile(MultipartFile multipartFile) {
		boolean f=false;
		try {
//			//(old) Stream api io
//			InputStream is=multipartFile.getInputStream();
//			byte data[]=new byte[is.available()];
//			is.read(data);
//			
//			//write
//			FileOutputStream fos=new FileOutputStream(UPLOAD_DIR + "\\" + multipartFile.getOriginalFilename());
//			fos.write(data);
//			
//			fos.flush();
//			fos.close();
//			f=true;
			
			//(new) nio api
			Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+ "//" + multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			f=true;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}
}
