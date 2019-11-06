package com.fotra.translation.jsonObject;

public class DetectInfo {
    private Integer code;
    private String lang;

    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }

    public String getLang() {
        return lang;
    }
    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        return "DetectInfo{" +
                "code=" + code +
                ", lang='" + lang + '\'' +
                '}';
    }
}
