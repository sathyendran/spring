package org.sathya.user.api;

import org.sathya.user.bom.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class CustomUserRepositoryImpl implements  CustomUserRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> findByLastName(String lastName) {
        Query query = entityManager.createNativeQuery("Select * from user where last_name = :name", User.class);
        query.setParameter("name",lastName);
        return query.getResultList();
    }
}
