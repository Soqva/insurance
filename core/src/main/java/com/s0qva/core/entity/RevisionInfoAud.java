package com.s0qva.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@RevisionEntity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "revision_info_aud")
public class RevisionInfoAud {

    @Id
    @RevisionNumber
    @Column(name = "revision_number")
    @GeneratedValue(strategy = IDENTITY)
    private Integer revisionNumber;

    @RevisionTimestamp
    @Column(name = "entering_date")
    private Date enteringDate;

    private String username;
}
