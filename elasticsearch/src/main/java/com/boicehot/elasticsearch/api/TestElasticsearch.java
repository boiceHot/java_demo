package com.boicehot.elasticsearch.api;

import com.boicehot.elasticsearch.model.TestModel;
import com.boicehot.elasticsearch.repository.TestRepository;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class TestElasticsearch {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private TestRepository testRepository;

    @GetMapping(value = "/test/save")
    public Object save(){
        TestModel testModel = new TestModel();
        testModel.setId(1);
        testModel.setName("test");
        testRepository.save(testModel);
        return "success";
    }

    @GetMapping(value = "/test/{keyword}")
    public Object test(@PathVariable("keyword") String keyword){
        NativeSearchQueryBuilder searchQueryBuilder = new NativeSearchQueryBuilder();
        searchQueryBuilder.withQuery(QueryBuilders.queryStringQuery(keyword));
        return elasticsearchTemplate.queryForList(searchQueryBuilder.build(), TestModel.class);
    }
}