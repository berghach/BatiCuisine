package enums;

public enum ComponentType {
    MATERIAL("material"),
    WORKFORCE("workforce");

    private final String name;

    ComponentType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
