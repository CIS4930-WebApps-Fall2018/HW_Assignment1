package main.java.model;

public class Track {
    private int id;
    private String title, albumTitle;

    public TrackDAO(int id, String title, String albumTitle) {
        this.id = id;
        this.title = title;
        this.albumTitle = albumTitle;
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
