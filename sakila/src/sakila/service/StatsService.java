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
		Calendar today = Calendar.getInstance(); //Calendar.getInstance(현재 날짜를) today에 넣는다
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		String nowDate = dateFormat.format(today.getTime());
										//today 데이터 형식을 yyyy-mm-dd형식으로 변경해서 nowDate에 넣는다
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
				//오늘 날짜에 방문자가 없다면 오늘 날짜를 추가하여 방문자 수 추가
			}else {
				statsDao.updateStats(conn,stats);
				//오늘 날짜에 방문자가 있었다면 방문자 수 추가
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
	
	public Map<String, Object> getStats(){ //오늘 날짜 방문자 수, 총 방문자 수
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
