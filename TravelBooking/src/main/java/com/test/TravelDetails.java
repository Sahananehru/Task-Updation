package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 
public class TravelDetails {
 
	public static void main(String[] args) throws Exception 
	{
		String url = "jdbc:mysql://localhost:3306/travel";
		String user = "root";
		String password = "root@39";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url,user,password);
		String sql1 = "insert into travel values(?,?)";
		PreparedStatement pst1 = conn.prepareStatement(sql1);
		pst1.setInt(1, 4);
		pst1.setString(2, "Kashmir");
		pst1.addBatch();
		pst1.executeBatch();
		System.out.println("Insertion done");
		String sql2 = "select * from travel";
		PreparedStatement pst2 = conn.prepareStatement(sql2);
		ResultSet rs = pst2.executeQuery();
		while(rs.next())
		{
			System.out.println("TravelID :" + rs.getInt(1) + " Destination : "+ rs.getString(2));
		}
		String sql3 = "delete from travel where tid = ?";
		PreparedStatement pst3 = conn.prepareStatement(sql3);
		pst3.setInt(1, 4);
		pst3.addBatch();
		pst3.executeBatch();
	}
 
}
