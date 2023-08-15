package com.gngsn.ditto.adapter.output.persistence.repository

import com.gngsn.ditto.adapter.output.persistence.entity.City
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.data.repository.CrudRepository


interface CityRepository : CrudRepository<City, Long>, QuerydslPredicateExecutor<City>