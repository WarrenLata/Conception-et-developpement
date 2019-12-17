package sample;

import javafx.scene.layout.BorderPane;
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

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{
        String current=new java.io.File(".").getCanonicalPath();
        System.out.println(current+ " PATH! ");
        PodcastApp pd = new PodcastApp("./src/main/resources");
        System.out.println("La taille de json : " + pd.getData().size());
        System.out.println("la catégorie est : " + pd.getData().get(0).getTitle());
        System.out.println("la catégorie est : " + pd.getData().get(1).getTitle());
        BorderPane global_layout = new BorderPane();
        PodcastsView centre_page = new PodcastsView(pd);
        VBox favoris = new VBox();

        //String title, int nombreEpisodes,ArrayList<Episode> episodes, String description
        // String url,String title,String image,String description
        SearchView searchBar = new SearchView();
        global_layout.setTop(searchBar);
        primaryStage.setTitle("Podhub");
        primaryStage.setScene(new Scene(global_layout, 1280, 800));
        //global_layout.getChildren().add(searchBar);
        global_layout.setCenter(centre_page);



        //  Episode episode1 = new Episode("url","episode1","images/image_episode/episode1.png","look at this");
        // Episode episode2 = new Episode("url","episode2","images/image_episode/episode1.png","look at this");
        //Episode episode3 = new Episode("url","episode3","images/image_episode/episode1.png","look at this");

        //ArrayList<Episode> episodes = new ArrayList<Episode>();
        //podcast.
        //Podcast podcast = new Podcast("The million",3,episodes,"u must watch" );
        // PodcastFinder feed = new PodcastFinder("http://sw7x7.libsyn.com/rss") ;

        /*ListView<String> list_titre=new ListView<String>();
        ObservableList<String> items = FXCollections.observableArrayList (podcast.getAllEpisodes().get(1).getName()
        );
        list_titre.setItems(items);
        list_titre.setPrefSize(100, 250);*/










        VideoPlayerController video = new VideoPlayerController(pd.getPodcastChoisi().getEpisodeList().get(0).getURL());
        //PodcastsView list_podcast=new PodcastsView("http://sw7x7.libsyn.com/rss",video);
        EpisodeView episode_part = new EpisodeView(pd,video);
        global_layout.setRight(episode_part);
        /*
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
        global_layout.setCenter(centre_page);



            */

        Parent player = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //  primaryStage.setTitle("Hello World");
        //primaryStage.setScene(new Scene(root));
        global_layout.setBottom(player);

        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
