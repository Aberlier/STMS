package com.zy.user.domain;

import java.io.Serializable;

public class Score implements Serializable,Comparable<Score>{
	private int sid;
	private int eid;
	private int exam;
	private String sname;
	private double chinese;
	private double math;
	private double english;
	private double physics;
	private double chemistry;
	private double politics;
	private double history;
	private double geography;
	private double biology;
	private String avg;
	private double sum;
	private String award;
	private String regionalranking;
	private String provincialranking;
	private String headmaster;
	
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getExam() {
		return exam;
	}
	public void setExam(int exam) {
		this.exam = exam;
	}
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	

	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public double getChinese() {
		return chinese;
	}
	public void setChinese(double chinese) {
		this.chinese = chinese;
	}
	public double getMath() {
		return math;
	}
	public void setMath(double math) {
		this.math = math;
	}
	public double getEnglish() {
		return english;
	}
	public void setEnglish(double english) {
		this.english = english;
	}
	public double getPhysics() {
		return physics;
	}
	public void setPhysics(double physics) {
		this.physics = physics;
	}
	public double getChemistry() {
		return chemistry;
	}
	public void setChemistry(double chemistry) {
		this.chemistry = chemistry;
	}
	public double getPolitics() {
		return politics;
	}
	public void setPolitics(double politics) {
		this.politics = politics;
	}
	public double getHistory() {
		return history;
	}
	public void setHistory(double history) {
		this.history = history;
	}
	public double getGeography() {
		return geography;
	}
	public void setGeography(double geography) {
		this.geography = geography;
	}
	public double getBiology() {
		return biology;
	}
	public void setBiology(double biology) {
		this.biology = biology;
	}	


	public String getAvg() {
		return avg;
	}
	public void setAvg(String avg) {
		this.avg = avg;
	}
	
	
	public String getAward() {
		return award;
	}
	public void setAward(String award) {
		this.award = award;
	}
	public String getRegionalranking() {
		return regionalranking;
	}
	public void setRegionalranking(String regionalranking) {
		this.regionalranking = regionalranking;
	}
	public String getProvincialranking() {
		return provincialranking;
	}
	public void setProvincialranking(String provincialranking) {
		this.provincialranking = provincialranking;
	}
	public String getHeadmaster() {
		return headmaster;
	}
	public void setHeadmaster(String headmaster) {
		this.headmaster = headmaster;
	}
	@Override
	public String toString() {
		return "Score [sid=" + sid + ", eid=" + eid + ", exam=" + exam
				+ ", sname=" + sname + ", chinese=" + chinese + ", math="
				+ math + ", english=" + english + ", physics=" + physics
				+ ", chemistry=" + chemistry + ", politics=" + politics
				+ ", h.istory=" + history + ", geography=" + geography
				+ ", biology=" + biology + ", avg=" + avg + ", sum=" + sum
				+ ", award=" + award + ", regionalranking=" + regionalranking
				+ ", provincialranking=" + provincialranking + ", headmaster="
				+ headmaster + "]";
	}


	@Override
	public int compareTo(Score score) {
		int a=(int)score.sum*100;
		int b=(int)this.sum*100;
				
		return  a - b;
	}
}
