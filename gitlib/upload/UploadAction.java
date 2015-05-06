package com.module.ethics.xxgl.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UploadAction extends ActionSupport {

	private File upload; // 文件本身
	private String uploadContentType; // 文件类型
	private String uploadFileName; // 文件名

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String upload() throws IOException {
		String savePath = ServletActionContext.getServletContext().getRealPath(
				"/module/ethics/xxgl/imgs/" + this.uploadFileName);
		
		System.out.println(savePath);
		FileInputStream fis = new FileInputStream(upload);
		FileOutputStream fos = new FileOutputStream(savePath);
		IOUtils.copy(fis, fos);
		fos.flush();
		fos.close();
		fis.close();
		return ActionSupport.SUCCESS;
	}
	
	public String zipPhotos(){
		File file = new File("/module/ethics/xxgl/imgs/photos.zip");
		if(file.exists()){
		}
		return ActionSupport.SUCCESS;
	}
}
