package List;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import sun.plugin.javascript.navig.Anchor;

import javax.swing.text.html.ListView;

public class MenuController implements Initializable {

    @FXML private ObservableList<Author> authors;
    private AuthorListController alController;
    private VBox root;

    public MenuController(ObservableList<Author> authors) {
        this.authors = authors;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    alController = new AuthorListController(authors);
    }
    @FXML
    void quit(ActionEvent event) throws Exception{
        System.exit(0);
    }
    @FXML
    public void switchToAuthorListView() throws Exception{
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("AuthorListView.fxml"));
        loader.setController(new AuthorListController(authors));
        AnchorPane listPane = loader.load();
        root.getChildren().add(listPane);
    }
    public void setRootPane(Parent rootPane){
        this.root = (VBox) rootPane;
    }
}