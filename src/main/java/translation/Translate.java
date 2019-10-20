package translation;

import translation.models.TranslResult;
import java.io.UnsupportedEncodingException;

public interface Translate {
    public TranslResult getTranslate(String lang, String text) throws UnsupportedEncodingException;
}
