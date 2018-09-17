package com.qf.metting.enum1;

public enum Gender {
	man("1","男人"),woman("2","女人"),other("3","其他人");
	private String key;
	private String val;
	private Gender(String key,String val) {
		this.key = key;
		this.val = val;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getVal() {
		return val;
	}
	public void setVal(String val) {
		this.val = val;
	}
	
	
}

