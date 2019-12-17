package model;

import java.util.ArrayList;
import java.util.List;

public class PodcastListEntry {
    public ArrayList<PodcastProperties> podcasts;

    public ArrayList<PodcastProperties> getProperties () {
        return podcasts;
    }

    public void addPodcast (String title, String URL, String author, String category, List<Episode> episodes) {
      //  podcasts=new ArrayList<PodcastProperties>();
        PodcastProperties prop = new PodcastProperties();
        prop.setTitle(title);
        System.out.println("YOOOO"+title);
        prop.setURL(URL);
        prop.setAuthor(author);
        prop.setEpisodeList(episodes);
        prop.setCategory(category);
        podcasts.add(prop);
    }

    public void removePodcast (int index) {
        podcasts.remove(index);
    }

    public ArrayList<Episode> getEpisodes (int podcastIndex) {
        return (ArrayList<Episode>)podcasts.get(podcastIndex).getEpisodeList();
    }
}
