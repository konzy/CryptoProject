//button.setOnAction( e->{
//string text = textfield.getText(); }


package com.company;
/**
 * Created by Tom on 11/28/2016.
 */


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;

public class GUIinterface extends Application {


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Cipher Stuff");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25,25));

        Scene scene = new Scene(grid, 550, 500);

        primaryStage.setScene(scene);

        Text scenetitle = new Text("Cryptology Project");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label ciphertext = new Label("Cipher-Text:");
        grid.add(ciphertext, 0, 1);

        TextField ciphertextinput = new TextField();
        grid.add(ciphertextinput, 1, 1);

        Label crib = new Label("Known Plain-Text:");
        grid.add(crib, 0, 2);

        TextField known_plaintextInput = new TextField();
        grid.add(known_plaintextInput, 1, 2);

        Label output = new Label("Output");
        grid.add(output, 0, 3);

        TextArea outputoutput = new TextArea();
        grid.add(outputoutput, 1, 3);
        outputoutput.setPrefWidth(300);
        outputoutput.setPrefHeight(400);

        Button btn = new Button("Decipher");
        btn.setOnAction( e->{

            Running runningKey = new Running(ciphertextinput.getText(), known_plaintextInput.getText());
            ArrayList<CipherTextSnippet> snippets = runningKey.getCipherTextSnippets();
            Collections.sort(snippets);

            String acc = "";
            for (CipherTextSnippet snippet : snippets) {
                acc += snippet.getIndex() + " " + snippet.toString() + " " + snippet.getIndexOfCoincidence() + "\r\n";
            }
            outputoutput.setText(acc);
        });
        HBox hbBtn = new HBox(0);
        btn.setPrefWidth(100);
        hbBtn.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn.getChildren().add(btn);
        grid.add(btn, 0, 10);

        Button btn2 = new Button("Clear");
        btn2.setOnAction( e->{
            ciphertextinput.clear();
            known_plaintextInput.clear();
            outputoutput.clear();
        });
        HBox hbBtn2 = new HBox(1);
        btn2.setPrefWidth(100);
        hbBtn2.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn2.getChildren().add(btn2);
        grid.add(btn2, 1, 10);

        primaryStage.show();
    }
}




