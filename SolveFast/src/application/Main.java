package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
//import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
//	@Override
//	public String selectedAnswera = "",selectedAnswerb = "";
	public void start(final Stage primaryStage) {
		try {
			//Parent root = (Parent) FXMLLoader.load(getClass().getResource("gmpg.fxml"));
		    //final Scene scene = new Scene(root);
			Parent home = (Parent)FXMLLoader.load(getClass().getResource("Home.fxml"));
			Scene homescene = new Scene(home);
			//Parent rules = (Parent) FXMLLoader.load(getClass().getResource("Rules.fxml"));
			//final Scene rulescene = new Scene(rules);
			
//			Parent root = (Parent) FXMLLoader.load(getClass().getResource("Timelineexample.fxml"));
			
			
//			scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
//				public void handle(KeyEvent event) {
//					handleKeyPressed(event.getCode());
//				}
//			});
			
//			@FXML
			
		
			homescene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.setWidth(1540);
//			primaryStage.setHeight(820);
            primaryStage.setFullScreen(true);
//            primaryStage.fullScreenProperty().bind(
//                    primaryStage.sceneProperty().isEqualTo(scene)
//                    .or(primaryStage.sceneProperty().isEqualTo(homescene))
//                    .or(primaryStage.sceneProperty().isEqualTo(rulescene))
//                );
			primaryStage.setScene(homescene);
			primaryStage.show();
			
//			Button startbutton,rulesbutton,exitbutton;
//            Button startbutton = (Button) home.lookup("#startbutton");
//            Button exitbutton = (Button) home.lookup("#exitbutton");
//            Button rulesbutton = (Button) home.lookup("#rulesbutton");
//            Button backbutton = (Button) home.lookup("#backbutton");
 

//            startbutton.setOnAction(new EventHandler<ActionEvent>() {
//                public void handle(ActionEvent event) {
//                	primaryStage.setFullScreen(true);
//                    primaryStage.setScene(scene);
//                }
//            });
            
//            exitbutton.setOnAction(new EventHandler<ActionEvent>() {
//                public void handle(ActionEvent event) {
//                    primaryStage.close();
//                }
//            });	
//            rulesbutton.setOnAction(new EventHandler<ActionEvent>() {
//                public void handle(ActionEvent event) {
//                	primaryStage.setFullScreen(true);
//                    primaryStage.setScene(rulescene);
//                }
//            });   
//            backbutton.setOnAction(new EventHandler<ActionEvent>() {
//                public void handle(ActionEvent event) {
//                	primaryStage.setFullScreen(true);
//                    primaryStage.setScene(scene);
//                }
//            });            

			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	public void start(ActionEvent event) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("gmpg.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		

	}
	@FXML
	public void insta(ActionEvent event) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("Rules.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		

	}
	public void logout(ActionEvent event) throws IOException
	{
		Platform.exit();

	}
	@FXML
	public void backtohome(ActionEvent event)throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
	}
	public static void main(String[] args) {
		launch(args);
	}
}


