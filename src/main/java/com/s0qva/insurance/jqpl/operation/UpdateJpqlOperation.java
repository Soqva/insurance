package com.s0qva.insurance.jqpl.operation;

import com.s0qva.insurance.constant.JpqlConstant;
import com.s0qva.insurance.dto.JpqlQuery;
import com.s0qva.insurance.jqpl.updater.EntityJpqlUpdater;
import com.s0qva.insurance.util.JpqlOperationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;

@Component(JpqlConstant.UPDATE_JPQL_OPERATION_NAME)
public class UpdateJpqlOperation extends AbstractJpqlOperation<Integer> {
    private final EntityJpqlUpdater entityJpqlUpdater;

    @Autowired
    public UpdateJpqlOperation(EntityManager entityManager, EntityJpqlUpdater entityJpqlUpdater) {
        super(entityManager);
        this.entityJpqlUpdater = entityJpqlUpdater;
    }

    @Override
    public Integer executeQuery(JpqlQuery query) {
        String jpqlQuery = query.getQuery();
        String selectJpqlQuery = JpqlOperationUtil.convertToSelectJpqlQuery(jpqlQuery);
        List<?> entitiesToUpdate = entityManager.createQuery(selectJpqlQuery).getResultList();

        for (Object entityToUpdate : entitiesToUpdate) {
            Map<String, String> changes = JpqlOperationUtil.extractChanges(jpqlQuery);

            entityJpqlUpdater.update(entityToUpdate, changes);
            entityManager.persist(entityToUpdate);
        }
        return entitiesToUpdate.size();
    }
}
