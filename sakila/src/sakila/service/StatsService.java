package sakila.service;

import java.sql.*;
import java.text.*;
import java.util.*;

import DBUtil.DBUtil;
import sakila.dao.StatsDao;
import sakila.vo.Stats;

public class StatsService {
	private StatsDao statsDao;
	
	private Stats getToday() {
		Calendar today = Calendar.getInstance(); //Calendar.getInstance(���� ��¥��) today�� �ִ´�
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		String nowDate = dateFormat.format(today.getTime());
										//today ������ ������ yyyy-mm-dd�������� �����ؼ� nowDate�� �ִ´�
		Stats stats = new Stats();
		stats.setDay(nowDate); 
		
		return stats;
	}
	
	public void countStats() {
		statsDao = new StatsDao();
		Connection conn = null;
	
	
	try {
			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection();
			
			Stats stats = this.getToday();
			
			if(statsDao.selectDay(conn, stats) == null) {
				statsDao.insertStats(conn, stats);
				//���� ��¥�� �湮�ڰ� ���ٸ� ���� ��¥�� �߰��Ͽ� �湮�� �� �߰�
			}else {
				statsDao.updateStats(conn,stats);
				//���� ��¥�� �湮�ڰ� �־��ٸ� �湮�� �� �߰�
			}
				conn.commit();
		}catch(Exception e) {
			try {
				conn.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Map<String, Object> getStats(){ //���� ��¥ �湮�� ��, �� �湮�� ��
		statsDao = new StatsDao();
		Connection conn = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Stats returnStats = null;
		
		try {
			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection();
			
			Stats stats = this.getToday();
			returnStats = new Stats();
			returnStats.setDay(stats.getDay());
			
			returnStats = statsDao.selectDay(conn, returnStats);
			int totalCount = statsDao.totalCount(conn);
			
			map.put("stats", returnStats);
			map.put("totalCount", totalCount);
			conn.commit();
		}catch(Exception e) {
			try {
				conn.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
				e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
			return map;
	}
}
