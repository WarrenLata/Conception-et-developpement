package sample;

import Model.Episode;
import Model.Podcast;
import Model.PodcastFinder;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Model.Podcast;
import Model.*;
import sample.SearchView;
import java.util.ArrayList;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox global_layout = new VBox();
        HBox centre_page = new HBox();
        VBox favoris = new VBox();
        VBox list_podcast = new VBox();
        //String title, int nombreEpisodes,ArrayList<Episode> episodes, String description
        // String url,String title,String image,String description
        //SearchView searchBar = new SearchView();
      //  Episode episode1 = new Episode("url","episode1","images/image_episode/episode1.png","look at this");
       // Episode episode2 = new Episode("url","episode2","images/image_episode/episode1.png","look at this");
        //Episode episode3 = new Episode("url","episode3","images/image_episode/episode1.png","look at this");

        ArrayList<Episode> episodes = new ArrayList<Episode>();
        //podcast.
        //Podcast podcast = new Podcast("The million",3,episodes,"u must watch" );
       // PodcastFinder feed = new PodcastFinder("http://sw7x7.libsyn.com/rss") ;
        Podcast podcast = new Podcast("http://sw7x7.libsyn.com/rss");

        /*ListView<String> list_titre=new ListView<String>();
        ObservableList<String> items = FXCollections.observableArrayList (podcast.getAllEpisodes().get(1).getName()
        );
        list_titre.setItems(items);
        list_titre.setPrefSize(100, 250);*/

        EpisodeView episode_part = new EpisodeView(podcast);
        centre_page.getChildren().add(favoris);
        centre_page.getChildren().add(list_podcast);
        centre_page.getChildren().add(episode_part);
        favoris.setPrefHeight(581);
        list_podcast.setPrefHeight(581);
        favoris.setPrefWidth(270);
        list_podcast.setPrefWidth(786);

        primaryStage.setTitle("Podhub");
        primaryStage.setScene(new Scene(global_layout, 1280, 800));
        //global_layout.getChildren().add(searchBar);
        global_layout.getChildren().add(centre_page);




        Parent player = FXMLLoader.load(getClass().getResource("sample.fxml"));
      //  primaryStage.setTitle("Hello World");
        //primaryStage.setScene(new Scene(root));
        global_layout.getChildren().add(player);

        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
