package com.boicehot.elasticsearch.repository;

import com.boicehot.elasticsearch.model.TestModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TestRepository extends ElasticsearchRepository<TestModel, Integer> {
}