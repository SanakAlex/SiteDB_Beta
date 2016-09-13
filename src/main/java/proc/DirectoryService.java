package proc;

import java.util.List;

public interface DirectoryService {
	public Directory findById(int id);
	public Directory findByName(String name);
	public List<Directory> findAll();
	public List<Directory> getSortedByName();
	public void save(Directory directory);
	public void delete(Directory directory);
}
