package com.stelmasz.tutorial.dao;

import com.stelmasz.tutorial.model.Painting;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.UUID;

public class DbPaintingDao implements PaintingDao {

    private JdbcTemplate jdbcTemplate;

    private static final String GET_PAINTING = "SELECT id, name, price, efficiency FROM paintings WHERE id = ?";
    private static final String ADD_PAINTING = "INSERT INTO paintings (id, name, price, efficiency) VALUES (?,?,?,?)";
    private static final String DELETE_PAINTING = "DELETE FROM paintings WHERE id = ?";

    public DbPaintingDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int addPainting(Painting painting) {
        jdbcTemplate.update(ADD_PAINTING, painting.getId(), painting.getName(), painting.getPrice(), painting.getEfficiency());
        return painting.getId();
    }

    public Painting getPainting(int id) {
        return (Painting) jdbcTemplate.queryForObject(GET_PAINTING, new PaintingRowMapper(), new Object[]{id});
    }

    public int deletePainting(int id) {
        jdbcTemplate.update(DELETE_PAINTING, id);
        return id;
    }
}
