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

    public static ComponentType fromString(String name) {
        for (ComponentType status : ComponentType.values()) {
            if (status.getName().equalsIgnoreCase(name)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown component type: " + name);
    }
}
