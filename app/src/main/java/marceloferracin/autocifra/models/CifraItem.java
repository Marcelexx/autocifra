package marceloferracin.autocifra.models;

import java.io.Serializable;

/**
 *
 * Created by Marcelo Ferracin on 23/11/2015.
 */

public class CifraItem implements Serializable {
    private String music;
    private String artist;

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
