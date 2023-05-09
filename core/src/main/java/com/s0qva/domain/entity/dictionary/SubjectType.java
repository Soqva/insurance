package com.s0qva.domain.entity.dictionary;

import com.s0qva.domain.entity.base.BaseDictionaryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Audited
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "subject_types_dictionary")
public class SubjectType extends BaseDictionaryEntity {
}
