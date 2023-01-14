package ru.vkr.elasticwiki.Util;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import ru.vkr.elasticwiki.DTO.Language;
import ru.vkr.elasticwiki.DTO.LanguageDTO;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LanguageUtil {

    private static final String LANGUAGE_FILE_PATH = "src/main/resources/maps/langMap.json";

    private static Map<String, Language> languageMap;

    public static Map<String, Language> getLanguageMap() {
        return languageMap;
    }

    @PostConstruct
    public static void InitLanguageMap() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<LanguageDTO> languageDTOS = Arrays.asList(objectMapper.readValue(Paths.get(LANGUAGE_FILE_PATH).toFile(), LanguageDTO[].class));

        languageMap = languageDTOS.stream()
                .collect(Collectors.toMap(
                        LanguageDTO::getKey,
                        languageDTO -> {
                    return new Language(languageDTO.getFullName(), languageDTO.getShortName());
                }));
    }

}
