package com.hb.sts03.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;

import com.hb.sts03.model.dto.GuestVo;

public class JdbcDaoImpl implements GuestDao {
	private JdbcOperations jdbcOperations;
	
	public void setJdbcOperations(JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
	}
	
	private RowMapper rowMapper=new RowMapper<GuestVo>(){

		@Override
		public GuestVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new GuestVo(
					rs.getInt("sabun")
					,rs.getString("name")
					,rs.getDate("nalja")
					,rs.getInt("pay")
					);
		}};
	
	@Override
	public List selectAll() {
		String sql = "select * from guest";
		return jdbcOperations.query(sql, rowMapper);
	}

	@Override
	public void insertOne(GuestVo bean) {
		// TODO Auto-generated method stub

	}

	@Override
	public GuestVo selectOne(int sabun) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOne(GuestVo bean) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteOne(int sabun) {
		// TODO Auto-generated method stub

	}

}
