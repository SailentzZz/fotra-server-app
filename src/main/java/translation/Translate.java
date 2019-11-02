package translation;

import translation.jsonObject.DetectInfo;
import translation.jsonObject.LangsInfo;
import translation.jsonObject.TranslResult;
import java.io.IOException;

public interface Translate {
    public TranslResult translate(String text, String lang) throws IOException;
    public LangsInfo langs(String ui) throws IOException;
    public DetectInfo detect(String input) throws IOException;
}
