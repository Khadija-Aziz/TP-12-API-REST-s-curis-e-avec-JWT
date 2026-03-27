package ma.ens.security;

import ma.ens.security.entities.Role;
import ma.ens.security.entities.User;
import ma.ens.security.repositories.RoleRepository;
import ma.ens.security.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}
	@Bean
	CommandLineRunner start(UserRepository userRepository,
							RoleRepository roleRepository,
							PasswordEncoder passwordEncoder) {
		return args -> {

			userRepository.deleteAll();
			roleRepository.deleteAll();

			Role adminRole = roleRepository.save(new Role(null, "ROLE_ADMIN"));

		
			User admin = new User(null, "admin", passwordEncoder.encode("1234"), true, List.of(adminRole));
			userRepository.save(admin);
		};
	}
}
