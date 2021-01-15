package com.accident.mariadb;

public class AccidentDTO {
	private int year;
	private int accident;
	private int death;
	private int injury;
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setAccident(int accident) {
		this.accident = accident;
	}
	
	public int getAccident() {
		return accident;
	}
	
	public void setDeath(int death) {
		this.death = death;
	}
	
	public int getDeath() {
		return death;
	}
	
	public void setInjury(int injury) {
		this.injury = injury;
	}
	
	public int getInjury() {
		return injury;
	}
}
