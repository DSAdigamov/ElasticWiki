package ru.vkr.elasticwiki.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vkr.elasticwiki.document.WikiPage;
import ru.vkr.elasticwiki.repository.WikiPageRepository;

@Service
@RequiredArgsConstructor
public class WikiPageService {

    private final WikiPageRepository wikiPageRepository;

    public void save(WikiPage page) {
        wikiPageRepository.save(page);
    }

    public WikiPage findById(String id) {
        return wikiPageRepository.findById(id).orElse(null);
    }
}
