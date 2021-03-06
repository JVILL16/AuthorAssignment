package List;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AuthorListController implements Initializable {
	
	 private static Logger logger = LogManager.getLogger();
	
	 @FXML private ListView<Author> authorList;
	 private ObservableList<Author> authors;
	    
	 public AuthorListController(ObservableList<Author> authors) {
	    this.authors = authors;
	 }
   @FXML void onAuthorListClicked(MouseEvent event) {
    	try {
    		Author authors = authorList.getSelectionModel().getSelectedItem();
    		if(authors != null) {
    			FXMLLoader loader = new FXMLLoader(this.getClass().getResource("AuthorDetailView.fxml"));
    			loader.setController(new AuthorDetailController(authors));
    			GridPane rootPane = loader.load();
    			Scene scene = new Scene(rootPane, 400, 200);
    			Stage stage = new Stage();
    			stage.setScene(scene);
    			stage.setTitle("Detail View for " + authors.getAuthorFullName());
    			stage.show();
    			
    			logger.info(authors.getAuthorFullName() + " clicked");
    		}
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
			this.authorList.setItems(authors);
	}
	@FXML
	public void switchToAuthorDetailView() throws Exception{
		SingletonSwitcher.getInstance().switchToAuthorDetailView(authorList.getSelectionModel().getSelectedItem());
	}

}
