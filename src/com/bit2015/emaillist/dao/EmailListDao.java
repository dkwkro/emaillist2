package com.bit2015.emaillist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bit2015.emaillist.vo.EmailListVo;

public class EmailListDao {
	//singleton 패턴
	private static EmailListDao instance = null;
	
	private EmailListDao(){
		
	}
	public static EmailListDao getInstance(){
		if (instance==null){
			instance=new EmailListDao();
		}
		
		return instance;
	}
	//
	private Connection getConnection() throws SQLException {
		Connection conn = null;

		try {
			// 1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻기
			conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "bitdb", "bitdb");
		
		} catch( ClassNotFoundException ex ) {
			System.out.println( "드라이버 오류 :" + ex );
		}
		
		return conn;
	}
	
	public List<EmailListVo> getList()
		throws SQLException {
		List<EmailListVo> list = new ArrayList<EmailListVo>();

		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		
		String sql = "select * from email_list";
		ResultSet rs = stmt.executeQuery( sql );
		
		while( rs.next() ) {
			long no = rs.getLong( 1 );
			String firstName = rs.getString( 2 );
			String lastName = rs.getString( 3 );
			String email = rs.getString( 4 );
			
			EmailListVo vo = new EmailListVo();
			vo.setNo(no);
			vo.setFirstName(firstName);
			vo.setLastName(lastName);
			vo.setEmail(email);
			
			list.add( vo );
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
		return list;
	}
		
	public void insert( EmailListVo vo ) 
			throws SQLException {
		
		Connection conn = getConnection();
		
		String sql =
			" insert" + 
		    " into email_list" +  
		    " values (email_list_no_seq.nextval, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString( 1, vo.getFirstName() );
		pstmt.setString( 2, vo.getLastName() );
		pstmt.setString( 3, vo.getEmail() );
		/**/
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
}
