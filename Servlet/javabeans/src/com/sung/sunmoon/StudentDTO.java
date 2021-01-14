package com.sung.sunmoon;

public class StudentDTO {
	private int bunho;
	private String name;
	private int kor;
	private int mat;
	private int eng;
	private int total;
	private float average;
	private String grade;	
	private String schoolcode;
	
	public int getBunho() {
		return bunho;
	}
	public void setBunho(int bunho) {
		this.bunho = bunho;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}	
	
	public void setMat(int mat) {
		this.mat = mat;
	}
	
	public int getMat() {
		return mat;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	public float getTotal() {
		return total;
	}
	
	public void setAvg(float average) {
		this.average = average;
	}
	
	public float getAvg() {
		return average;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public String getGrade() {
		return grade;
	}
	
	public void setSchoolCode(String schoolcode) {
		this.schoolcode = schoolcode;
	}
	
	public String getSchoolCode() {
		return schoolcode;
	}
	
	
}
