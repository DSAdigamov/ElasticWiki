package ru.vkr.elasticwiki.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(indexName = "wiki_page")
public class WikiPage {

    @Id
    private String title;

    @Field(type = FieldType.Keyword)
    private String revisionId;

    @Field(type = FieldType.Date)
    private LocalDateTime dateTime;

    @Field(type = FieldType.Keyword)
    private String[] categories;

    @Field(type = FieldType.Nested)
    private List<SubInfo> subInfos;

    @Field(type = FieldType.Text)
    private String mainText;

}
