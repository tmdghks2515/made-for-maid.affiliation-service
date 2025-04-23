package io.madeformaid.affiliation

import io.madeformaid.webmvc.context.EnableAuthContext
import io.madeformaid.webmvc.exception.EnableGlobalExceptionHandling
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
@EnableAuthContext
@EnableGlobalExceptionHandling
class AffiliationServiceApplication

fun main(args: Array<String>) {
	runApplication<AffiliationServiceApplication>(*args)
}
