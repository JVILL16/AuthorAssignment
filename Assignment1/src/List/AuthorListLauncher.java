package List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AuthorListLauncher extends Application{

	private ObservableList<Author> authors;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("AuthorListView.fxml"));
		
		loader.setController(new AuthorListController(authors));
		
		Parent rootPane = loader.load();
		Scene scene = new Scene(rootPane, 600, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("List of Authors");
		primaryStage.show();

	}

	
	@Override
	public void init() throws Exception {
		super.init();
		
		authors = FXCollections.observableArrayList();

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
