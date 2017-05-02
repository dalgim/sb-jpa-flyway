package com.dalgim.example.sb.jpa.flyway.repository;

import com.dalgim.example.sb.jpa.flyway.entity.Role;
import com.dalgim.example.sb.jpa.flyway.entity.RoleType;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Mateusz Dalgiewicz <mateusz.dalgiewicz@coi.gov.pl> on 02.05.17.
 */
public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByRoleType(RoleType roleType);
}
