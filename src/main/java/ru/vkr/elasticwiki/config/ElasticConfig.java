//package ru.vkr.elasticwiki.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.client.ClientConfiguration;
//import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
//import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
//
//@Configuration
//@EnableElasticsearchRepositories(basePackages = "ru.vkr.elasticwiki.repository")
//public class ElasticConfig extends ElasticsearchConfiguration {
//
//    @Override
//    public ClientConfiguration clientConfiguration() {
//        return ClientConfiguration.create("127.0.0.1:9201");
//    }
//}