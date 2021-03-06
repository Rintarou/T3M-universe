package universe.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class Security extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/images/**", "/css/**");
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http.antMatcher("/api/**")
			.csrf().ignoringAntMatchers("/api/**")
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeRequests()
				.antMatchers(HttpMethod.GET,"/api/user/**").permitAll()
				.antMatchers(HttpMethod.POST,"/api/user").permitAll()
				.antMatchers(HttpMethod.POST,"/api/{universe_id}/element/**").access("@customWebSecurity.checkWrite(authentication,#universe_id)")
				.antMatchers(HttpMethod.PUT,"/api/{universe_id}/element/{id}").access("@customWebSecurity.checkWrite(authentication,#universe_id)")
				.antMatchers(HttpMethod.DELETE,"/api/{universe_id}/element/{id}").access("@customWebSecurity.checkWrite(authentication,#universe_id)")
				.antMatchers(HttpMethod.PUT,"/api/universe/{id}").access("@customWebSecurity.checkOwner(authentication,#id)")
				.antMatchers(HttpMethod.PUT,"/api/universe/addUserUniverse/{id}").access("@customWebSecurity.checkOwner(authentication,#id)")
				.antMatchers(HttpMethod.DELETE,"/api/universe/{id}").access("@customWebSecurity.checkOwner(authentication,#id)")
				.antMatchers(HttpMethod.POST,"/api/{universe_id}/relation/**").access("@customWebSecurity.checkWrite(authentication,#universe_id)")
				.antMatchers("/api/**").authenticated()
				.and()
			.httpBasic();
				
		// @formatter:on
		http.cors().configurationSource(corsConfigurationSource());
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}   
	
	@Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT"));
        configuration.setAllowedHeaders(Collections.singletonList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
	
	@Bean
	CustomWebSecurity customWebSecurity() {
		return new CustomWebSecurity();
	};
	

}
