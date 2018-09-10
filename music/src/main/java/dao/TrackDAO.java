package main.java.dao;

public class TrackDAO {
    private int id;
    private String title, albumTitle;

    public TrackDAO(int id, String title) {
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

    public String getAlbumTitle() {
        //Show query using 2 tables

        //Show query using 3 tables
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }


    @Override
    public String toString() {

        return String.format(
                "Track[id=%d, title='%s']",
                id, title);
    }

}
