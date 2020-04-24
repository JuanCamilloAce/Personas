package co.com.personas.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author Jacevedo
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .antMatcher("/**").authorizeRequests()
                .antMatchers(new String[]{"/", "/swagger-ui.html#/"}).permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login();
    }
}