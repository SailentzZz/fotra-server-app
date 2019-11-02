package translation.jsonObject;

public class LangsInfo {
    private String[] dirs;
    private Langs langs;

    public String[] getDirs () {
        return dirs;
    }
    public void setDirs (String[] dirs) {
        this.dirs = dirs;
    }

    public Langs getLangs () {
        return langs;
    }
    public void setLangs (Langs langs) {
        this.langs = langs;
    }

    @Override
    public String toString() {
        return "ClassPojo [dirs = "+dirs+", langs = "+langs+"]";
    }
}
