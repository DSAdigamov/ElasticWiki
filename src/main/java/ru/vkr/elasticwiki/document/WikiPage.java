package ru.vkr.elasticwiki.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Set;

@Data
@Document(indexName = "wiki_page")
public class WikiPage {

    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String url;

    @Field(type = FieldType.Auto)
    private Set<Category> categories;

    @Field(type = FieldType.Text)
    private String description;

}
