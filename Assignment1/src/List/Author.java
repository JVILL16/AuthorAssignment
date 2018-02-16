package List;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;
import java.util.Date;


/**
 * 
 * @author CS 4743 Assignment 1 by Jheremi Villarreal and Manuel Gomez
 *
 */
public class Author {
	
private SimpleStringProperty authorFirstName, authorLastName, authorWebsite, authorGender;	//Not all of these are great as StringProperties, but for now it'll have to do.
private ObjectProperty<LocalDate> authorBirthDate;
	public enum Gender{	//Having an enum as a public field should be safe I think, since it's a constant.
		Male,
		Female
	}

	public Author() {
		authorFirstName = new SimpleStringProperty();
		authorLastName = new SimpleStringProperty();
		authorWebsite = new SimpleStringProperty();
		authorGender = new SimpleStringProperty();
		authorBirthDate = new SimpleObjectProperty<>();
		//authorBirthDate = new LocalDate(3,3,3);
		// need the date and last name and more info
	}

	public Author(String authorFirstName, String authorLastName) {
		this();
		if(!isValidAuthorName(authorFirstName) || !isValidAuthorName(authorLastName))
			throw new IllegalArgumentException("Author's name does not exist");
		
		setAuthorFirstName(authorFirstName);
		setAuthorLastName(authorLastName);
	}

	public Author(String authorFirstName, String authorLastName, Gender authorGender) {
		this(authorFirstName, authorLastName);
		 setAuthorGender(authorGender.toString());
	}
	public Author(String authorFirstName, String authorLastName, Gender authorGender, String authorWebsite) {
		this(authorFirstName, authorLastName, authorGender);
		this.authorWebsite.setValue(authorWebsite);
	}
	public Author(String authorFirstName, String authorLastName, Gender authorGender, String authorWebsite, String authorDOBString) {
		this(authorFirstName, authorLastName, authorGender, authorWebsite);
		this.authorBirthDate.setValue(LocalDate.parse(authorDOBString));
	}
	
	public boolean isValidAuthorName(String authorName) {
		if(authorName.length() < 1 || authorName.length() > 50)	//This runs for both first and last making max chars 100, idk if you want to change that.
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Full Name: " + getAuthorFirstName() + " " + getAuthorLastName();
	}

	/**
	 * Everything Below Here should be mutators/accesors/SimpleStringProperties, please feel free to ignore all of it.
	 */

	public String getAuthorFirstName() {
		return authorFirstName.get();
	}

	public SimpleStringProperty authorFirstNameProperty() {
		return authorFirstName;
	}

	public String getAuthorWebsite() {
		return authorWebsite.get();
	}

	public SimpleStringProperty authorWebsiteProperty() {
		return authorWebsite;
	}

	public String getAuthorGender() {
		return authorGender.get();
	}

	public SimpleStringProperty authorGenderProperty() {
		return authorGender;
	}

	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName.set(authorFirstName);
	}

	public void setAuthorLastName(String authorLastName) {
		this.authorLastName.set(authorLastName);
	}

	public void setAuthorWebsite(String authorWebsite) {
		this.authorWebsite.set(authorWebsite);
	}

	public void setAuthorGender(String authorGender) {
		this.authorGender.set(authorGender);
	}

	public String getAuthorLastName() {

		return authorLastName.get();
	}

	public ObjectProperty<LocalDate> authorBirthDateProperty() { return authorBirthDate; }
	public SimpleStringProperty authorLastNameProperty() { return authorLastName;  }
	public String getAuthorFullName() {
		return authorFirstName.get() + " " + authorLastName.get();
	}

	public void setAuthorName(String authorFirstName, String authorLastName) {
		this.authorFirstName.set(authorFirstName);
		this.authorFirstName.set(authorLastName);
	}
}
