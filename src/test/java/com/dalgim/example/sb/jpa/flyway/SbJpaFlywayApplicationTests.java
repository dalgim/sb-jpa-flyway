package com.dalgim.example.sb.jpa.flyway;

import com.dalgim.example.sb.jpa.flyway.entity.Role;
import com.dalgim.example.sb.jpa.flyway.entity.RoleType;
import com.dalgim.example.sb.jpa.flyway.entity.User;
import com.dalgim.example.sb.jpa.flyway.repository.RoleRepository;
import com.dalgim.example.sb.jpa.flyway.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbJpaFlywayApplicationTests {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Test
	public void contextLoads() {
		User user = new User();
		user.setFirstName("John");
		user.setLastName("Smith");
		user.setLogin("John.Smith");
		user.setPassword("asd");

        Role adminRole = roleRepository.findByRoleType(RoleType.ADMIN);

        user.getRoleSet().add(adminRole);
        userRepository.save(user);
        //userRepository.deleteAll();

	}

}
