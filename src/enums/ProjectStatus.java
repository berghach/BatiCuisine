package enums;

public enum ProjectStatus {
    ONGOING("en cours"),
    DONE("terminé"),
    CANCELED("annulé");

    private final  String name;

    ProjectStatus(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
