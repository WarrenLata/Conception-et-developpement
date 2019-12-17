package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import Misc.ButtonPodDesc;
import model.Podcast;
import model.PodcastApp;
import model.PodcastProperties;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class PodcastsView  extends VBox implements Observer {
    ObservableList<HBox> Podcastitems = FXCollections.observableArrayList();
    ListView<HBox> listPodcasts=new ListView<HBox>(Podcastitems);

    public PodcastsView (PodcastApp application) throws Exception {

        this.setStyle("-fx-background-color:linear-gradient(to top, #1b56af, #1e4f9b, #204888, #234175, #243a62);");
        Label PodcastsName=new Label("Podcast:");
        this.getChildren().add(PodcastsName);

        //ListView
        ArrayList<PodcastProperties> podcasttoadd = application.getData();


        ///
        for (int i=0;i<podcasttoadd.size();i++){
            HBox Container=new HBox();
            PodcastProperties podcast_i=podcasttoadd.get(i);
            Label podcastname=new Label(podcast_i.getTitle());
            //ImageView image=new ImageView(new Image(podcasttoadd.get(i).getImageURL()));
            ImageView image=new ImageView(new Image(new FileInputStream("/home/etudiants/hmiza2u/Bureau/315592.jpg")));
            Label podcastdesc=new Label("CODING WEAAKLY AND QUICKLY");

            ButtonPodDesc play_btn = new ButtonPodDesc("SHOW EPISODES",application,podcast_i);

            Container.getChildren().addAll(image,podcastname,podcastdesc,play_btn);


            Podcastitems.add(Container);

        }
        listPodcasts.setItems(Podcastitems);

        this.getChildren().add(listPodcasts);



    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
