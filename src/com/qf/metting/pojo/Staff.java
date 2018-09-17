package com.qf.metting.pojo;

import java.io.Serializable;
/**
 * 	职位实体类
 * @ClassName: Staff 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author hou
 * @date 2018年8月28日 上午9:38:23
 */
public class Staff implements Serializable{

	
	/** 
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	 */ 
	private static final long serialVersionUID = 8017268454720176398L;

	private int staffId;     //职位id

    private String staffName;   //职位名称

    private String staffDes;    //职位描述

	public Staff() {
		super();
	}

	public Staff(int staffId, String staffName, String staffDes) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.staffDes = staffDes;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffDes() {
		return staffDes;
	}

	public void setStaffDes(String staffDes) {
		this.staffDes = staffDes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", staffName=" + staffName + ", staffDes=" + staffDes + "]";
	}

}
