package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextField.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SearchView extends HBox {
    private TextField searchField ;
    private HBox searchBar;
    private HBox profilBar;
    private HBox logoPart;
    private ImageView imageView;
    private ImageView profilView;
    private Button button_profil;
    public SearchView() throws FileNotFoundException {
            Image logo_image = new Image(new FileInputStream("images/logo.png"));
            Image profil_image = new Image(new FileInputStream("images/profile_1107788.png"));
            logoPart = new HBox();
            searchBar = new HBox();
            searchField = new TextField();
            button_profil = new Button();
            searchField.setPromptText("Search for podcast or ..");
            searchField.setMaxWidth(350);
            searchField.setMaxHeight(30);
            imageView = new ImageView(logo_image);
            profilView = new ImageView(profil_image);
            imageView.setFitHeight(60);
            imageView.setFitWidth(200);
            profilView.setFitHeight(60);
            profilView.setFitWidth(60);

            profilBar = new HBox();
            button_profil.setGraphic(profilView);
            button_profil.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,new CornerRadii(0),new Insets(0))));
            profilBar.getChildren().add(button_profil);
            searchField.setOnKeyReleased(keyEvent ->
            {
            //requete HTTPS pour get les podcasts
            });
            searchBar.getChildren().add(searchField);
            logoPart.getChildren().add(imageView);
            this.getChildren().add(searchBar);
            this.getChildren().add(logoPart);
            this.getChildren().add(profilBar);

            /*logoPart.setAlignment(Pos.CENTER);
            searchField.setAlignment(Pos.CENTER_LEFT);
            profilBar.setAlignment(Pos.CENTER_RIGHT);*/
            profilBar.setLayoutX(915);

            this.setWidth(1280);
            this.setHeight(80);
            this.setBackground(new Background(new BackgroundFill(Color.web("#3D4BB3"),new CornerRadii(0),new Insets(0))));
    }



}
