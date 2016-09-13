package proc;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

@Named
public class LinkServiceImp implements LinkService {

	@Inject
	private LinkDao linkDao;
	
	@Override
	public Link findById(int id) {
		return linkDao.findById(id);
	}
	
	@Override
	public List<Link> findByDirectory(String directoryName){
		return linkDao.findByDirectory(directoryName);
	}

	@Override
	public List<Link> findAll() {
		return linkDao.findAll();
	}

	@Override
	public List<Link> getSortedByName() {
		return linkDao.getSortedByName();
	}

	@Override
	public List<Link> getSortedByUtility() {
		return linkDao.getSortedByUtility();
	}

	@Override
	public List<Link> getSortedByAdditionDate() {
		return linkDao.getSortedByAdditionDate();
	}

	@Override
	public List<Link> getSortedByDirectory() {
		return linkDao.getSortedByDirectory();
	}

	@Transactional
	@Override
	public void save(Link link) {
		linkDao.save(link);
	}

	@Override
	public Link findLinkByName(String name) {
		return linkDao.findLinkByName(name);
	}

	@Override
	public List<Link> getSortedByStatus() {
		return linkDao.getSortedByStatus();
	}

	@Override
	public Link findLinkByUrl(String name) {
		return linkDao.findLinkByUrl(name);
	}
	@Transactional
	@Override
	public void delete(Link link) {
		linkDao.delete(link);
	}

}
