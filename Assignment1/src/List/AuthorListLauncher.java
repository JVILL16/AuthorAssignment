package List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;

import java.awt.*;

public class AuthorListLauncher extends Application{

	private ObservableList<Author> authors;
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("MenuPanelNoView.fxml"));
		MenuController menuController = new MenuController(authors);
		loader.setController(menuController);
		Parent rootPane = loader.load();
		menuController.setRootPane(rootPane);
		Scene menuView = new Scene(rootPane, 600, 400);
		primaryStage.setScene(menuView);
		primaryStage.setTitle("List of Authors");
		primaryStage.show();

	}
	@Override
	public void init() throws Exception {
		super.init();

		authors = FXCollections.observableArrayList();
		authors.add(new Author("Ragnar", "Ragnarson", Author.Gender.Male, "https://www.ragnarswebsite.com"));	//Remove after testing
		authors.add(new Author("Sweetie", "Sweetson", Author.Gender.Female));	//Remove after testing
	}


	@Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub
		super.stop();
	}


	public static void main(String[] args) {
		launch(args);

	}

}
