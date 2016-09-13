package proc;

import java.sql.Timestamp;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import validator.LinkFieldUnique;
import validator.UrlUnique;

@Entity
public class Link {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int linkId;
	@Size(max=60)
	@LinkFieldUnique
	@Column(unique=true)
	@NotEmpty(message="Name can not be empty")
    private String linkName;
	@Size(max=150)
	@UrlUnique
	@Column(unique=true)
	@NotEmpty(message="Url can not be empty")
	private String url;
	@NotNull(message="Utility can not be empty")
	@Min(1)
	@Max(5)
	private int utility;
	@Size(max=100)
	@NotEmpty(message="Description can not be empty")
	private String description;
	private Timestamp additionDate;
	private boolean status;
	@NotNull(message="Directory can not be null")
	@ManyToOne
	@JoinColumn(name="directoryId")
	private Directory directory;
	
	public Link(){}
	public int getLinkId() {
		return linkId;
	}
	public void setLinkId(int id) {
		this.linkId = id;
	}
	public String getLinkName() {
		return linkName;
	}
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getUtility() {
		return utility;
	}
	public void setUtility(int utility) {
		this.utility = utility;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getAdditionDate() {
		return additionDate;
	}
	public void setAdditionDate(Timestamp additionDate) {
		this.additionDate = additionDate;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Directory getDirectory() {
		return directory;
	}
	public void setDirectory(Directory directory) {
		this.directory = directory;
	}
	
	
}
