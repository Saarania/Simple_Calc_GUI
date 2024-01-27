/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Sara Praksova
 */
public class Main extends Application {

    private boolean muzePokracovat = true;
    private int typ;
    //1 +
    //2 -
    //3 *
    //4 /
    private int memory;
    private int memory2;
    private int vysledek;

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        TextArea textArea = new TextArea();
        textArea.setPrefHeight(100);
        textArea.setPrefWidth(600);
        textArea.setFont(Font.font("Courier New", 50));

        HBox hBox = new HBox();
        for (int i = 0; i < 10; i++) {
            Button button = new Button(Integer.toString(i));
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    textArea.setText(textArea.getText() + button.getText());
                }
            });
            hBox.getChildren().add(button);
        }
        root.getChildren().add(hBox);

        Button buttonClear = new Button("Clear");
        buttonClear.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                clear(textArea);
                muzePokracovat = true;
            }
        });
        Button buttonPluse = new Button("+");
        if (muzePokracovat) {
            buttonPluse.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    memory = Integer.parseInt(textArea.getText());
                    typ = 1;
                    textArea.setText("");
                    muzePokracovat = false;
                }
            });
        }
        Button buttonMinuse = new Button("-");
        if (muzePokracovat) {
            buttonMinuse.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    memory = Integer.parseInt(textArea.getText());
                    typ = 2;
                    textArea.setText("");
                    muzePokracovat = false;
                }
            });
        }
        Button buttonNasobeni = new Button("*");
        if (muzePokracovat) {
            buttonNasobeni.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    memory = Integer.parseInt(textArea.getText());
                    typ = 3;
                    textArea.setText("");
                    muzePokracovat = false;
                }
            });
        }
        Button buttonDeleni = new Button("/");
        if (muzePokracovat) {
            buttonDeleni.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    memory = Integer.parseInt(textArea.getText());
                    typ = 4;
                    textArea.setText("");
                    muzePokracovat = false;
                }
            });
        }
        Button buttonEqual = new Button("=");
        buttonEqual.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                memory2 = Integer.parseInt(textArea.getText());
                if (typ == 1) {
                    vysledek = memory + memory2;
                }
                if (typ == 2) {
                    vysledek = memory - memory2;
                }
                if (typ == 3) {
                    vysledek = memory * memory2;
                }
                if (typ == 4) {
                    vysledek = memory / memory2;
                }
                textArea.setText(Integer.toString(vysledek));
                memory = 0;
                memory2 = 0;
                vysledek = 0;
                typ = 0;
                muzePokracovat = true;
            }
        });
        hBox.getChildren().addAll(buttonClear, buttonPluse, buttonMinuse, buttonNasobeni, buttonDeleni, buttonEqual);
        Scene scene = new Scene(root, 700, 400);
        root.getChildren().addAll(textArea);

        primaryStage.setTitle("Calc");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void clear(TextArea textArea) {
        textArea.setText("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
