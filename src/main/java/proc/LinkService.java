package proc;

import java.util.List;

public interface LinkService {
	public Link findById(int id);
	public Link findLinkByName(String name);
	public Link findLinkByUrl(String name);
	public List<Link> findByDirectory(String directoryName);
	public List<Link> findAll();
	public List<Link> getSortedByName();
	public List<Link> getSortedByUtility();
	public List<Link> getSortedByAdditionDate();
	public List<Link> getSortedByDirectory();
	public List<Link> getSortedByStatus();
	public void save(Link link);
	public void delete(Link link);
}
