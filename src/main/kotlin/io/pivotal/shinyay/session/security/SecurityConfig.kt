package io.pivotal.shinyay.session.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
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

    @Autowired
    fun configureGlobal(auth: AuthenticationManagerBuilder)
            = auth.inMemoryAuthentication()
            .passwordEncoder(BCryptPasswordEncoder())
            .withUser("admin")
            .password(BCryptPasswordEncoder().encode("password"))
            .roles("ADMIN")!!
}