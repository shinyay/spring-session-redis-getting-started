package io.pivotal.shinyay.session.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SessionController {

    @GetMapping("/")
    fun helloAdmin() = "Hello, Admin"
}