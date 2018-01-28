package List;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AuthorDetailController implements Initializable {
	
private static Logger logger = LogManager.getLogger();
	
    @FXML private TextField FirstName;
    @FXML private Button Save;

    private Author authors;
    
    public AuthorDetailController() {
    	
    }
    
    public AuthorDetailController(Author authors) {
    	this();
    	
    	this.authors = authors;
    }
    
    @FXML void saveAuthorClicked(ActionEvent event) {
    	
    	logger.info("Author's info is saved");
    	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		FirstName.textProperty().bindBidirectional(authors.authorNameProperty());
	}

}
