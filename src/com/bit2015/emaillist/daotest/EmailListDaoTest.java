package com.bit2015.emaillist.daotest;

import java.sql.SQLException;
import java.util.List;

import com.bit2015.emaillist.dao.EmailListDao;
import com.bit2015.emaillist.vo.EmailListVo;

public class EmailListDaoTest {

	public static void main(String[] args) {
		try {
			// insert 테스트
			// testInsert();
			
			// getList 테스트
			testGetList();
			
		} catch( SQLException ex ) {
			System.out.println( "DB 에러:" + ex );
		}
	}

	public static void testInsert() throws SQLException {
		EmailListVo vo = new EmailListVo();
		vo.setFirstName( "홍" );
		vo.setLastName( "길동" );
		vo.setEmail( "hongildong@gmail.com" );
		
		EmailListDao dao = EmailListDao.getInstance();
		dao.insert(vo);
	}
	
	public static void testGetList() throws SQLException {
		EmailListDao dao = EmailListDao.getInstance();
		List<EmailListVo> list = dao.getList();
		
		for( EmailListVo vo : list ) {
			System.out.println(
			  vo.getNo() + ":" +
			  vo.getFirstName() + ":" +
			  vo.getLastName() + ":" +
			  vo.getEmail()
			);
		}
	}
}
