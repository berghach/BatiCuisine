package console;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuConsole {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ProjectConsole projectConsole;
    private static final EstimateConsole estimateConsole;

    static {
        try {
            estimateConsole = new EstimateConsole();
            projectConsole = new ProjectConsole();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public MenuConsole() throws SQLException {
    }

    public static void menuConsole(){
        System.out.print("=== Bienvenue dans l'application de gestion des projets de rénovation de cuisines ===\n" +
                "=== Menu Principal ===\n" +
                "1. Créer un nouveau projet\n" +
                "2. Afficher les projets existants\n" +
                "3. Calculer le coût d'un projet\n" +
                "4. Quitter\n"+
                "Choisissez une option: "
        );
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                System.out.println("=== Créer un nouveau projet ===");
                projectConsole.projectAdd();
                break;
            case 2:
                System.out.println("==== Les projets ====");
                projectConsole.projectsDisplay();
                break;
            case 3:
                System.out.println("=== Calculer le coût d'un projet ===");

                break;
            case 4:
                System.out.println("Quitter...");
                break;
            default:
                menuConsole();
                break;
        }

    }
}
