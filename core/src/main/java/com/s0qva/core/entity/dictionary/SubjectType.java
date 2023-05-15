package com.s0qva.core.entity.dictionary;

import com.s0qva.core.entity.base.BaseDictionaryEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Audited
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "subject_types_dictionary")
public class SubjectType extends BaseDictionaryEntity {
}
