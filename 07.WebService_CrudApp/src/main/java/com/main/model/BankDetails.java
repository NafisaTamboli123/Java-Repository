package com.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BankDetails 
{
	@Id
	private int bId;
	private String bName;
	private int accNo;
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	
	
}
