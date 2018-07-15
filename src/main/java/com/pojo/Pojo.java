package com.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Pojo {
	private String name;
	private String password;
	@Id
	private String gamil;
	private String cellnum;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGamil() {
		return gamil;
	}
	public void setGamil(String gamil) {
		this.gamil = gamil;
	}
	public String getCellnum() {
		return cellnum;
	}
	public void setCellnum(String cellnum) {
		this.cellnum = cellnum;
	}


}
