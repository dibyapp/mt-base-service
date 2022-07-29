package com.itdib.base.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.itdib.base.entity.OrgEntity;

public class OrgEntityMapper implements RowMapper<OrgEntity> {
	public OrgEntity mapRow(ResultSet rs, int rowNum) throws SQLException {

		OrgEntity orgEntity = new OrgEntity();
		orgEntity.setId(rs.getInt("id"));
		orgEntity.setEmail(rs.getString("email"));
		orgEntity.setOrgName(rs.getString("orgName"));
		orgEntity.setFirstName(rs.getString("firstName"));
		orgEntity.setLastName(rs.getString("lastName"));
		orgEntity.setInstanceName(rs.getString("instanceName"));

		return orgEntity;
	}
}