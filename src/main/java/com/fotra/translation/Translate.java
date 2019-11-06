package com.fotra.translation;

import java.io.IOException;

import com.fotra.translation.jsonObject.DetectInfo;
import com.fotra.translation.jsonObject.LangsInfo;
import com.fotra.translation.jsonObject.TranslResult;

public interface Translate {
    public TranslResult translate(String text, String lang) throws IOException;
    public LangsInfo langs(String ui) throws IOException;
    public DetectInfo detect(String input) throws IOException;
}
