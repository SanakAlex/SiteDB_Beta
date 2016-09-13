package proc;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

@Named
public class DirectoryServiceImp implements DirectoryService {

	@Inject
	private DirectoryDao directoryDao;
	
	@Override
	public Directory findById(int id) {
		return directoryDao.findById(id);
	}
	
	@Override
	public Directory findByName(String name){
		return directoryDao.findByName(name);
	}

	@Override
	public List<Directory> findAll() {
		return directoryDao.findAll();
	}

	@Override
	public List<Directory> getSortedByName() {
		return directoryDao.getSortedByName();
	}
	
	@Transactional
	@Override
	public void save(Directory directory) {
		directoryDao.save(directory);
	}
	@Transactional
	@Override
	public void delete(Directory directory) {
		directoryDao.delete(directory);
	}

}
