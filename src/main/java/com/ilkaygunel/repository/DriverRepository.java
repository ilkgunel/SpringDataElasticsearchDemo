package com.ilkaygunel.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.ilkaygunel.model.Driver;

@Repository
public interface DriverRepository extends ElasticsearchRepository<Driver, String> {

}
