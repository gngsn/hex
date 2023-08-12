package com.gngsn.ditto.adapter.external.persistence.repository

import com.gngsn.ditto.adapter.external.persistence.entity.City
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.data.repository.CrudRepository


interface CityRepository : CrudRepository<City, Long>, QuerydslPredicateExecutor<City>