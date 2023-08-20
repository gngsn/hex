package com.gngsn.ditto.shared.configuration;

import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JpaConfiguration {

    @PersistenceContext
    private lateinit var entityManager: EntityManager

    @Bean
    fun jpaQueryFactory() = JPAQueryFactory(entityManager)
}
