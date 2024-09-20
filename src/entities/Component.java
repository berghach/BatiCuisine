package entities;

import enums.ComponentType;

public class Component {
    private int id;
    private String name;
    private ComponentType componentType;
    private Project project;

    public Component(String name, ComponentType componentType, Project project) {
        this.name = name;
        this.componentType = componentType;
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
}
