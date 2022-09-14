package com.s0qva.insurance.jqpl.updater;

import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;

@Component
public class EntityJpqlUpdater {

    public void update(Object entity, Map<String, String> changes) {
        for (Map.Entry<String, String> changesEntry : changes.entrySet()) {
            String entityFieldName = changesEntry.getKey();
            Object entityFieldValue = changesEntry.getValue();
            Field entityField = ReflectionUtils.findField(entity.getClass(), entityFieldName);

            ReflectionUtils.makeAccessible(entityField);
            ReflectionUtils.setField(entityField, entity, entityFieldValue);
        }
    }
}
