package Model;


import java.util.List;

public interface RSSItem {


    public String getTitle();

    public String getURL();

    public String getAuthor();

    public List<Episode> getAllEpisodes();

}
