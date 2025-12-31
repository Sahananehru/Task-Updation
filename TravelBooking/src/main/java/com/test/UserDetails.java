package com.test;
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
 
public class UserDetails 

{

	public static void main(String[] args) throws Exception

	{

		String url = "jdbc:mysql://localhost:3306/travel";

		String user = "root";

		String pw = "root@39";

		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection(url,user,pw);

		String sql1 = "insert into user values(?,?,?,?)";

		String sql2 = "select * from user";

		PreparedStatement pst2 = conn.prepareStatement(sql2);

		ResultSet rs = pst2.executeQuery();

		while(rs.next())

		{

			System.out.println("userID :" + rs.getInt(1) + " name: "+ rs.getString(2)+" Trans.ID :"+ rs.getInt(3) + " BookingID :"+rs.getInt(4));

		}

	}

}

 
