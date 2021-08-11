package spring.boot.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.boot.userservice.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
