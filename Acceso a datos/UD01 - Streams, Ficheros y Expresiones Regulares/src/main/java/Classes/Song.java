package Classes;

import java.util.Objects;

public class Song {
    String title;
    String singer;

    public Song() {
    }

    public Song(String title, String singer) {
        this.title = title;
        this.singer = singer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(title, song.title) && Objects.equals(singer, song.singer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, singer);
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "title='" + title + '\'' +
                ", singer='" + singer + '\'' +
                '}';
    }
}