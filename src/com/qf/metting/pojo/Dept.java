package com.qf.metting.pojo;

import java.io.Serializable;
/**
 * 
 * @ClassName: Dept 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author hou
 * @date 2018年9月6日 下午4:30:12
 */
public class Dept implements Serializable{

	/** 
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	 */ 
	private static final long serialVersionUID = 4919459501947706172L;
	private int dId;       //部门的id

	private String dName;     //部门的名字  

    private String dDes;      //部门的描述
    
    public int getdId() {
		return dId;
	}
    
    public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dept(int dId, String dName, String dDes) {
		super();
		this.dId = dId;
		this.dName = dName;
		this.dDes = dDes;
	}

	public void setdId(int dId) {
		this.dId = dId;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getdDes() {
		return dDes;
	}

	public void setdDes(String dDes) {
		this.dDes = dDes;
	}

	@Override
	public String toString() {
		return "Dept [dId=" + dId + ", dName=" + dName + ", dDes=" + dDes + "]";
	}

}
