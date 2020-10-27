package sakila.query;

public class StatsQuery {
	public static final String SELECT_DAY="SELECT day, cnt FROM stats WHERE day=? "; 
	public static final String INSERT_STAT="INSERT INTO stats(day,cnt) VALUES(?,1)";
	public static final String UPDATE_STATS="UPDATE stats SET cnt=cnt+1 WHERE day=?";
	public static final String TOTAL_COUNT="SELECT sum(cnt) FROM stats";
}
