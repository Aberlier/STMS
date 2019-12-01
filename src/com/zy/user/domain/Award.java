package com.zy.user.domain;

public class Award {
	private int aid;
	private String award;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAward() {
		return award;
	}
	public void setAward(String award) {
		this.award = award;
	}
	@Override
	public String toString() {
		return "Award [ aid=" + aid + ", award=" + award + "]";
	}
	
	
}
