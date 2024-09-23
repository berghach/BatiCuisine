package entities;

import enums.ComponentType;

public class Component {
    private int id;
    private String name;
    private ComponentType componentType;
    private double vatRate;
    private Project project; //Component has no access to project, so no need for setter nor getter

    public Component(String name, ComponentType componentType, double vatRate, Project project) {
        this.name = name;
        this.componentType = componentType;
        this.vatRate = vatRate;
        this.project = project;
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

    public ComponentType getComponentType() {
        return componentType;
    }

    public void setComponentType(ComponentType componentType) {
        this.componentType = componentType;
    }

    public double getVatRate() {
        return vatRate;
    }

    public void setVatRate(double vatRate) {
        this.vatRate = vatRate;
    }
}
