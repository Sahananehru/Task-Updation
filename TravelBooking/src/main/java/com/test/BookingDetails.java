package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
 
public class BookingDetails 
{
	public static void main(String[] args) throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/travel";
		String user = "root";
		String pw = "root@39";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url,user,pw);
//		
//		String sql1 = "insert into bookings values(110,'2025-11-12',10060)";
//		
//		PreparedStatement pst1 = conn.prepareStatement(sql1);
//		
//		pst1.addBatch();
//		pst1.executeBatch();

 
		String sql2 = "select * from bookings";
		PreparedStatement pst2 = conn.prepareStatement(sql2);
		ResultSet rs = pst2.executeQuery();
		while(rs.next())
		{
			System.out.println("BookingID :" + rs.getInt(1) + " Date of Booking : "+ rs.getDate(2) + " Cost: "+ rs.getInt(3));
		}
	}
}
