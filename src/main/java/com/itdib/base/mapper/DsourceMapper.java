package com.itdib.base.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.itdib.base.entity.Dsource;
/**
 * @author @dibyapp, Name : Dibyaprakash, Email : dibyapp@geekyants.com
 * @Project : mt-base-service
 */
public class DsourceMapper implements RowMapper<Dsource> {
	public Dsource mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Dsource dsource = new Dsource();
		dsource.setId(rs.getInt("id"));
		dsource.setTenantId(rs.getString("tenantId"));
		dsource.setUrl(rs.getString("url"));
		dsource.setUsername(rs.getString("username"));
		dsource.setPassword(rs.getString("password"));
		dsource.setDriverClassName(rs.getString("driverClassName"));
		
		return dsource;
	}
}