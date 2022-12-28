package ru.vkr.elasticwiki.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "wiki_category")
public class Category {

    @Id
    private String id;

    @Field(type = FieldType.Keyword)
    private String name;
}
