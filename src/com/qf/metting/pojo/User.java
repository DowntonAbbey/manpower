package com.qf.metting.pojo;
import java.io.Serializable;
import java.util.Date;

/**
 * 	用户实体类
 * @ClassName: User 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author hou
 * @date 2018年8月28日 上午8:45:30
 */
public class User implements Serializable{

	
	private static final long serialVersionUID = 2109394785893430167L;
	
	private int userId;         //用户id

    private String userNickName;   //用户昵称
 
    private String userName;       //登录名
 
    private String password;       //密码

    private int state;          //用户状态 
    
    private String empName;		//职位姓名
    
    private Date createTime;		//创建时间
   
    private int empId;          //这个是职位id

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String userNickName, String userName, String password, int state, String empName,
			Date createTime, int empId) {
		super();
		this.userId = userId;
		this.userNickName = userNickName;
		this.userName = userName;
		this.password = password;
		this.state = state;
		this.empName = empName;
		this.createTime = createTime;
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userNickName=" + userNickName + ", userName=" + userName + ", password="
				+ password + ", state=" + state + ", empName=" + empName + ", createTime=" + createTime + ", empId="
				+ empId + "]";
	}

	

}
