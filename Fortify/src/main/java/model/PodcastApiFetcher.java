package model;


 import javafx.scene.layout.BorderPane;
 import kong.unirest.JsonNode;
 import kong.unirest.Unirest;
 import model.Episode;
 import model.Podcast;
 import model.PodcastFinder;
 import javafx.application.Application;
 import javafx.fxml.FXMLLoader;
 import javafx.scene.Parent;
 import javafx.scene.Scene;
 import javafx.scene.layout.VBox;
 import javafx.stage.Stage;
 import model.Podcast;
 import model.*;
 import sample.EpisodeView;
 import sample.SearchView;
 import kong.unirest.json.JSONArray;
 import  kong.unirest.HttpResponse;
 import kong.unirest.json.JSONObject;
 import kong.unirest.json.JSONString;
 import org.apache.http.client.methods.CloseableHttpResponse;
 import org.apache.http.client.methods.HttpGet;
 import org.apache.http.impl.client.CloseableHttpClient;
 import org.apache.http.impl.client.HttpClients;
 import java.util.ArrayList;
 import java.util.List;




public class PodcastApiFetcher {
    public ArrayList<String> listeRss;
    public ArrayList<String> listeRSSpopular;
    public ArrayList<PodcastProperties> listeProperties;
    public ArrayList<PodcastProperties> listepopular;

    public PodcastApiFetcher(){

    }

    public ArrayList<String> seacrch(String motcle,String genre,String dateBefor,String dateafter,String language){
        // ArrayList<String> listeRss= new ArrayList<String>();
        String request="https://listen-api.listennotes.com/api/v2/search?q=";
        String cle="";
        int j=0;
        for(int i=0;i<motcle.length();i++){
            if(motcle.charAt(i)!=' '){
                cle=cle+motcle.charAt(i);
            }
            else{
                cle=cle+"%20";
            }
        }
        System.out.println("cle:" +cle);
        ArrayList<String> liste = new ArrayList<String>();
        if(!genre.equals("")) {

            HttpResponse<JsonNode> response2 = Unirest.get("https://listen-api.listennotes.com/api/v2/genres")
                    .header("X-ListenAPI-Key", "2311beaa41054b63996aa886ce03d339")
                    .asJson();
            JSONArray genres = (JSONArray) response2.getBody().getObject().get("genres");
            for (int i = 0; i < genres.length(); i++) {
                JSONArray array = (JSONArray) response2.getBody().getObject().get("genres");
                JSONObject objet = (JSONObject) array.get(i);
                String object = (String) objet.get("id").toString();
                String THECHOSENONE = (String) objet.get("name");
                //String id=(String) objet.get("name").get;
                if (THECHOSENONE.contains(genre)) {
                    liste.add(object);
                    System.out.println(THECHOSENONE.toString());
                }
            }
        }
        if(liste.size()==0){
            request=request+cle+"&genre_ids="+""+"%2C"+""+"&published_before="+dateBefor+"&published_after="+dateafter+"&language="+language;
        }
        else{
            request=request+cle+"&genre_ids="+liste.get(0)+"%2C"+liste.get(0)+"&language="+language;
        }
        HttpResponse<JsonNode> response4 = Unirest.get(request)
                .header("X-ListenAPI-Key", "2311beaa41054b63996aa886ce03d339")
                .asJson();
        int count= (int)response4.getBody().getObject().get("count");
        for(int i=0;i<count;i++){
            JSONArray array=(JSONArray)response4.getBody().getObject().get("results");
            JSONObject objet=(JSONObject)array.get(i);
            String THECHOSENONE=(String) objet.get("rss");
            listeRss.add(THECHOSENONE);
            //System.out.println(THECHOSENONE.toString());
        }
        // System.out.println(response4.getBody().toString());
        return  listeRss;
    }



    public ArrayList<String> searchpopular(){

        HttpResponse<JsonNode> response4 = Unirest.get("https://listen-api.listennotes.com/api/v2/best_podcasts?genre_ids=02C144&page=2&region=us&safe_mode=1")
                .header("X-ListenAPI-Key", "2311beaa41054b63996aa886ce03d339")
                .asJson();
        int count= (int)response4.getBody().getObject().get("count");
        JSONArray array= (JSONArray)response4.getBody().getObject().get("podcasts");

        for(int i=0;i<5;i++) {
            //JSONArray array=(JSONArray)response4.getBody().getObject().get("results");
            JSONObject objet = (JSONObject) array.get(i);
            String THECHOSENONE = (String) objet.get("rss");
            listeRSSpopular.add(THECHOSENONE);
        }
        return  listeRSSpopular;
    }



    public ArrayList<PodcastProperties> parse() throws Exception {
        ArrayList<Episode> listeEpisode = new ArrayList<Episode>();
        for(int i=0;i<listeRss.size();i++){
            Podcast pod= new Podcast(listeRss.get(i));
            PodcastFinder pdf = new PodcastFinder(listeRss.get(i));
            pod.setFeed(pdf);
            PodcastProperties p= new PodcastProperties();
            p.setLanguage(pdf.getLangage());
            p.setImageUrl(pdf.getImageUrl());
            p.setDescription(pdf.getDescription());
            p.setAuthor(pdf.getAuthor());
            for(int j=0;j<pdf.getEntries().size();j++){
                Episode ep= new Episode();
                ep.setName(pdf.getEntries().get(i).getTitle());
                ep.setURL(pdf.getEntries().get(i).getLink());
                ep.setDescription(pdf.getEntries().get(i).getDescription().getValue());
              //  ep.setType(pdf.getEntries().get(i).get);
                listeEpisode.add(ep);
            }
            p.setEpisodeList(listeEpisode);

            listeProperties.add(p);
        }
        return listeProperties;
    }


    public ArrayList<PodcastProperties> parsepopular() throws Exception {
        ArrayList<Episode> listeEpisode = new ArrayList<Episode>();
        for(int i=0;i<listeRSSpopular.size();i++){
            Podcast pod= new Podcast(listeRSSpopular.get(i));
            PodcastFinder pdf = new PodcastFinder(listeRSSpopular.get(i));
            pod.setFeed(pdf);
            PodcastProperties p= new PodcastProperties();
            p.setLanguage(pdf.getLangage());
            p.setImageUrl(pdf.getImageUrl());
            p.setDescription(pdf.getDescription());
            p.setAuthor(pdf.getAuthor());
            for(int j=0;j<pdf.getEntries().size();j++){
                Episode ep= new Episode();
                ep.setName(pdf.getEntries().get(i).getTitle());
                ep.setURL(pdf.getEntries().get(i).getLink());
                ep.setDescription(pdf.getEntries().get(i).getDescription().getValue());
                //  ep.setType(pdf.getEntries().get(i).get);
                listeEpisode.add(ep);
            }
            p.setEpisodeList(listeEpisode);

            listepopular.add(p);
        }
        return listepopular;
    }



}
