package model;

import com.rometools.rome.feed.synd.SyndEntry;

import java.util.ArrayList;
import java.util.List;

public class PodcastListEntry {
    public ArrayList<PodcastProperties> podcasts;

    public PodcastListEntry(ArrayList<PodcastProperties> liste){
        podcasts = liste;
    }
    public PodcastListEntry(){
    }

    public ArrayList<PodcastProperties> getProperties () {
        return podcasts;
    }

    public void addPodcast (String title, String URL, String author, String category,String desciption,String imageURL , String language , List<Episode> episodes) {
      //  podcasts=new ArrayList<PodcastProperties>();
        PodcastProperties prop = new PodcastProperties();
        prop.setTitle(title);
        System.out.println("Titre "+title);
        prop.setURL(URL);
        System.out.println("URL "+title);

        prop.setAuthor(author);
        System.out.println("author "+title);

        prop.setDescription(desciption);
        System.out.println("description "+title);

        prop.setImageUrl(imageURL);
        System.out.println("imageURL "+title);

        prop.setLanguage(language);
        System.out.println("language "+title);

        prop.setEpisodeList(episodes);
        System.out.println("episodes "+title);

        podcasts.add(prop);
        System.out.println("Aadd sort");
    }

    public void removePodcast (int index) {
        podcasts.remove(index);
    }

    public ArrayList<Episode> getEpisodes (int podcastIndex) {
        return (ArrayList<Episode>)podcasts.get(podcastIndex).getEpisodeList();
    }
}
