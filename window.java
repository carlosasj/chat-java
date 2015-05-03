package chatjava;

import javafx.application.*;
import javafx.event.*;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

import java.security.Timestamp;

public class window extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	private final static String newline = "\n";

	public void start(Stage primaryStage) {
		primaryStage.setTitle("Chat IRC");

		HBox hb = new HBox();
		TextArea ta = new TextArea();
		TextField tf = new TextField();
		VBox vb = new VBox();

		HBox.setHgrow(tf, Priority.ALWAYS);
		VBox.setVgrow(ta, Priority.ALWAYS);

		Button btn = new Button();
		btn.setText("Send");
		btn.setOnAction(event -> {
			System.out.println(tf.getText());
			ta.appendText(  ">\t" + tf.getText() + newline);
			tf.clear();
			tf.requestFocus();
		});

		btn.setDefaultButton(true);

		hb.getChildren().add(tf);
		hb.getChildren().add(btn);

		vb.getChildren().add(ta);
		vb.getChildren().add(hb);

		Scene scene = new Scene(vb);
		primaryStage.setScene(scene);
		primaryStage.show();



		ta.setEditable(false);
		tf.requestFocus();
	}
}
