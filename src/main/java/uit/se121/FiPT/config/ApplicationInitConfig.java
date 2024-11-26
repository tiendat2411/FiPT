package uit.se121.FiPT.config;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import uit.se121.FiPT.entity.Account;
import uit.se121.FiPT.entity.Role;
import uit.se121.FiPT.repository.AccountRepository;
import uit.se121.FiPT.repository.RoleRepository;


import java.util.HashSet;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ApplicationInitConfig {
    AccountRepository accountRepository;
    RoleRepository roleRepository;
    PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner() {
        return args -> {
            if (roleRepository.findByName("ADMIN").isEmpty()) {
                Role role =Role.builder()
                        .name("ADMIN")
                        .build();
                roleRepository.save(role);
            }
            if (accountRepository.findByUsername("admin").isEmpty()) {
                Account account = Account.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("admin"))
                        .role(roleRepository.findByName("ADMIN").get())
                        .build();

                accountRepository.save(account);
                log.warn("admin user has been created with default password: admin, please change it");
            }
        };
    }
}
