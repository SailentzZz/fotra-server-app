package translation;

import org.springframework.stereotype.Component;
import translation.models.TranslResult;

import java.io.UnsupportedEncodingException;

@Component
public class GoogleTranslate implements Translate {
    @Override
    public TranslResult getTranslate(String lang, String text) throws UnsupportedEncodingException {
        return null;
    }
}
