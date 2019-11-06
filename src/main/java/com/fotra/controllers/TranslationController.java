package com.fotra.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fotra.translation.Translate;
import com.fotra.translation.Impl.YandexTranslate;
import com.fotra.translation.jsonObject.DetectInfo;
import com.fotra.translation.jsonObject.LangsInfo;
import com.fotra.translation.jsonObject.TranslResult;

@RestController
@RequestMapping(value = "/perm/an/api")
public class TranslationController {

    private Translate yandexTranslate;

    @Autowired
    TranslationController (YandexTranslate yandexTranslate) {
        this.yandexTranslate = yandexTranslate;
    }

    @GetMapping("/translate/yandex/{lang}/{text}")
    public TranslResult Translate(@PathVariable("lang") String lang, @PathVariable("text") String text) throws IOException {
        return yandexTranslate.translate(lang, text);
    }

    @GetMapping("/langs/yandex/{ui}")
    public LangsInfo Langs(@PathVariable("ui") String ui) throws IOException {
        return yandexTranslate.langs(ui);
    }

    @GetMapping("/detect/yandex/{text}")
    public DetectInfo Detect(@PathVariable("text") String text) throws IOException {
        return yandexTranslate.detect(text);
    }

    @GetMapping("/info/yandex")
    public String Info() {
        return "Требования к использованию результатов перевода\n" +
                "Согласно Лицензии на использование Яндекс.Переводчика над\n" +
                "или под результатом перевода должен быть указан текст\n" +
                "Переведено сервисом «Яндекс.Переводчик» с активной ссылкой\n" +
                "на страницу http://translate.yandex.ru.\n" +
                "\n" +
                "Требования к расположению текста\n" +
                "Текст должен быть указан:\n" +
                "в описании программного продукта;\n" +
                "в справке о программном продукте;\n" +
                "на официальном сайте программного продукта;\n" +
                "на всех страницах или экранах, где используются данные сервиса.\n" +
                "Требования к цвету шрифта\n" +
                "Цвет шрифта текста должен совпадать с цветом шрифта основного текста.\n" +
                "\n" +
                "Требования к размеру шрифта\n" +
                "Размер шрифта текста должен быть не менее размера шрифта основного текста.";
    }
}