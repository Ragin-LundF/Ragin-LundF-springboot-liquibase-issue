package io.example.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.scheduling.annotation.EnableAsync

/**
 * Main Spring Boot class.
 *
 * This class contains only the main method, which must extend the
 * {@link org.springframework.boot.web.servlet.support.SpringBootServletInitializer}
 * class to allow deployment in Tomcat instances.
 */
@EnableAsync
@EntityScan(basePackages = ["io.example.*"])
@ComponentScan(basePackages = ["io.example.*"])
@EnableJpaRepositories(basePackages = ["io.example.*"])
@ConfigurationPropertiesScan(basePackages = [
    "io.example.*",
])
@SpringBootApplication
class ApiApplication : SpringBootServletInitializer()

@Suppress("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}

