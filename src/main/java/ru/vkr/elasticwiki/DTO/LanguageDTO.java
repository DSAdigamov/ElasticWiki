package ru.vkr.elasticwiki.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguageDTO {

    private String key;
    private String fullName;
    private String shortName;

}
