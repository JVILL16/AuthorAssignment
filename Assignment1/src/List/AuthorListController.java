package List;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

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

}
