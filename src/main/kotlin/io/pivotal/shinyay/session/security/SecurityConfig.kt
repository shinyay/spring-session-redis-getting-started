package io.pivotal.shinyay.session.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

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
            .withUser("admin")
            .password("password")
            .roles("ADMIN")!!
}