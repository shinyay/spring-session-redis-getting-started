package io.pivotal.shinyay.session.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager

@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        http?.httpBasic()
                ?.and()
                ?.authorizeRequests()
                ?.antMatchers("/")
                ?.hasRole("ADMIN")
                ?.anyRequest()
                ?.authenticated()
    }

//    @Autowired
//    fun configureGlobal(auth: AuthenticationManagerBuilder)
//            = auth.inMemoryAuthentication()
//            .withUser("admin")
//            .password("password")
//            .roles("ADMIN")!!

    @Bean
    override fun userDetailsService(): UserDetailsService {
        val users = User.withDefaultPasswordEncoder()
        val manager = InMemoryUserDetailsManager()
        manager.createUser(users.username("admin").password("password").roles("ADMIN").build())
        return manager
    }
}