package entities;

import enums.ComponentType;

public class Component {
    private int id;
    private String name;
    private ComponentType componentType;
    private double vatRate;
    private int projectId;

    public Component(String name, ComponentType componentType, double vatRate, int projectId) {
        this.name = name;
        this.componentType = componentType;
        this.vatRate = vatRate;
        this.projectId = projectId;
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

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
}
