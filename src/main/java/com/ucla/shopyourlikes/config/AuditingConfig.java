package com.ucla.shopyourlikes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 * AuditingConfig class
 */
@Configuration
@EnableJpaAuditing
public class AuditingConfig {

    /**
     *
     * @return a list AuditorAware of Integer
     */
    // That's all here for now. We'll add more auditing configurations later.
    @Bean
    public AuditorAware<Integer> auditorProvider() {
        return new SpringSecurityAuditAwareImpl();
    }

}

/**
 *  SpringSecurityAuditAwareImpl class
 */

class SpringSecurityAuditAwareImpl implements AuditorAware<Integer> {

    /**
     *
     * @return Integer for the CurrentAuditor
     */
    @Override
    public Optional<Integer> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated() ||
                authentication instanceof AnonymousAuthenticationToken) {
            return Optional.empty();
        }
        Integer userId = Integer.parseInt(authentication.getPrincipal().toString());
        return Optional.ofNullable(userId);
    }
}