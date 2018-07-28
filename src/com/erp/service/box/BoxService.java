package com.erp.service.box;

import com.erp.service.repository.GenericRepositoryPublic;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class BoxService extends GenericRepositoryPublic {
    @PersistenceContext
    EntityManager entityManager;
}
