package com.test;

import java.sql.*;
import java.util.*;
import java.time.*;

public class AdminGuestBookDAO {

	// ���� ���(�˻�) �޼ҵ�
	public List<AdminGuestBook> guestBookList(String key, String value) {
		List<AdminGuestBook> result = new ArrayList<AdminGuestBook>();

		// ����) ������ ���� �ۼ��ؾ� �Ѵ�.
		String sql = "SELECT gid, name_, content, regDate, clientIP, blind FROM guestbook";

		switch (key) {

		case "name_":
			sql += " WHERE INSTR(name_, ?)";
			break;

		case "content":
			sql += " WHERE INSTR(content, ?)";
			break;

		case "regDate":
			sql += " WHERE INSTR(CAST(regDate AS CHAR), ?)";
			break;

		case "ALL":
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
				LocalDate regDate = rs.getDate("regDate").toLocalDate();
				String clientIP = rs.getString("clientIP");
				int blind = rs.getInt("blind");

				AdminGuestBook gb = new AdminGuestBook();
				gb.setGid(gid);
				gb.setName_(name_);
				gb.setContent(content);
				gb.setRegDate(regDate);
				gb.setClientIP(clientIP);
				gb.setBlind(blind);

				result.add(gb);

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

	// ���� �Խù� �� ��ȯ �޼ҵ�
	public int totalCount() {
		int result = 0;

		// ����) ������ ���� �ۼ��ؾ� �Ѵ�.
		String sql = "SELECT COUNT(*) AS totalcount FROM guestbook";

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

	// ���� ����ε� �޼ҵ�
	public int blind(AdminGuestBook gb) {
		int result = 0;
		
		String sql = "UPDATE guestbook SET blind=? WHERE gid=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = MySQLConnection.connect();

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, gb.getBlind());
			pstmt.setString(2, gb.getGid());

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

	// ���� ���(�˻�) �޼ҵ�
	public List<AdminGuestBook> picList(String key, String value) {
		List<AdminGuestBook> result = new ArrayList<AdminGuestBook>();
		
		String sql = "SELECT pid, picName, picContent FROM pictureList";
		
		//�˻� ���ؿ� ���� WHERE ���� �߰�
		if (key.equals("pid")) {
			sql += " WHERE pid =? ";
		}
		sql += " ORDER BY pid";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = MySQLConnection.connect();

			pstmt = conn.prepareStatement(sql);
			
			//�˻� ���ؿ� ���� ������ ���ε�
			if (key.equals("pid")) {
				pstmt.setString(1, value);
			}
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String pid = rs.getString("pid");
				String picName = rs.getString("picName");
				String picContent = rs.getString("picContent");

				AdminGuestBook gb = new AdminGuestBook();

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
	
	
	// ���� ����(���� �̸�, ���� ����) �Է� �޼ҵ�
	public int pictureAdd(AdminGuestBook gb) {
		int result = 0;

		String sql = "INSERT INTO pictureList (pid, picName, picContent) VALUES ((SELECT * FROM (SELECT CONCAT('P', LPAD(IFNULL(SUBSTRING(MAX(pid), 2), 0) + 1, 3, 0)) AS newPid FROM pictureList) p), ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = MySQLConnection.connect();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, gb.getPicName());
			pstmt.setString(2, gb.getPicContent());

			result = pstmt.executeUpdate();

		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				MySQLConnection.close();
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}
		}		
		
		return result;
	}
	
	
	//���� ���� ���� �޼ҵ�
	public int pictureRemove(String pid) {
		int result = 0;
		
		String sql = "DELETE FROM picturelist WHERE pid = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = MySQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pid);
			result = pstmt.executeUpdate();

		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				MySQLConnection.close();
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}
		}
		
		return result;
	}

}
