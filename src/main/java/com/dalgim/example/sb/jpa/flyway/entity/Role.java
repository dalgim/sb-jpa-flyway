package com.dalgim.example.sb.jpa.flyway.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Mateusz Dalgiewicz <mateusz.dalgiewicz@coi.gov.pl> on 02.05.17.
 */
@Getter
@Setter
@Entity
@Table(name = "ROLE", uniqueConstraints = @UniqueConstraint(columnNames = "ROLE_TYPE"))
public class Role extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE_TYPE", nullable = false, length = 100)
    private RoleType roleType;
}
