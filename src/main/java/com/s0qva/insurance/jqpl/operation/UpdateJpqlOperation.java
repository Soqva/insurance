package com.s0qva.insurance.jqpl.operation;

import com.s0qva.insurance.constant.JpqlOperationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component(JpqlOperationConstant.UPDATE_JPQL_OPERATION_NAME)
public class UpdateJpqlOperation extends AbstractJpqlOperation<Integer> {

    @Autowired
    public UpdateJpqlOperation(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Integer execute(String query) {
        return entityManager.createQuery(query).executeUpdate();
    }
}
