package List;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AuthorDetailLauncher extends Application{
	
	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("AuthorDetailView.fxml"));
		
		loader.setController(new AuthorDetailController(new Author("Ragnar", "Ragnarson", Author.Gender.Male, "https://www.ragnarswebsite.com")));
		
		GridPane rootPane = loader.load();
		Scene scene = new Scene(rootPane, 400, 200);
		stage.setScene(scene);
		stage.setTitle("Author Details");
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}

