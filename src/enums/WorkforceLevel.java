package enums;

public enum WorkforceLevel {
    BASIC("basique"),
    SKILLED("spécialisé");

    private final String name;

    WorkforceLevel(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static WorkforceLevel fromString(String name) {
        for (WorkforceLevel status : WorkforceLevel.values()) {
            if (status.getName().equalsIgnoreCase(name)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown project status: " + name);
    }
}
