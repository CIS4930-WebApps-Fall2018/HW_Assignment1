package main.java.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.Collection;
import java.util.ArrayList;

public class AlbumDAO {
    private int id;
    private String title;
    private Collection<TrackDAO> tracks;
    private JdbcTemplate jdbcTemplate;

    public AlbumDAO(int id, String title, JdbcTemplate jdbcTemp) {
        this.id = id;
        this.title = title;
        this.jdbcTemplate = jdbcTemp;
        this.tracks = this.createTracks();
    }

    private Collection<Track> getTracks() {
        Collection<Track> trackCollection = new ArrayList<TrackDAO>();

        this.jdbcTemplate.query(
                "SELECT id, title FROM tracks WHERE album = ?", new Object[] { this.id },
                (rs, rowNum) -> new TrackDAO(rs.getInt("id"), rs.getString("title"))
                ).forEach(track -> trackCollection.add(track) );


        return trackCollection;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Collection<TrackDAO> getTracks() {
        //Show queries using 2 tables
        /*
        jdbcTemplate.query(
                "SELECT id, title FROM track WHERE album = ?", new Object[] { this.id },
                (rs, rowNum) -> new TrackDAO(rs.getInt("id"), rs.getString(“title"))
                );


                        //Show queries using 3 tables
*/
        return tracks;
    }

    public void setTracks(Collection<TrackDAO> tracks) {
        this.tracks = tracks;
    }


    @Override
    public String toString() {

        return String.format(
                "Album[id=%d, title='%s', tracks='%s']",
                id, title, tracks);
    }

}
