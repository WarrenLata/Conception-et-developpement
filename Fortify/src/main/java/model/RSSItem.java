package model;


import java.util.List;

public interface RSSItem {


    public String getCategoy();

    public String getTitle();

    public String getURL();

    public String getAuthor();

    public List<Episode> getAllEpisodes();

  //  public String getCategory();

}
