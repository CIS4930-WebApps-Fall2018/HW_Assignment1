package main.java.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import main.java.model.*;
import java.util.Collection;
import java.util.ArrayList;

public class AlbumDAO {
    private JdbcTemplate jdbcTemplate;

    public AlbumDAO(JdbcTemplate jdbcTemp) {
        this.jdbcTemplate = jdbcTemp;
    }

    private Collection<Track> getTracks() {
        Collection<Track> trackCollection = new ArrayList<Track>();
/*
        this.jdbcTemplate.query(
                "SELECT id, title FROM tracks WHERE album = ?", new Object[] { this.id },
                (rs, rowNum) -> new Track(rs.getInt("id"), rs.getString("title"))
                ).forEach(track -> trackCollection.add(track) );
*/

        return trackCollection;
    }

    public Album createAlbum(Album album){
        //TODO: Implement this CRUD function
        return album;
    }
    public Album getAlbum(int id){
        Album album = new Album(id, "");
        //TODO: Implement this CRUD function
        return album;
    }


}
