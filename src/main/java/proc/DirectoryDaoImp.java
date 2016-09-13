package proc;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class DirectoryDaoImp implements DirectoryDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Directory findById(int id) {
		Directory d = null;
		d = em.find(Directory.class, id);
		return d;
	}
	
	@Override
	public Directory findByName(String name){
		Directory d = null;
		TypedQuery<Directory> query = em.createQuery("SELECT d FROM Directory d where d.directoryName = :name", Directory.class);
		query.setParameter("name", name);
		d = query.getSingleResult();
		return d;
	}

	@Override
	public List<Directory> findAll() {
		TypedQuery<Directory> query = em.createQuery("SELECT d FROM Directory d", Directory.class);
		return query.getResultList();
	}

	@Override
	public List<Directory> getSortedByName() {
		TypedQuery<Directory> query = em.createQuery("SELECT d FROM Directory d ORDER BY d.directoryName", Directory.class);
		return query.getResultList();
	}

	@Override
	public void save(Directory directory) {
		TypedQuery<Directory> query = em.createQuery("SELECT d FROM Directory d where d.directoryName = :name", Directory.class);
		query.setParameter("name", directory.getDirectoryName());
		if (directory.getId() == 0 && query.getResultList().size()==0) em.persist(directory);
    	else if (directory.getId() != 0) em.merge(directory);
	}

	@Override
	public void delete(Directory directory) {
		if(directory!=null){
			directory = em.merge(directory);
			em.remove(directory);
		}
	}
}
