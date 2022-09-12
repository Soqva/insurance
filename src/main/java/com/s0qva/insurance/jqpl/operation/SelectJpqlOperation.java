package com.s0qva.insurance.jqpl.operation;

import com.s0qva.insurance.constant.JpqlOperationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component(JpqlOperationConstant.SELECT_JPQL_OPERATION_NAME)
public class SelectJpqlOperation extends AbstractJpqlOperation<List<?>> {

    @Autowired
    public SelectJpqlOperation(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public List<?> execute(String query) {
        return entityManager.createQuery(query).getResultList();
    }
}
