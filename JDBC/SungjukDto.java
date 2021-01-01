package ususunmoon;

public class SungjukDto {
	private int bunho;
	private String name;
	private int kor;
	private int mat;
	private int eng;
	private int total;
	private int average;
	private char grade;
	private String schoolcode;
	
	public SungjukDto() {}
	public SungjukDto(int bunho, String name, int kor, int mat, int eng, int total, int average, char grade, String schoolcode) {
		this.bunho = bunho;
		this.name = name;
		this.kor = kor;
		this.mat = mat;
		this.eng = eng;
		this.total = total;
		this.average = average;
		this.grade = grade;
		this.schoolcode = schoolcode;
	}
	public SungjukDto(int bunho, String name, int kor, int mat, int eng, String schoolcode) {
		this.bunho = bunho;
		this.name = name;
		this.kor = kor;
		this.mat = mat;
		this.eng = eng;		
		this.schoolcode = schoolcode;
	}
	
	public String toString() {
		return "이름 : " + name + " 국어 : " + kor + "수학 : " + mat + "영어 : " + eng;
	}
	
	public int getBunho() {
		return bunho;
	}
	
	public String getname() {
		return name;
	}
	
	public int getKor() {
		return kor;
	}
	
	public int getMat() {
		return mat;
	}
	
	public int getEng() {
		return eng;
	}
	
	public int getTotal() {
		return total;
	}
	
	public int getAverage() {
		return average;
	}
	
	public char getGrade() {
		return grade;
	}
	
	public String getSchoolcode() {
		return schoolcode;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setKor(int kor) {
		this.kor = kor;
	}
	
	public void setMat(int mat) {
		this.mat = mat;
	}
	
	public void setEng(int eng) {
		this.eng = eng;
	}
	
	
}
