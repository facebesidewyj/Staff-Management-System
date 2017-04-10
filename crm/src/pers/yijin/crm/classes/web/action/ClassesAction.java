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
	 * ��������
	 * 
	 * @return
	 */
	public String findAll() {
		List<CrmClasses> allClasses = this.getClassesService().findAll();
		this.set("allClasses", allClasses);
		return "findAll";
	}

	/**
	 * �ϴ��ļ�ǰ�Ļ��Բ���
	 * 
	 * @return
	 */
	public String uploadUI() {
		CrmClasses classes = this.getClassesService().findById(this.getModel());
		this.push(classes);
		return "uploadUI";
	}

	private File schedule; // �ϴ�����
	private String scheduleFileName; // �ϴ����ļ���
	private String scheduleContentType; // �ϴ�������

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
	 * �ϴ�����
	 * 
	 * @return
	 * @throws IOException 
	 */
	@InputConfig(resultName="uploadInput")
	public String upload() throws IOException {
		//��ȡ�ϴ�Ŀ�ĵص�����·��
		String parentDir = ServletActionContext.getServletContext().getRealPath("/WEB-INF/upload");
		//���ϴ��ļ�����
		String fileName = UUID.randomUUID().toString().replace("-", "");
		//�����ļ�
		FileUtils.copyFile(schedule, new File(parentDir, fileName));
		
		//��������
		this.getModel().setUploadFilename(scheduleFileName);
		this.getModel().setUploadTime(new Date());
		this.getModel().setUploadPath("/WEB-INF/upload/"+fileName);
		this.getClassesService().updateUpload(this.getModel());
		return "upload";
	}
	
	/**
	 * ���ز���
	 * @return
	 */
	//�����ļ�Ҫ�õ������ļ���
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
		//�õ�����·��
		String realPath = ServletActionContext.getServletContext().getRealPath(findClasses.getUploadPath());
		//����ļ���
		String uploadFilename = findClasses.getUploadFilename();
		//ת��
//		fileName = URLEncoder.encode(uploadFilename, "UTF-8");
		//���
		fileName = new String(uploadFilename.getBytes("UTF-8"), "iso-8859-1");
		//���ֽ�����ֵ
		inputStream = new FileInputStream(realPath);
		return "download";
	}
}
