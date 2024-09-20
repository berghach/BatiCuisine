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
}
