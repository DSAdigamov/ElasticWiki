package ru.vkr.elasticwiki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
public class ElasticWikiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticWikiApplication.class, args);
    }

}
