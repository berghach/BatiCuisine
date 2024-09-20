package entities;

import java.util.List;

public class Client {
    private int id;
    private String name;
    private String adresse;
    private String phone;
    private boolean professional;

    public Client(String name, String adresse, String phone, boolean professional){
        this.name = name;
        this.adresse = adresse;
        this.phone = phone;
        this.professional = professional;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isProfessional() {
        return professional;
    }

    public void setProfessional(boolean professional) {
        this.professional = professional;
    }
}
