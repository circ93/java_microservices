package it.servletdao.servletdao.model;
public class User {
    protected int id;
    protected String name;
    protected String email;
    protected String country;
    protected int eta;

    public User() {
    }

    public User(String name, String email, String country, int eta) {
        this.name = name;
        this.email = email;
        this.country = country;
        this.eta = eta;
    }



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }
}
