package model;

import javafx.beans.InvalidationListener;
import java.util.Observable;

import java.util.ArrayList;
import java.util.List;

import model.PodcastApiFetcher;

public class PodcastApp extends Observable{

    private  PodcastProperties podcastchoisi;
    private ArrayList<PodcastProperties> preference = new ArrayList<>();
    private ArrayList<PodcastProperties>  popular = new ArrayList<>();
    private ArrayList<PodcastProperties> requested = new ArrayList<>();

    private String datajsonfile = "data/iTunes.json" ;


    // Podcast pod= new


    public PodcastApp(String configpath){
        PodcastListLoader podcastData = new PodcastListLoader(configpath);
        podcastData.loadLocalPodcastJSON(preference,datajsonfile);
        podcastchoisi=this.preference.get(0);
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
        return preference;
    }

    public ArrayList<PodcastProperties> getPopular(){ return popular; }

    public ArrayList<PodcastProperties> getRequested(){ return requested; }


}