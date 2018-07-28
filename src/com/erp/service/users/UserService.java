package com.erp.service.users;

import com.erp.entity.users.Users;
import com.erp.service.repository.GenericRepositoryPublic;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserService extends GenericRepositoryPublic {
    @PersistenceContext
    EntityManager entityManager;

    public List<Users> findEmail(String email) {
        return entityManager.createQuery("select entity from users entity where entity.email=:x")
                .setParameter("x",email).getResultList();
    }

    public Users searchEmail(String email) {
        return (Users) entityManager.createQuery("select entity from users entity where entity.email=:x")
                .setParameter("x",email).getSingleResult();
    }

    public List<Users> searchUserByDate(String startDate, String endDate)
    {
        return entityManager.createQuery("select o from users o where o.date between :x and :y")
                .setParameter("x",startDate)
                .setParameter("y",endDate)
                .getResultList();
    }
}


