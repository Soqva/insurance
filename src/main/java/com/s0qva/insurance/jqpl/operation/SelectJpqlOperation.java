package com.s0qva.insurance.jqpl.operation;

import com.s0qva.insurance.constant.JpqlConstant;
import com.s0qva.insurance.dto.JpqlQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component(JpqlConstant.SELECT_OPERATION_NAME)
public class SelectJpqlOperation extends AbstractJpqlOperation<List<?>> {

    @Autowired
    public SelectJpqlOperation(EntityManager entityManager) {
        super(entityManager);
    }
    @Override
    public List<?> executeQuery(JpqlQuery query) {
        String jpqlQuery = query.getQuery();

        return entityManager.createQuery(jpqlQuery).getResultList();
    }
}
