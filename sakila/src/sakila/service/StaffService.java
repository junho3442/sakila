package sakila.service;

import java.sql.*;

import DBUtil.DBUtil;
import sakila.dao.StaffDao;
import sakila.dao.StatsDao;
import sakila.vo.Staff;

public class StaffService {
	private StaffDao staffDao;
	private StatsDao statsDao;
	
	public Staff getStaffByKey(Staff paramStaff) {
		staffDao = new StaffDao();
		statsDao = new StatsDao();
		Connection conn = null;
		Staff returnStaff = null;
		
		try {
			DBUtil dbUtil = new DBUtil(); 
			conn = dbUtil.getConnection();
			conn.setAutoCommit(false);
			
			paramStaff.setEmail(paramStaff.getEmail());
			paramStaff.setPassword(paramStaff.getPassword());
			returnStaff = staffDao.selectStaffByKey(conn, paramStaff);
			System.out.println(returnStaff+"<<<< returnStaff");
			conn.commit();
		}catch(Exception e) {
			try {
				conn.rollback();
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return returnStaff;
	}
}
