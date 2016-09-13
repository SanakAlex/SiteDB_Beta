package proc;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class LinkDaoImp implements LinkDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Link findById(int id) {
		Link l = null;
		l = em.find(Link.class, id);
		return l;
	}
	
	@Override
	public List<Link> findByDirectory(String directoryName){
		TypedQuery<Link> query = em.createQuery("SELECT l FROM Link l where l.directory.directoryName = :directoryName", Link.class);
		query.setParameter("directoryName", directoryName);
		return query.getResultList();
	}

	@Override
	public List<Link> findAll() {
		TypedQuery<Link> query = em.createQuery("SELECT l FROM Link l", Link.class);
		return query.getResultList();
	}

	@Override
	public List<Link> getSortedByName() {
		TypedQuery<Link> query = em.createQuery("SELECT l FROM Link l ORDER BY l.linkName", Link.class);
		return query.getResultList();
	}
	
	@Override
	public List<Link> getSortedByUtility() {
		TypedQuery<Link> query = em.createQuery("SELECT l FROM Link l ORDER BY l.utility DESC", Link.class);
		return query.getResultList();
	}

	@Override
	public List<Link> getSortedByAdditionDate() {
		TypedQuery<Link> query = em.createQuery("SELECT l FROM Link l ORDER BY l.additionDate DESC", Link.class);
		return query.getResultList();
	}

	@Override
	public List<Link> getSortedByDirectory() {
		TypedQuery<Link> query = em.createQuery("SELECT DISTINCT l FROM Link l ORDER BY l.directory.directoryName", Link.class);
		return query.getResultList();
	}
	
	@Override
	public List<Link> getSortedByStatus() {
		TypedQuery<Link> query = em.createQuery("SELECT DISTINCT l FROM Link l ORDER BY l.status", Link.class);
		return query.getResultList();
	}

	@Override
	public void save(Link link) {
		TypedQuery<Link> queryNames = em.createQuery("SELECT l FROM Link l where l.linkName = :name or l.url = :url", Link.class);
		queryNames.setParameter("name", link.getLinkName());
		queryNames.setParameter("url", link.getUrl());
		if (link.getLinkId()==0 && queryNames.getResultList().size()==0) em.persist(link);
    	else if (link.getLinkId()!=0) em.merge(link);
	}

	@Override
	public Link findLinkByName(String name) {
		Link link = null;
		TypedQuery<Link> query = em.createQuery("SELECT l FROM Link l where l.linkName = :name", Link.class);
		query.setParameter("name", name);
		link = query.getSingleResult();
		return link;
	}

	@Override
	public Link findLinkByUrl(String name) {
		Link link = null;
		TypedQuery<Link> query = em.createQuery("SELECT l FROM Link l where l.url = :name", Link.class);
		query.setParameter("name", name);
		link = query.getSingleResult();
		return link;
	}

	@Override
	public void delete(Link link) {
		if(link!=null){
			link = em.merge(link);
			em.remove(link);
		}
	}
}
