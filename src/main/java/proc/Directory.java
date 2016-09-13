package proc;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import validator.DirectoryFieldUnique;
@Entity
public class Directory {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	@Size(max=60)
	@DirectoryFieldUnique
	@NotEmpty(message="Name can not be empty")
    private String directoryName;
	
	public Directory(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDirectoryName() {
		return directoryName;
	}

	public void setDirectoryName(String directoryName) {
		this.directoryName = directoryName;
	}
	
	
}
