package com.hatenablog.yufutech.systems.v1

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SystemResource {

    @GetMapping("/v1/systems/ping")
    fun ping(): String {
        return "pong"
    }
}