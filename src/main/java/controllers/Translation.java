package controllers;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import repos.UserForumRepository;
import translation.GoogleTranslate;
import translation.Translate;
import translation.YandexTranslate;
import translation.models.TranslResult;

@RestController
@RequestMapping(value = "/api/translate")
public class Translation {
    private final Translate yandexTranslate;
    private final Translate googleTranslate;

    @Autowired
    UserForumRepository userForum;
    
    @Autowired
    public Translation(YandexTranslate yandexTranslate, GoogleTranslate googleTranslate) {
        this.yandexTranslate = yandexTranslate;
        this.googleTranslate = googleTranslate;
    }

    @GetMapping("/yandex/{lang}/{text}")
    public TranslResult translate(@PathVariable("lang") String lang,
                                  @PathVariable("text") String text) throws UnsupportedEncodingException {
        return yandexTranslate.getTranslate(lang, text);
    }
}