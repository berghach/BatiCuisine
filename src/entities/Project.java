package entities;

import enums.ProjectStatus;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private int id;
    private String name;
    private double kitchenSurface;
    private double profitMargin;
    private double vatRate;
    private double totalPrice; //Project totalPrice is the price estimation off taxes and profit margin.
    private ProjectStatus status;
    private Client client; //Each Project is related to a Client
    private Estimate estimate; //Each Project has an Estimate
    private List<Component> components; //Each Project has a list of Component

    public Project(int id, String name, double kitchenSurface, double profitMargin, double vatRate, double totalPrice, ProjectStatus status, Client client) {
        this.id = id;
        this.name = name;
        this.kitchenSurface = kitchenSurface;
        this.profitMargin = profitMargin;
        this.vatRate = vatRate;
        this.totalPrice = totalPrice;
        this.status = status;
        this.client = client;
        this.components = new ArrayList<>();
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

    public double getKitchenSurface() {
        return kitchenSurface;
    }

    public void setKitchenSurface(double kitchenSurface) {
        this.kitchenSurface = kitchenSurface;
    }

    public double getProfitMargin() {
        return profitMargin;
    }

    public void setProfitMargin(double profitMargin) {
        this.profitMargin = profitMargin;
    }

    public double getVatRate() {
        return vatRate;
    }

    public void setVatRate(double vatRate) {
        this.vatRate = vatRate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Estimate getEstimate() {
        return estimate;
    }

    public List<Component> getComponents() {
        return components;
    }
}
