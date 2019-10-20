package translation;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import translation.models.TranslResult;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Component
public class YandexTranslate implements Translate {
    private final String TRANSLATE = "https://translate.yandex.net/api/v1.5/tr.json/translate?";
    private final String KEY = "trnsl.1.1.20191020T170430Z.88ab3039c144bdf6.5cd6fffe4327c758c6a0cc3f7e642623a718387f";

    private RestTemplate restTemplate;

    @Override
    public String toString() {

        return "YandexTranslate{}";
    }

    // lang -> en-ru
    // lang -> ru
    public TranslResult getTranslate(String lang, String text) throws UnsupportedEncodingException {
        String request = TRANSLATE +
                "key=" + KEY +
                "&lang=" + lang +
                "&text=" + URLEncoder.encode(text, "UTF-8");

        return restTemplate.getForObject(
                request,
                TranslResult.class);

    }
}


/*
key trnsl.1.1.20191020T170430Z.88ab3039c144bdf6.5cd6fffe4327c758c6a0cc3f7e642623a718387f
Список поддерживаемых языков https://translate.yandex.net/api/v1.5/tr.json/getLangs?ui=en&key=API-KEY
ответ {"langs": {"ru": "русский", "en": "английский", "pl": "польский"}}
ошибка {"code":401,"message":"API key is invalid"}
Определение языка https://translate.yandex.net/api/v1.5/tr.json/detect?hint=en,de&key=API-KEY&text=Hello World!
ответ { "code": 200, "lang": "en" }
Перевод текста https://translate.yandex.net/api/v1.5/tr.json/translate?lang=en-ru&key=API-KEY&text=Hello World!
*/