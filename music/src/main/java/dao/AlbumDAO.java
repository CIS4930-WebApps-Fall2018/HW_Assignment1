package dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import model.*;
import java.util.Collection;
import java.util.ArrayList;

public class AlbumDAO {
    private JdbcTemplate jdbcTemplate;

    public AlbumDAO(JdbcTemplate jdbcTemp) {
        this.jdbcTemplate = jdbcTemp;
    }

    public Album createAlbum(Album album){
        //TODO: Implement this CRUD function
        String query = "INSERT into albums (id, title) values (?,?)";
        this.jdbcTemplate.update(query, album.getId(), album.getTitle());
        return album;
    }

    public Album getAlbum(int id){
        //TODO: Implement this CRUD function
        //Get album and set tracks using getTracksByAlbumId(id) in TracksDAO
        String query = "SELECT * FROM albums WHERE id = ?";
        Album album = this.jdbcTemplate.queryForObject(query, new Object[]{id},
                new BeanPropertyRowMapper<>(Album.class));
        TrackDAO trackDAO = new TrackDAO(jdbcTemplate);
        //Get album and set tracks using getTracksByAlbumId(id) in TracksDAO
        album.setTracks(trackDAO.getTracksByAlbumId(id));

        return album;
    }

    public Collection<Album> getAllAlbums(){
        Collection<Album> albums = new ArrayList<Album>();
        this.jdbcTemplate.query(
                "SELECT * FROM albums", new Object[] { },
                (rs, rowNum) -> new Album(rs.getInt("id"), rs.getString("title"))
        ).forEach(album -> albums.add(album));

        return albums;
    }

    public Album updateAlbum(Album album){
        //TODO: Implement this CRUD function
        return album;
    }

    public boolean deleteAlbum(Album album){
        boolean success = false;
        //TODO: Implement this CRUD function
        return success;
    }



}
