package dao;



import hibernate.util.HibernateUtil;


import javax.persistence.EntityManager;


//klasa służy do nin powielania kodu w wielu klasach (dostępne w wielu klasach dziedziczących)
public abstract class AbstractDao {
    protected final HibernateUtil hibernateUtil= HibernateUtil.getInstance();
    protected final EntityManager entityManager = hibernateUtil.getEntityManager();
}
