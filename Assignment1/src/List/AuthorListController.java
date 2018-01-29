package List;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class AuthorListController implements Initializable {
	
	 @FXML private ListView<Author> authorList;
	 private ObservableList<Author> authors;
	    
	 public AuthorListController(ObservableList<Author> authors) {
	    this.authors = authors;
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
