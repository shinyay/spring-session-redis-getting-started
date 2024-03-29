package io.pivotal.shinyay.session.controller

import org.springframework.context.annotation.Configuration
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer


@Configuration
@EnableRedisHttpSession
class SessionConfig : AbstractHttpSessionApplicationInitializer() {
}