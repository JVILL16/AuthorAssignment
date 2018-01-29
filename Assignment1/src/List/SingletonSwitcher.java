package List;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.time.LocalDate;

public class SingletonSwitcher {
        private static SingletonSwitcher instance = null;
    private VBox root, detailBox;
    private AnchorPane listPane;
    private ObservableList<Author> authors;
        protected SingletonSwitcher() {
            // Exists only to defeat instantiation.
        }
        public static SingletonSwitcher getInstance() {
            if(instance == null) {
                instance = new SingletonSwitcher();
            }
            return instance;
        }
        public void switchToAuthorListView() throws Exception{
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("AuthorListView.fxml"));
            loader.setController(new AuthorListController(authors));
            listPane = loader.load();
            root.getChildren().remove(detailBox);
            root.getChildren().add(listPane);
        }
    public void switchToAuthorDetailView() throws Exception{
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("AuthorDetailView.fxml"));
        Author temp = new Author("Ragnar", "Ragnarson", Author.Gender.Male, "http://www.ah-the-aliens-are-abducting-me.biz", "2016-08-16");
        loader.setController(new AuthorDetailController(temp));   //Just for testing
        detailBox = loader.load();
        root.getChildren().remove(listPane);
        root.getChildren().add(detailBox);
    }
    public void setRootPane(Parent rootPane){
        this.root = (VBox) rootPane;
    }
    public void setAuthors(ObservableList<Author> authors){
        this.authors = authors;
    }
}
