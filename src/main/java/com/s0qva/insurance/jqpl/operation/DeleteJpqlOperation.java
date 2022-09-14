package com.s0qva.insurance.jqpl.operation;

import com.s0qva.insurance.constant.JpqlConstant;
import com.s0qva.insurance.dto.JpqlQuery;
import com.s0qva.insurance.util.JpqlOperationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component(JpqlConstant.DELETE_JPQL_OPERATION_NAME)
public class DeleteJpqlOperation extends AbstractJpqlOperation<Integer> {

    @Autowired
    public DeleteJpqlOperation(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Integer executeQuery(JpqlQuery query) {
        String jpqlQuery = query.getQuery();
        String selectJpqlQuery = JpqlOperationUtil.convertToSelectJpqlQuery(jpqlQuery);
        List<?> entitiesToDelete = entityManager.createQuery(selectJpqlQuery).getResultList();

        for (Object entityToDelete : entitiesToDelete) {
            entityManager.remove(entityToDelete);
        }
        return entitiesToDelete.size();
    }
}
