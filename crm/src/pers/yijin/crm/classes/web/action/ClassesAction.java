package pers.yijin.crm.classes.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.junit.Test;

import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

import pers.yijin.crm.base.BaseAction;
import pers.yijin.crm.classes.domain.CrmClasses;

public class ClassesAction extends BaseAction<CrmClasses> {
	/**
	 * 查找所有
	 * 
	 * @return
	 */
	public String findAll() {
		List<CrmClasses> allClasses = this.getClassesService().findAll();
		this.set("allClasses", allClasses);
		return "findAll";
	}

	/**
	 * 上传文件前的回显操作
	 * 
	 * @return
	 */
	public String uploadUI() {
		CrmClasses classes = this.getClassesService().findById(this.getModel());
		this.push(classes);
		return "uploadUI";
	}

	private File schedule; // 上传内容
	private String scheduleFileName; // 上传的文件名
	private String scheduleContentType; // 上传的类型

	public void setSchedule(File schedule) {
		this.schedule = schedule;
	}

	public void setScheduleFileName(String scheduleFileName) {
		this.scheduleFileName = scheduleFileName;
	}

	public void setScheduleContentType(String scheduleContentType) {
		this.scheduleContentType = scheduleContentType;
	}

	/**
	 * 上传操作
	 * 
	 * @return
	 * @throws IOException 
	 */
	@InputConfig(resultName="uploadInput")
	public String upload() throws IOException {
		//获取上传目的地的虚拟路径
		String parentDir = ServletActionContext.getServletContext().getRealPath("/WEB-INF/upload");
		//给上传文件改名
		String fileName = UUID.randomUUID().toString().replace("-", "");
		//保存文件
		FileUtils.copyFile(schedule, new File(parentDir, fileName));
		
		//更新数据
		this.getModel().setUploadFilename(scheduleFileName);
		this.getModel().setUploadTime(new Date());
		this.getModel().setUploadPath("/WEB-INF/upload/"+fileName);
		this.getClassesService().updateUpload(this.getModel());
		return "upload";
	}
	
	/**
	 * 下载操作
	 * @return
	 */
	//下载文件要用的流和文件名
	private InputStream inputStream;
	private String fileName;
	
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String download() throws IOException{
		CrmClasses findClasses = this.getClassesService().findById(this.getModel());
		//得到下载路径
		String realPath = ServletActionContext.getServletContext().getRealPath(findClasses.getUploadPath());
		//获得文件名
		String uploadFilename = findClasses.getUploadFilename();
		//转码
//		fileName = URLEncoder.encode(uploadFilename, "UTF-8");
		//火狐
		fileName = new String(uploadFilename.getBytes("UTF-8"), "iso-8859-1");
		//给字节流赋值
		inputStream = new FileInputStream(realPath);
		return "download";
	}
}
