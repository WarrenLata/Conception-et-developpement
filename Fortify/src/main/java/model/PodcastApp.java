package model;

import javafx.beans.InvalidationListener;
import java.util.Observable;

import java.util.ArrayList;
import java.util.List;

public class PodcastApp extends Observable{

    private  PodcastProperties podcastchoisi;
    private ArrayList<PodcastProperties> data = new ArrayList<>();
    private String datajsonfile = "data/iTunes.json" ;


    // Podcast pod= new


    public PodcastApp(String configpath){
        PodcastListLoader podcastData = new PodcastListLoader(configpath);
        podcastData.loadLocalPodcastJSON(data,datajsonfile);
        podcastchoisi=this.data.get(0);
    }
    public PodcastProperties getPodcastChoisi(){
        return podcastchoisi;
    }
    public boolean choose(PodcastProperties podcast){
        if(podcast==null){
            return false;
        }
        podcastchoisi=podcast;
        setChanged();
        notifyObservers();
        return true;
    }
    public ArrayList<PodcastProperties> getData(){
        return data;
    }


}
