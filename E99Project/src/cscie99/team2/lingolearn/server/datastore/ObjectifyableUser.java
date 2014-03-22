package cscie99.team2.lingolearn.server.datastore;

import java.io.Serializable;
import java.util.Set;

import javax.jdo.annotations.Index;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.google.gwt.dev.util.collect.HashSet;

import cscie99.team2.lingolearn.shared.Gender;
import cscie99.team2.lingolearn.shared.Language;



@Entity
public class ObjectifyableUser implements Serializable {

	private static final long serialVersionUID = 4690764038062275542L;

	@Id
	String gplusId;					// id from google +
			
	@Index
	String gmail;
	String firstName;
	String lastName;
	Gender gender;
	Language nativeLanguage;
	Set<Language> languages;
	
	public ObjectifyableUser(){}
	
	public ObjectifyableUser( String gplusId, String gmail, String fname,
							String lname, Gender gender, Language nativ ){
		this.gplusId = gplusId;
		this.gmail = gmail;
		this.firstName = fname;
		this.lastName = lname;
		this.gender = gender;
		this.nativeLanguage = nativ;
		this.languages = new HashSet<Language>();
		
		addLanguage(nativ);
	}
	
	public boolean addLanguage( Language lang ){
		return languages.add(lang);
	}

	public String getGplusId() {
		return gplusId;
	}

	public void setGplusId(String gplusId) {
		this.gplusId = gplusId;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Language getNativeLanguage() {
		return nativeLanguage;
	}

	public void setNativeLanguage(Language nativeLanguage) {
		this.nativeLanguage = nativeLanguage;
	}

	public Set<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(Set<Language> languages) {
		this.languages = languages;
	}
	
	
}
