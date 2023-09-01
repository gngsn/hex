package com.gngsn.hex.adapter.output.persistence.repository

import com.gngsn.hex.adapter.output.persistence.entity.CityEntity
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.data.repository.CrudRepository


interface CityRepository : CrudRepository<CityEntity, Long>, QuerydslPredicateExecutor<CityEntity>