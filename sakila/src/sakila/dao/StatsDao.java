package sakila.dao;

import java.sql.*;

import sakila.query.StatsQuery;
import sakila.vo.Stats;

public class StatsDao {
	public Stats selectDay(Connection conn, Stats stats) throws Exception{
		Stats returnStats = null;
		
		
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.SELECT_DAY);
		stmt.setNString(1, stats.getDay());
		ResultSet rs = stmt.executeQuery(); //StatsQueryŬ������ �ִ� SELECT_DAY���� ���� (��¥������ ������ ��)
		System.out.println(stats.getDay()+"dao/getDay");
		
		if(rs.next()) {
			returnStats = new Stats();
			returnStats.setDay(rs.getString("day")); 
			returnStats.setCnt(rs.getLong("cnt")); // �߰��� �湮�� ���� returnStats.setCnt�� �ִ´�
		}
		
		return returnStats;
	}
	
	public int totalCount(Connection conn)throws Exception{
		int totalCount = 0;
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.TOTAL_COUNT);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			totalCount = rs.getInt("sum(cnt)"); // ��¥ ������� �� �湮�� ��
		}
		return totalCount;
	}
	
	public void insertStats(Connection conn, Stats stats)throws Exception{
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.INSERT_STAT);
		stmt.setNString(1, stats.getDay());
		stmt.executeUpdate();
	}
	
	public void updateStats(Connection conn, Stats stats)throws Exception{
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.UPDATE_STATS);
		stmt.setString(1,stats.getDay());
		stmt.executeQuery();
	}
}
