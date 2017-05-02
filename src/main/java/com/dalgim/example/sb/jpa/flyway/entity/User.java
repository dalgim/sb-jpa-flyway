package com.dalgim.example.sb.jpa.flyway.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Mateusz Dalgiewicz <mateusz.dalgiewicz@coi.gov.pl> on 02.05.17.
 */
@Getter
@Setter
@Entity
@Table(name = "ACCOUNT", uniqueConstraints = @UniqueConstraint(columnNames = "LOGIN"))
public class User extends AbstractEntity {

    @Column(name = "LOGIN", nullable = false, length = 100)
    private String login;
    @Column(name = "FIRSTNAME", nullable = false, length = 100)
    private String firstName;
    @Column(name = "LASTNAME", nullable = false, length = 150)
    private String lastName;
    @Column(name = "PASSWORD", nullable = false, length = 100)
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ACCOUNT_ROLE",
            joinColumns = {@JoinColumn(name = "ACCOUNT_ID", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", nullable = false)})
    private Set<Role> roleSet = new HashSet<>();
}
