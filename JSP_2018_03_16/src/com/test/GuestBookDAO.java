package com.test;

import java.sql.*;
import java.time.*;
import java.util.*;

public class GuestBookDAO {
	
	//���� �Է� �޼ҵ�
	public int guestBookAdd(GuestBook gb) {
		int result = 0;
		
		String sql = "INSERT INTO guestbook (gid, name_, pw, content, regDate, clientIP, blind) VALUES ((SELECT * FROM (SELECT CONCAT('G', LPAD(IFNULL(SUBSTRING(MAX(gid), 2), 0) + 1, 5, 0)) AS newGid FROM guestbook) g), ?, ?, ?, NOW(), ?,  0)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = MySQLConnection.connect();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, gb.getName_());
			pstmt.setString(2, gb.getPw());
			pstmt.setString(3, gb.getContent());
			pstmt.setString(4, gb.getClientIP());

			result = pstmt.executeUpdate();

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
		
		
		return result;
	}
	
	//���� ���(�˻�) �޼ҵ�
	public List<GuestBook> guestBookList(String key, String value) {
		List<GuestBook> result = new ArrayList<GuestBook>();
		
		//����) �Ϲݻ���� ���� �ۼ��ؾ� �Ѵ�.
		String sql = "SELECT gid, name_, content, regDate FROM guestbook WHERE blind = 0";
		
		// key, value�� �̿��� �˻� ���� ����
		// ->key�� "ALL"�� ���� ��ü ���.
		switch (key) {
		case "ALL":
			sql += "";
			break;
		case "name_":
			sql += " AND INSTR(name_, ?)";
			break;
		case "content":
			sql += " AND INSTR(content, ?)";
			break;
		case "regDate":
			sql += " AND INSTR(regDate, ?)";
			break;
		}
		sql += " ORDER BY gid DESC";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = MySQLConnection.connect();

			pstmt = conn.prepareStatement(sql);
			if (!key.equals("ALL")) {
			    pstmt.setString(1, value);
			}
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String gid = rs.getString("gid");
				String name_ = rs.getString("name_");
				String content = rs.getString("content");
				String regDate = rs.getString("regDate");

				GuestBook gb = new GuestBook();
				gb.setGid(gid);
				gb.setName_(name_);
				gb.setContent(content);
				gb.setRegDate(LocalDate.parse(regDate));

				result.add(gb);

			}
			rs.close();

		} catch (SQLException se) {
			System.out.print(se.getMessage());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				MySQLConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}			
		
		return result;
	}
	
	//���� �Խù� �� ��ȯ �޼ҵ�
	public int totalCount() {
		int result = 0;
		
		//����) �Ϲݻ���� ���� �ۼ��ؾ� �Ѵ�.
		String sql = "SELECT COUNT(*) AS totalCount FROM guestbook WHERE blind = 0";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = MySQLConnection.connect();

			pstmt = conn.prepareStatement(sql);
			// �ܺε����� ���ε� ���� �߰��ϴ� ��ġ
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				result = rs.getInt("totalCount");
			}
			rs.close();

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

		
		return result;
	}
	
	
	//���� ��� �޼ҵ�
	public List<GuestBook> picList() {
		List<GuestBook> result = new ArrayList<GuestBook>();
		
		String sql = "SELECT pid, picName, picContent FROM pictureList ORDER BY pid";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = MySQLConnection.connect();

			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String pid = rs.getString("pid");
				String picName = rs.getString("picName");
				String picContent = rs.getString("picContent");

				GuestBook gb = new GuestBook();

				gb.setPid(pid);
				gb.setPicName(picName);
				gb.setPicContent(picContent);

				result.add(gb);

			}
			rs.close();

		} catch (SQLException se) {
			System.out.print(se.getMessage());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				MySQLConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}		
		
		
		return result;
	}

	
	//���� ���� �޼ҵ�
	public int guestbookRemove(GuestBook gb) {
		int result = 0;
		
		//����) �Ϲݻ���� ���� �ۼ��ؾ� �Ѵ�.
		String sql = "DELETE FROM guestbook WHERE blind=0 AND gid=? AND pw=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = MySQLConnection.connect();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, gb.getGid());
			pstmt.setString(2, gb.getPw());

			result = pstmt.executeUpdate();

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
		
		
		
		return result;
	}
	

	
	//���� ���(�˻�) �޼ҵ� + ����¡ ó��
	public List<GuestBook> guestBookList(String key, String value, int offset, int count) {
		List<GuestBook> result = new ArrayList<GuestBook>();
		
		//����) �Ϲݻ���� ���� �ۼ��ؾ� �Ѵ�.
		String sql = "SELECT gid, name_, content, regDate FROM guestbook WHERE blind = 0";
		
		// key, value�� �̿��� �˻� ���� ����
		// ->key�� "ALL"�� ���� ��ü ���.
		switch (key) {
		case "ALL":
			sql += "";
			break;
		case "name_":
			sql += " AND INSTR(name_, ?)";
			break;
		case "content":
			sql += " AND INSTR(content, ?)";
			break;
		case "regDate":
			sql += " AND INSTR(regDate, ?)";
			break;
		}
		sql += " ORDER BY gid DESC";
		
		//��ü ����� ��츸 ����¡ ó��
		if (key.equals("ALL")) {
			sql += String.format(" LIMIT %s, %s", offset, count);
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = MySQLConnection.connect();

			pstmt = conn.prepareStatement(sql);
			if (!key.equals("ALL")) {
			    pstmt.setString(1, value);
			}
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String gid = rs.getString("gid");
				String name_ = rs.getString("name_");
				String content = rs.getString("content");
				String regDate = rs.getString("regDate");

				GuestBook gb = new GuestBook();
				gb.setGid(gid);
				gb.setName_(name_);
				gb.setContent(content);
				gb.setRegDate(LocalDate.parse(regDate));

				result.add(gb);

			}
			rs.close();

		} catch (SQLException se) {
			System.out.print(se.getMessage());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				MySQLConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}			
		
		return result;
	}
	
	
}
