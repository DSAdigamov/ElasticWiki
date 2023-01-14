package ru.vkr.elasticwiki.Util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.vkr.elasticwiki.document.WikiPage;
import ru.vkr.elasticwiki.service.WikiPageService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class FileParseUtil {

    private final WikiPageService wikiPageService;

    public void parseWikiPages(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        skipPages(br, 1); //Пропуск главной страницы

        String line = br.readLine();
        while (line != null) {
            line = line.trim();

            if (line.equals("<page>")) {
                wikiPageService.save(parseNextPage(br));
            }
            line = br.readLine();
        }

        br.close();
    }

    private void skipPages(BufferedReader br, int amountToSkip) throws IOException {
        String line = "";
        int skippedPages = 0;

        while (skippedPages != amountToSkip) {
            line = br.readLine().trim();

            if (line.equals("</page>")) {
                skippedPages++;
            }
        }
    }

    private WikiPage parseNextPage(BufferedReader br) throws IOException {
        StringBuilder strBuilder = new StringBuilder("<page>");

        String line = "";
        while (!line.equals("</page>")) {
            line = br.readLine().trim();

            strBuilder.append("\n").append(line);
        }
        return new WikiPage();
    }
}
