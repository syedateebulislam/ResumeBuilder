package com.DemoApp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	String url="jdbc:mysql://localhost:3306/test";
	String dbUsername="root";
	String dbPassword="";//fill DB password here

	public boolean createinDB(String fname,String lname,String gender,String country,String email,String password) {
		
		String sql1="insert into userdetails values(?,?,?,?,?,?)";
		String sql2="insert into user values(?,?)";
		boolean q1=false;
		boolean q2=false;
		
		System.out.println("fname:"+fname+",lname:"+lname+",gender:"+gender+",country:"+country+",email:"+email+",password:"+password);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,dbUsername,dbPassword);
			PreparedStatement st1 = con.prepareStatement(sql1);
			st1.setString(1, fname);
			st1.setString(2, lname);
			st1.setString(3, gender);
			st1.setString(4, country);
			st1.setString(5, email);
			st1.setString(6, password);
			int rowsAffected1=st1.executeUpdate();
			if(rowsAffected1!=0) {
				System.out.println("userdetails Rows affected - "+rowsAffected1);
				q1= true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,dbUsername,dbPassword);
			PreparedStatement st2 = con.prepareStatement(sql2);
			st2.setString(1, fname);
			st2.setString(2, password);
			int rowsAffected2=st2.executeUpdate();
			if(rowsAffected2!=0) {
				System.out.println("user Rows affected - "+rowsAffected2);
				q2= true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(q1 && q2) {
			return true;
		}
		else {
			return false;
		}
			
		}

	
	public boolean readinDb(String username,String password) {
	
	String sql="select * from user where username=? and password=?";

	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,dbUsername,dbPassword);
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, username);
		st.setString(2, password);
		ResultSet rs=st.executeQuery();
		if(rs.next()) {
			return true;
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
		return false;
	}
}
