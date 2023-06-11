package com.stelmasz.tutorial.dao;

import com.stelmasz.tutorial.model.Painting;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

class PaintingRowMapper implements RowMapper {

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Painting(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getFloat("price"),
                rs.getFloat("efficiency")
        );
    }
}
