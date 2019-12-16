package sample;

import Model.Podcast;
import com.sun.javafx.font.freetype.HBGlyphLayout;
import javafx.collections.FXCollections;
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

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class EpisodeView extends VBox {

        private HBox episodes;

        public EpisodeView(Podcast podcast) throws FileNotFoundException {
            this.setStyle("-fx-background-color:linear-gradient(to top, #1b56af, #1e4f9b, #204888, #234175, #243a62);");
            Label episodeslabel=new Label("Episodes");
            episodeslabel.setStyle("-fx-font-size:14px;-fx-text-fill: white;");
            this.episodes=new HBox();
            // background-image:
            this.episodes.setStyle("-fx-background-color: linear-gradient(to bottom, #1b56af, #1e4f9b, #204888, #234175, #243a62);-fx-border-color:black");
            episodes.setPrefSize(230,251);
            this.episodes.getChildren().add(episodeslabel);
            VBox play_button = new VBox();
            /*for(int i=0;i<podcast.nombreEpisodes;i++){

                //Image image_episode = new Image(new FileInputStream(podcast.episodes.get(i).image));
                Button button_play = new Button();
                Image play_image = new Image(new FileInputStream("images/image_app/play-button-transparent.png"));
                ImageView play_icon = new ImageView(play_image);
                play_icon.setFitHeight(60);
                play_icon.setFitWidth(60);
                //ImageView episode_image_view = new ImageView(image_episode);
                button_play.setGraphic(play_icon);
                //episode.getChildren().add(episode_image_view);

                play_button.getChildren().add(button_play);


            }*/

         //   episodes.getChildren().addAll(list_titre,play_button);
            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setContent(episodes);
            this.getChildren().addAll(scrollPane);
            scrollPane.setPrefHeight(581);
            scrollPane.setPrefWidth(250);
            episodes.setAlignment(Pos.CENTER);
        }
    }

