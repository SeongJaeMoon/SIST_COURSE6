package com.test;

import java.util.*;
import java.sql.*;

public class MemberDAO {

	//출력 액션 메소드
	public void method() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = MySQLConnection.connect();
			
			System.out.println("데이터베이스 연결 성공!");
			
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				MySQLConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
	}
	
}
