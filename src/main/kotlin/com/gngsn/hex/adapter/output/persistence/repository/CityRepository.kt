package com.gngsn.hex.adapter.output.persistence.repository

import com.gngsn.hex.adapter.output.persistence.entity.CityEnity
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.data.repository.CrudRepository


interface CityRepository : CrudRepository<CityEnity, Long>, QuerydslPredicateExecutor<CityEnity>