package org.arpit.java2blog.dao;

import org.arpit.java2blog.model.User;
import org.arpit.java2blog.model.UserPage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    public static final int PAGE_SIZE = 10;
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public List<User> list(final String name) {
        Session session = this.sessionFactory.getCurrentSession();
        final Query query = session.createQuery("from User where name = :name");
        query.setParameter("name", name);
        return query.list();
    }

    @Override
    public int showAverageAge() {
        Session session = this.sessionFactory.getCurrentSession();
        List Ages = session.createQuery("select age from User").list();
        if (!Ages.isEmpty()) {
            int result = 0;
            for (Object object : Ages) {
                int a = (Integer) object;
                result += a;
            }
            return result / Ages.size();
        }
        else return 0;
    }

    @Override
    public List<User> getOnlyAdmins() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from User where isAdmin = true").list();
    }

    public void deleteAllUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        session.createQuery("delete from User").executeUpdate();
    }

    public List getAllUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List userList = session.createQuery("from User").list();
        return userList;
    }

    public User getUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User country = (User) session.load(User.class, id);
        return country;
    }

    public User addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        return user;
    }

    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
    }

    public void deleteUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User p = (User) session.load(User.class, id);
        if (null != p) {
            session.delete(p);
        }
    }

    public UserPage listPage(Integer page) {
        Session session = this.sessionFactory.getCurrentSession();
        final Query query = session.createQuery("from User");
        query.setMaxResults(10);
        query.setFirstResult(page * 10);
        final UserPage userPage = new UserPage();
        final List list = query.list();
        String countQ = "Select count (f.id) from User f";
        Query countQuery = session.createQuery(countQ);
        Long countResults = (Long) countQuery.uniqueResult();
//Last Page
        int lastPageNumber = (int) ((countResults / PAGE_SIZE) + 1);
        userPage.setUsers(list);
        userPage.setCurrentPageNumber(page);
        userPage.setLastPageNumber(lastPageNumber);
        return userPage;
    }

}
