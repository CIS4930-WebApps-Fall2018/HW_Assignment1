package model;

import java.util.Collection;

public class Album {
    private int id;
    private String title;
    private Collection<Track> tracks;

    public Album(int id, String title) {
        this.id = id;
        this.title = title;
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

    public Collection<Track> getTracks() {
        return tracks;
    }

    public void setTracks(Collection<Track> tracks) {
        this.tracks = tracks;
    }

    @Override
    public String toString() {

        return String.format(
                "Album[id=%d, title='%s', tracks='%s']",
                id, title, tracks);
    }

}
