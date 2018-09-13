package model;

public class Track {
    private int id, albumId;
    private String title ;

    public Track(int id, String title, int albumId) {
        this.id = id;
        this.title = title;
        this.albumId = albumId;
    }
    public Track(int id) {
        this.id = id;
    }

    public Track(String title, int albumId) {
        this.title = title;
        this.albumId = albumId;
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

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    @Override
    public String toString() {

        return String.format(
                "Track[id=%d, title='%s']",
                id, title);
    }

}
