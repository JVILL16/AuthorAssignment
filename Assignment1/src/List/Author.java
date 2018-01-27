package List;

import javafx.beans.property.SimpleStringProperty;

public class Author {
	
private SimpleStringProperty authorName;
	
	public Author() {
		authorName = new SimpleStringProperty();
		// need the date and last name and more info
		// might need to change authorName to authorFirstName or firstName
	}

	public Author(String authorName) {
		this();
		
		if(!isValidAuthorName(authorName))
			throw new IllegalArgumentException("Author's name does not exist");
		
		setAuthorName(authorName);
	}
	
	
	public boolean isValidAuthorName(String authorName) {
		if(authorName.length() < 1 || authorName.length() > 50)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "First Name: " + getAuthorName();
	}

	//accessors
	public String getAuthorName() {
		return authorName.get();
	}

	public void setAuthorName(String authorName) {
		this.authorName.set(authorName);
	}
	
	public SimpleStringProperty authorNameProperty() {
		return authorName;
	}
	

}
