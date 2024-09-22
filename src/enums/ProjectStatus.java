package enums;

public enum ProjectStatus {
    ONGOING("ongoing"),
    DONE("done"),
    CANCELED("canceled");

    private final  String name;

    ProjectStatus(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public static ProjectStatus fromString(String name) {
        for (ProjectStatus status : ProjectStatus.values()) {
            if (status.getName().equalsIgnoreCase(name)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown project status: " + name);
    }
}
