package ru.vkr.elasticwiki.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.vkr.elasticwiki.document.WikiPage;
import ru.vkr.elasticwiki.service.WikiPageService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/page")
@Slf4j
public class WikiPageController {

    private final WikiPageService wikiPageService;

    @PostMapping
    public void save(@RequestBody WikiPage wikiPage) {
        log.info("wiki page to save: {}", wikiPage);
        wikiPageService.save(wikiPage);
    }

    @GetMapping("/{id}")
    public WikiPage findById(@PathVariable String id) {
        return wikiPageService.findById(id);
    }

}
