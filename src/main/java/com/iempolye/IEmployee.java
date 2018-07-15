package com.iempolye;

import java.sql.SQLException;
import java.util.List;

import com.pojo.Pojo;

public interface IEmployee {
	public void mapping(Pojo p);
	public List<Pojo> login(Pojo p) throws ClassNotFoundException, SQLException;
	public List<Pojo> getall1(Pojo p) throws ClassNotFoundException, SQLException;
	public void delete(String gamil,Pojo p) throws ClassNotFoundException, SQLException;
/*	public void deleteall(String gamil);
*/}
