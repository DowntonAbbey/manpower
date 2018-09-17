package com.qf.metting.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 	雇员实体类
 * @ClassName: Employee 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author hou
 * @date 2018年8月28日 上午9:39:34
 */
public class Employee implements Serializable{

	/** 
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	 */ 
	private static final long serialVersionUID = -8915238940480877845L;
	private int empId;		//职位id
	private String empName;    //员工姓名
	private String gender;		//员工性别
	private String telNum;
	private String email;
	private String staffName;
	private String empEdu;
	private String cardNum;
	private String deptName;
	private String empAddress;
	private Date empCreateTime;
	private int staffId;
	private String phone;
	private String political;  //政治面貌
	private String qq;
	private String ems;  //邮箱地址
	private String birth;
	private String volk;  //民族
	private String major;
	private String habiit;
	private String remark; //备注
	private int dId;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTelNum() {
		return telNum;
	}
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getEmpEdu() {
		return empEdu;
	}
	public void setEmpEdu(String empEdu) {
		this.empEdu = empEdu;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPolitical() {
		return political;
	}
	public void setPolitical(String political) {
		this.political = political;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEms() {
		return ems;
	}
	public void setEms(String ems) {
		this.ems = ems;
	}
	
	public String getVolk() {
		return volk;
	}
	public void setVolk(String volk) {
		this.volk = volk;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	public int getdId() {
		return dId;
	}
	public void setdId(int dId) {
		this.dId = dId;
	}
	public Employee() {
		super();
	}
	public Date getEmpCreateTime() {
		return empCreateTime;
	}
	public void setEmpCreateTime(Date empCreateTime) {
		this.empCreateTime = empCreateTime;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", gender=" + gender + ", telNum=" + telNum
				+ ", email=" + email + ", staffName=" + staffName + ", empEdu=" + empEdu + ", cardNum=" + cardNum
				+ ", deptName=" + deptName + ", empAddress=" + empAddress + ", empCreateTime=" + empCreateTime
				+ ", staffId=" + staffId + ", phone=" + phone + ", political=" + political + ", qq=" + qq + ", ems="
				+ ems + ", birth=" + birth + ", volk=" + volk + ", major=" + major + ", habiit=" + habiit + ", remark="
				+ remark + ", dId=" + dId + "]";
	}
	public String getHabiit() {
		return habiit;
	}
	public void setHabiit(String habiit) {
		this.habiit = habiit;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	

	public Employee(int empId, String empName, String gender, String telNum, String email, String staffName, String empEdu,
			String cardNum, String deptName, String empAddress, Date empCreateTime, int staffId, String phone,
			String political, String qq, String ems, String birth, String volk, String major, String habiit,
			String remark, int dId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.gender = gender;
		this.telNum = telNum;
		this.email = email;
		this.staffName = staffName;
		this.empEdu = empEdu;
		this.cardNum = cardNum;
		this.deptName = deptName;
		this.empAddress = empAddress;
		this.empCreateTime = empCreateTime;
		this.staffId = staffId;
		this.phone = phone;
		this.political = political;
		this.qq = qq;
		this.ems = ems;
		this.birth = birth;
		this.volk = volk;
		this.major = major;
		this.habiit = habiit;
		this.remark = remark;
		this.dId = dId;
	}
	
	
}
