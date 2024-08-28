package io.example.sbliquibase.bdd

import com.ragin.bdd.cucumber.core.DatabaseExecutorService
import com.ragin.bdd.cucumber.utils.JsonUtils
import io.cucumber.java.Before
import io.cucumber.spring.CucumberContextConfiguration
import io.example.application.ApiApplication
import mu.KotlinLogging
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.test.context.SpringBootContextLoader
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT
import org.springframework.context.annotation.ComponentScan
import org.springframework.test.context.ContextConfiguration

@ComponentScan("io.example")
@ContextConfiguration(
    classes = [
        ApiApplication::class,
        DatabaseExecutorService::class,
        JsonUtils::class
    ],
    loader = SpringBootContextLoader::class
)
@ConfigurationPropertiesScan(
    "com.ragin.bdd",
    "configuration.com.ragin.bdd",
    "io.example",
    "configuration.io.example"
)
@SpringBootTest(
    webEnvironment = DEFINED_PORT,
    properties = [
        "spring.main.allow-bean-definition-overriding=true"
    ]
)
@CucumberContextConfiguration
class CucumberContextConfig {
    @Before
    fun setUpCucumber() {
        log.info("-------------- Spring Context Initialized For Executing Cucumber Tests --------------")
    }

    companion object {
        private val log = KotlinLogging.logger {}
    }
}
