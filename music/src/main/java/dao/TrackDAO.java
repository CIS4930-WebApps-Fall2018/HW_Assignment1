package main.java.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import main.java.model.*;

public class TrackDAO {
    private JdbcTemplate jdbcTemplate;

    public TrackDAO(JdbcTemplate jdbcTemp) {
        this.jdbcTemplate = jdbcTemp;
    }


}
