package spring.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.model.Group;
import spring.repository.interfaces.GroupInterface;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class GroupRepository implements GroupInterface {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Group> findAllGroups(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c from Group c where c.company.id="+id, Group.class).getResultList();
    }

    @Override
    public Group findByIdGroup(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Group.class, id);
    }


    @Override
    public void saveGroup(Group group) {
        Session session = sessionFactory.getCurrentSession();
        session.save(group);
    }

    @Override
    public void deleteByIdGroup(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Group where id="+id).executeUpdate();
    }

    @Override
    public void updateByIdGroup(Long id, Group group) {
        Session session = sessionFactory.getCurrentSession();
        Group group1 = findByIdGroup(id);
        group1.setGroupName(group.getGroupName());
        group1.setDataStart(group.getDataStart());
        group1.setDataFinish(group.getDataFinish());
        session.merge(group1);
    }
}
