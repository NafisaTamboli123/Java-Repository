package com.main.model;


public class Employee 
{
	private int eId;
	private String eName;
	private float salary;
	private long mobileNo;
	private String addr;
	private BankDetails b;
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public BankDetails getB() {
		return b;
	}
	public void setB(BankDetails b) {
		this.b = b;
	}
	
	
}
