package com.fotra.translation.Impl;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.stereotype.Component;

import com.fotra.translation.Translate;
import com.fotra.translation.jsonObject.DetectInfo;
import com.fotra.translation.jsonObject.LangsInfo;
import com.fotra.translation.jsonObject.TranslResult;
import com.google.gson.Gson;

@Component
public class YandexTranslate implements Translate {
    private final String TRANSLATE_URI = "https://translate.yandex.net/api/v1.5/tr.json/translate";
    private final String LANGS_URI = "https://translate.yandex.net/api/v1.5/tr.json/getLangs";
    private final String DETECT_URI = "https://translate.yandex.net/api/v1.5/tr.json/detect";
    private final String KEY = "trnsl.1.1.20191020T170430Z.88ab3039c144bdf6.5cd6fffe4327c758c6a0cc3f7e642623a718387f";

    @Override
    public TranslResult translate(String lang, String input) throws IOException {
        String urlStr = TRANSLATE_URI + "?key=" + KEY;
        URL urlObj = new URL(urlStr);
        HttpsURLConnection connection = (HttpsURLConnection)urlObj.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
        dataOutputStream.writeBytes("text=" + URLEncoder.encode(input, "UTF-8") + "&lang=" + lang);

        InputStream response = connection.getInputStream();
        String json = new java.util.Scanner(response).nextLine();
        Gson gson = new Gson();
        return gson.fromJson(json, TranslResult.class);
    }

    public DetectInfo detect(String input) throws IOException {
        String urlStr = DETECT_URI + "?key=" + KEY;
        URL urlObj = new URL(urlStr);
        HttpsURLConnection connection = (HttpsURLConnection)urlObj.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
        dataOutputStream.writeBytes("text=" + URLEncoder.encode(input, "UTF-8"));

        InputStream response = connection.getInputStream();
        String json = new java.util.Scanner(response).nextLine();
        Gson gson = new Gson();
        return gson.fromJson(json, DetectInfo.class);
    }

    public LangsInfo langs(String ui) throws IOException {
        String urlStr = LANGS_URI + "?key=" + KEY;
        URL urlObj = new URL(urlStr);
        HttpsURLConnection connection = (HttpsURLConnection)urlObj.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
        dataOutputStream.writeBytes( "ui=" + ui);

        InputStream response = connection.getInputStream();
        String json = new java.util.Scanner(response).nextLine();
        Gson gson = new Gson();
        return gson.fromJson(json, LangsInfo.class);
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