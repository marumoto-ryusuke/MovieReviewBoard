package com.example.MovieReviewBoard

import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.core.Ordered
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter
import java.util.*
import javax.servlet.Filter

@RestController
class HelloWorldController {

    @GetMapping("/helloworld")
    fun greet(): String {
        return "helloworld!"
    }

    @Bean
    fun simpleCorsFilter(): FilterRegistrationBean<*> {
        val config = CorsConfiguration().apply {
            allowCredentials = true
            allowedOrigins = Collections.singletonList("http://localhost:8080")
            allowedMethods = Collections.singletonList("*")
            allowedHeaders = Collections.singletonList("")
        }

        val source = UrlBasedCorsConfigurationSource().apply {
            registerCorsConfiguration("/**", config)
        }

        return FilterRegistrationBean<Filter>(CorsFilter(source)).apply {
            order = Ordered.HIGHEST_PRECEDENCE
        }
    }
}
