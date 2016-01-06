package marceloferracin.autocifra.models;

import java.io.Serializable;

/**
 *
 * Created by Marcelo Ferracin on 24/11/2015.
 */

public class PlaylistItem implements Serializable {
    private String playlist;
    private String contributor;

    public String getPlaylist() {
        return playlist;
    }

    public void setPlaylist(String playlist) {
        this.playlist = playlist;
    }

    public String getContributor() {
        return contributor;
    }

    public void setContributor(String contributor) {
        this.contributor = contributor;
    }
}
