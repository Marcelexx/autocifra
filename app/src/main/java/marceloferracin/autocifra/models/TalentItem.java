package marceloferracin.autocifra.models;

/**
 *
 * Created by Marcelo Ferracin on 02/12/2015.
 */

public class TalentItem {
    private Profile profile;
    private String music;
    private String artist;

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

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
