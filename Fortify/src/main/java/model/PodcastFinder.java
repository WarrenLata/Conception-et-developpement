package model;




import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.jdom2.Element;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;



public class PodcastFinder{
    private URL targetURL;
    private SyndFeed feed;

    public PodcastFinder (String rssURL) {
        try {
            targetURL = new URL(rssURL);
            SyndFeedInput input = new SyndFeedInput();

            try {
                feed = input.build(new XmlReader(targetURL));
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (com.rometools.rome.io.FeedException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getTitle () {
        return feed.getTitle();
    }

   // public String getImage() {return feed.}
    public String getAuthor () {
        return feed.getAuthor();
    }
    public String getCategory () {
        return feed.getCategories().toString();
    }


    public String getForeignElementValue (String el) {
        for (Element element : feed.getForeignMarkup()) {
            if (element.getName() == el) {
                return element.getText();
            }
        }

        return "N/A";
    }

    public List<SyndEntry> getEntries () {
        return feed.getEntries();
    }
}
