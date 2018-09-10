package main.java.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import main.java.dao.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {

        log.info("Creating tables");


        jdbcTemplate.execute("DROP TABLE tracks IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE tracks(" +
                "id SERIAL, title VARCHAR(255), album INT)");
        jdbcTemplate.execute("INSERT INTO tracks (title,album)"+
                " VALUES ('Track 1', 42)");
        jdbcTemplate.execute("INSERT INTO tracks (title,album)"+
                " VALUES ('Track 2', 42)");
        jdbcTemplate.execute("INSERT INTO tracks (title,album)"+
                " VALUES ('Track 3', 42)");



        jdbcTemplate.execute("DROP TABLE albums IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE albums(" +
                "id INT, title VARCHAR(255))");
        jdbcTemplate.execute("INSERT INTO albums VALUES (42, 'Album 1')");

        jdbcTemplate.query(
                "SELECT * FROM albums", new Object[] { },
                (rs, rowNum) -> new AlbumDAO(rs.getInt("id"), rs.getString("title"),jdbcTemplate)
        ).forEach(album -> log.info(album.toString()));


    }
}
