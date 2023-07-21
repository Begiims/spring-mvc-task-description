package spring.repository.interfaces;

import spring.model.Group;

import java.util.List;

public interface GroupInterface {
    List<Group> findAllGroups(Long id);

    Group findByIdGroup(Long id);

    void saveGroup(Group group);

    void deleteByIdGroup(Long id);

    void updateByIdGroup(Long id, Group group);
}
