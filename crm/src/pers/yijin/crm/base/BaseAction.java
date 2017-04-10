package pers.yijin.crm.base;

import java.lang.reflect.ParameterizedType;

import pers.yijin.crm.classes.service.ClassesService;
import pers.yijin.crm.coursetype.service.CoursetypeService;
import pers.yijin.crm.department.service.DepartmentService;
import pers.yijin.crm.post.service.PostService;
import pers.yijin.crm.staff.service.StaffService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	private T t;

	@Override
	public T getModel() {
		return t;
	}


	// 实例化
	@SuppressWarnings("unchecked")
	public BaseAction() {
		try {
			// 获得T运行时的class
			ParameterizedType parameterizedType = (ParameterizedType) this
					.getClass().getGenericSuperclass();
			Class<T> clazz = (Class<T>) parameterizedType
					.getActualTypeArguments()[0];
			// 反射创建实例
			t = clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 注入service
	private StaffService staffService;
	private PostService postService;
	private DepartmentService departmentService;
	private CoursetypeService coursetypeService;
	private ClassesService classesService;
	
	
	public ClassesService getClassesService() {
		return classesService;
	}


	public void setClassesService(ClassesService classesService) {
		this.classesService = classesService;
	}


	public StaffService getStaffService() {
		return staffService;
	}

	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}

	public PostService getPostService() {
		return postService;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public CoursetypeService getCoursetypeService() {
		return coursetypeService;
	}

	public void setCoursetypeService(CoursetypeService coursetypeService) {
		this.coursetypeService = coursetypeService;
	}
	
	//分页数据
	private int pageNum = 1;
	private int pageSize = 2;

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNum() {
		return pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}

	//简化值栈操作
	public void push(Object o){
		ActionContext.getContext().getValueStack().push(o);
	}
	public void put(String key,Object value){
		ActionContext.getContext().put(key, value);
	}
	public void set(String key,Object o){
		ActionContext.getContext().getValueStack().set(key, o);
	}
	public void putSession(String key,Object value){
		ActionContext.getContext().getSession().put(key, value);
	}
	public void putApplication(String key,Object value){
		ActionContext.getContext().getApplication().put(key, value);
	}

}
