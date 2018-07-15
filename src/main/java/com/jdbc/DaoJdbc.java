package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;

import com.iempolye.IEmployee;
import com.pojo.Pojo;

public class DaoJdbc implements IEmployee{
	public void mapping(Pojo p) {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/suri", "root", "Suresh");
			PreparedStatement ps = connection
					.prepareStatement("insert into pojo (name,password,gamil,cellnum)values(?,?,?,?)");
			ps.setString(1, p.getName());
			ps.setString(2, p.getPassword());
			ps.setString(3, p.getGamil());
			ps.setString(4, p.getCellnum());
			int executeUpdate = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	public List<Pojo> login(Pojo p) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/suri","root", "Suresh");
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM pojo Where gamil = ? AND password = ?");
		ps.setString(1,p.getGamil());
		ps.setString(2, p.getPassword());
		ResultSet rs = ps.executeQuery();
		List<Pojo> list = new ArrayList<Pojo>();
		while(rs.next()) {
			Pojo login = new Pojo();
			login.setName(rs.getString("name"));
			login.setGamil(rs.getString("gamil"));
			login.setCellnum(rs.getString("cellnum"));
			login.setPassword(rs.getString("password"));
			list.add(login);
		}
		return list;
		
	}
	

	public List<Pojo> getall1(Pojo p) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/suri", "root",
				"Suresh");
		PreparedStatement ps = connection.prepareStatement("select *from Pojo");
		/*ps.setString(1, p.getName());
		ps.setString(2, p.getPassword());
		ps.setString(3, p.getGamil());
		ps.setString(4, p.getCellnum());
		*/ResultSet set = ps.executeQuery();
		ArrayList<Pojo> list1 = new ArrayList<Pojo>();

		while (set.next()) {
			Pojo pojo = new Pojo();
			pojo.setName(set.getString("name"));
			pojo.setPassword(set.getString("password"));
			pojo.setGamil(set.getString("gamil"));
			pojo.setCellnum(set.getString("cellnum"));

			list1.add(pojo);
		}
		return list1;

	}
	public void delete(String gamil,Pojo p) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/suri", "root",
				"Suresh");
		PreparedStatement ps = connection.prepareStatement("delete from Pojo where gamil=?");
		ps.setString(1,p.getGamil() );
		int i = ps.executeUpdate();
		

	}
	/*public void deleteall() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/suri", "root",
				"Suresh");
		PreparedStatement ps = connection.prepareStatement("delete from Pojo where gamil=?");*/

}
