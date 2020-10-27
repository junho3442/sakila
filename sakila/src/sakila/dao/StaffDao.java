package sakila.dao;

import java.sql.*;

import sakila.query.StaffQuery;
import sakila.vo.Staff;

public class StaffDao {
	public Staff selectStaffByKey(Connection conn, Staff staff)throws Exception{
		Staff returnStaff = null;
		PreparedStatement stmt = conn.prepareStatement(StaffQuery.SELECT_STAFF_BY_KEY);
		stmt.setString(1, staff.getEmail());
		System.out.println(staff.getEmail()+"<<<<staff.getEmail()");
		stmt.setNString(2, staff.getPassword());
		System.out.println(staff.getPassword()+"<<<<staff.getPassword()");
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			returnStaff = new Staff();
			returnStaff.setEmail(rs.getNString("email"));
			returnStaff.setUsername(rs.getNString("username"));
		}
		stmt.close();
		return returnStaff;
	}
}
