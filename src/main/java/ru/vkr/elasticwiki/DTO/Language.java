package ru.vkr.elasticwiki.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Language {

    private String fullName;
    private String shortName;

}
