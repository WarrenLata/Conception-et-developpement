package sample;

import javafx.beans.value.ChangeListener;
import model.Episode;
import model.Podcast;
import com.sun.javafx.font.freetype.HBGlyphLayout;
import javafx.collections.FXCollections;
import javafx.collections.FXCollections.*;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.PodcastApp;
import model.PodcastProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Observable;
import java.util.Observer;

public class EpisodeView extends VBox implements Observer{

    private VBox episodes;
    private ObservableList<HBox> items = FXCollections.observableArrayList();
    private ListView<HBox> titreEpisodes = new ListView<HBox>(items);
    private VideoPlayerController video;
    private Label episodesLabel;
  public void play(VideoPlayerController video, String AudioURL){
      new VideoPlayerController(AudioURL);
  }
    public EpisodeView(PodcastApp app,VideoPlayerController video) throws FileNotFoundException {
        this.video=video;
        app.addObserver(this);
        this.setStyle("-fx-background-color:linear-gradient(to top, #1b56af, #1e4f9b, #204888, #234175, #243a62);");
        episodesLabel=new Label("Episodes of "+app.getPodcastChoisi().getTitle());
        episodesLabel.setStyle("-fx-font-size:14px;-fx-text-fill: white;");
        this.episodes=new VBox();
        // background-image:
        this.episodes.setStyle("-fx-background-color: linear-gradient(to bottom, #1b56af, #1e4f9b, #204888, #234175, #243a62);-fx-border-color:black");
        //episodes.setPrefSize(230,251);
        this.episodes.getChildren().add(episodesLabel);


        for(int i=0;i<app.getPodcastChoisi().getEpisodeList().size();i++){
            Episode podcastepisode=app.getPodcastChoisi().getEpisodeList().get(i);
                HBox episode = new HBox();
                Button play_btn = new Button("PLAY");
                Label titre_episode = new Label(podcastepisode.getName());

            play_btn.setOnAction(e -> play(video,podcastepisode.getURL()));
                episode.getChildren().addAll(titre_episode,play_btn);

                items.add(episode);

                //Image image_episode = new Image(new FileInputStream(podcast.episodes.get(i).image));
                //Button button_play = new Button();
                /*Image play_image = new Image(new FileInputStream("images/image_app/play-button-transparent.png"));
                ImageView play_icon = new ImageView(play_image);
                play_icon.setFitHeight(60);
                play_icon.setFitWidth(60);*/
                //ImageView episode_image_view = new ImageView(image_episode);
                //button_play.setGraphic(play_icon);
                //episode.getChildren().add(episode_image_view);

                //play_button.getChildren().add(button_play);


            }
        titreEpisodes.setItems(items);



        episodes.getChildren().add(titreEpisodes);
        //   episodes.getChildren().addAll(list_titre,play_button);
        //ScrollPane scrollPane = new ScrollPane();
        //scrollPane.setContent(episodes);
        this.getChildren().addAll(episodes);
        //scrollPane.setPrefHeight(581);
        //scrollPane.setPrefWidth(250);
        titreEpisodes.setPrefSize(350,800);
        episodes.setAlignment(Pos.CENTER);
    }

    @Override
    public void update(Observable o, Object arg) {

        PodcastApp app=((PodcastApp) o);
        PodcastProperties podcastchoisi=app.getPodcastChoisi();
        this.episodesLabel.setText("Episodes of " +podcastchoisi.getTitle());
        System.out.println("Updating Episodes for the selected podcast");
        titreEpisodes.getItems().clear();
        for(int i=0;i<app.getPodcastChoisi().getEpisodeList().size();i++){
            Episode podcastepisode=app.getPodcastChoisi().getEpisodeList().get(i);
            HBox episode = new HBox();
            Button play_btn = new Button("PLAY");
            Label titre_episode = new Label(podcastepisode.getName());

            play_btn.setOnAction(e -> play(video,podcastepisode.getURL()));
            episode.getChildren().addAll(titre_episode,play_btn);

            items.add(episode);

        }

    }
}

