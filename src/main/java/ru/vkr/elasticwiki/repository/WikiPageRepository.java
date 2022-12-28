package ru.vkr.elasticwiki.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import ru.vkr.elasticwiki.document.WikiPage;

public interface WikiPageRepository extends ElasticsearchRepository<WikiPage, String> {

}
