package main.java.via.sdj3.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SmartMom {
    private Long id;
    private String means, model;

    public SmartMom() {
    }

    public SmartMom(Long id, String means, String model) {
        super();
        this.id = id;
        this.means = means;
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public String getMeans() {
        return means;
    }

    public String getModel() {
        return model;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMeans(String means) {
        this.means = means;
    }

    public void setModel(String model) {
        this.model = model;
    }
}