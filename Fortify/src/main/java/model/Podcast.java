package model;

import com.rometools.rome.feed.module.DCModuleImpl;
import com.rometools.rome.feed.synd.SyndEnclosureImpl;
import com.rometools.rome.feed.synd.SyndEntry;
import org.jdom2.Element;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Podcast implements RSSItem{

    private String title;
    private String URL;
    private String author;
    private String imageURL;
    private String description;
    private String category;
    private String language;
    //  private List<SyndEntry> entries;
    private List<Episode> episodes;
    public PodcastFinder feed;

    public Podcast (String URL) throws Exception {
        loadFeed(URL);
        this.URL = URL;
        feed = new PodcastFinder(URL);

    }


    @Override
    public String getLanguage(){
        return language;
    }

    @Override
    public String getDescription(){
        return description;
    }

    @Override
    public String getImageURL(){
        return  imageURL;
    }

    @Override
    public String getCategoy() {
        return category;
    }

    @Override
    public String getTitle () {
        return title;
    }

    @Override
    public String getURL () {
        return URL;
    }
    @Override
    public String getAuthor () {
        return author;
    }


    public void  setFeed(PodcastFinder p){
        this.feed=p;
    }





    @Override
    public List<Episode> getAllEpisodes () {
        return episodes;
    }

    public void loadFeed(String URL) throws Exception {
        feed = new PodcastFinder(URL);
        title = feed.getTitle();
        author = feed.getForeignElementValue("author");
        episodes = getEntriesTitles();
        imageURL=feed.getImageUrl();
        description=feed.getDescription();
        language=feed.getLangage();

    }


    private List<Episode> getEntriesTitles () throws Exception {
        List<Episode> episodeListEntryList = new ArrayList<>();
        List<SyndEntry> entries = feed.getEntries();
        //https://rss.art19.com/levar-burton-reads

        for (final Iterator iter = entries.iterator(); iter.hasNext(); ) {
            final SyndEntry entry = (SyndEntry) iter.next();
            Episode episodeListEntry = new Episode();
            episodeListEntry.setName(entry.getTitle());
            episodeListEntry.setDescription(entry.getDescription().getValue());

            //   final Element foreign = (Element) entry.getForeignMarkup().get(3);
            //System.out.println(foreign.getText());

//      for (final Iterator foreignIterator = entry.getForeignMarkup().iterator(); foreignIterator.hasNext(); ) {
//        final Element foreign = (Element) foreignIterator.next();
//        System.out.println(foreign.get);
//      }
       /*
            for (final Iterator enclosureIterator = entry.getEnclosures().iterator(); enclosureIterator.hasNext(); ) {
                final SyndEnclosureImpl enclosure = (SyndEnclosureImpl) enclosureIterator.next();
                episodeListEntry.setType(enclosure.getType());
                episodeListEntry.setURL(enclosure.getUrl());
            }
*/
            /*for (final Iterator moduleIter = entry.getModules().iterator(); moduleIter.hasNext(); ) {
                final DCModuleImpl module = (DCModuleImpl) moduleIter.next();
                SimpleDateFormat originalDateFormat = new SimpleDateFormat("EE MMM dd hh:mm:ss zz yyyy");
                Date formattedDate = originalDateFormat.parse(module.getDate().toString());
                SimpleDateFormat displayDateFormatter = new SimpleDateFormat("yyyy-MM-dd");
                episodeListEntry.setDate(displayDateFormatter.format(formattedDate));
            }*/

            episodeListEntryList.add(episodeListEntry);
        }

        return episodeListEntryList;

    }
}
