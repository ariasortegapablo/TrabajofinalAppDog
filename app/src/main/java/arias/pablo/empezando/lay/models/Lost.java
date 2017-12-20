package arias.pablo.empezando.lay.models;

/**
 * Created by Pablo Arias on 19/12/2017.
 */

public class Lost {

    private String name;
    private String flagURL;

    public Lost(String name, String flagURL) {
        this.name = name;
        this.flagURL = flagURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlagURL() {
        return flagURL;
    }

    public void setFlagURL(String flagURL) {
        this.flagURL = flagURL;
    }
}
