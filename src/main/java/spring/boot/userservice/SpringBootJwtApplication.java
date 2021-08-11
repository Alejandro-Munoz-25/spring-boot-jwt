package spring.boot.userservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import spring.boot.userservice.domain.Role;
import spring.boot.userservice.domain.User;
import spring.boot.userservice.service.UserService;

import java.util.ArrayList;

@SpringBootApplication
public class SpringBootJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJwtApplication.class, args);
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "Alejandro", "alejandro", "12345", new ArrayList<>()));
            userService.saveUser(new User(null, "Will Smith", "will", "12345", new ArrayList<>()));
            userService.saveUser(new User(null, "Jim Carry", "jim", "12345", new ArrayList<>()));
            userService.saveUser(new User(null, "Mario", "mario", "12345", new ArrayList<>()));

            userService.addRoleToUser("alejandro", "ROLE_USER");
            userService.addRoleToUser("alejandro", "ROLE_MANAGER");
            userService.addRoleToUser("will", "ROLE_ADMIN");
            userService.addRoleToUser("jim", "ROLE_USER");
            userService.addRoleToUser("jim", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("mario", "ROLE_ADMIN");
            userService.addRoleToUser("mario", "ROLE_USER");
        };
    }
}
