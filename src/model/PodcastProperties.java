package Model;

import java.util.ArrayList;
import java.util.List;

public class PodcastProperties {
    private String title;
    private String URL;
    private List<Episode> episodeList;

    public PodcastProperties () {

    }

    public void setTitle (String title) {
        this.title = title;
    }

    public void setURL (String URL) {
        this.URL = URL;
    }

    public String getTitle () {
        return title;
    }

    public String getURL () {
        return URL;
    }

    public void setEpisodeList (List<Episode> episodes) {
        episodeList = episodes;
    }

    public List<Episode> getEpisodeList () {
        List<Episode> tempEpisodeList = new ArrayList<>();

        for (Episode episode : episodeList) {
            episode.setName(episode.getName().trim());
            tempEpisodeList.add(episode);
        }
        return tempEpisodeList;
    }
}
