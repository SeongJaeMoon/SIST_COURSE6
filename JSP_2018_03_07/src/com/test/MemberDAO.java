package com.test;

import java.util.*;
import java.sql.*;

public class MemberDAO {

	//��� �׼� �޼ҵ�
	public void method() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = MySQLConnection.connect();
			
			System.out.println("�����ͺ��̽� ���� ����!");
			
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
