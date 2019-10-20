package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import translation.GoogleTranslate;
import translation.Translate;
import translation.YandexTranslate;
import translation.models.TranslResult;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping(value = "/api/translate")
public class Translation {
    private final Translate yandexTranslate;
    private final Translate googleTranslate;

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