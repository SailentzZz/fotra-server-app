package translation.Impl;

import org.springframework.stereotype.Component;
import translation.Translate;
import translation.jsonObject.DetectInfo;
import translation.jsonObject.LangsInfo;
import translation.jsonObject.TranslResult;

import java.io.IOException;

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
