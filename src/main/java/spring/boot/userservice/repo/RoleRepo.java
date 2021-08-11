package spring.boot.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.boot.userservice.domain.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {

	Role findByName(String name);
}
