package com.fotra.translation.Impl;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fotra.translation.Translate;
import com.fotra.translation.jsonObject.DetectInfo;
import com.fotra.translation.jsonObject.LangsInfo;
import com.fotra.translation.jsonObject.TranslResult;

@Component
public class GoogleTranslate implements Translate {

    @Override
    public TranslResult translate(String text, String lang) throws IOException {
        return null;
    }

    @Override
    public LangsInfo langs(String ui) throws IOException {
        return null;
    }

    @Override
    public DetectInfo detect(String input) throws IOException {
        return null;
    }
}
