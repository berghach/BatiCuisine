package console;

import dao.ProjectDAO;
import database.DBConnection;
import entities.Project;
import repositories.ProjectRepo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProjectConsole {
    private final Connection connection = DBConnection.getConnection();
    private final ProjectDAO projectDAO = new ProjectDAO(connection);
    private final ProjectRepo projectRepo = new ProjectRepo(projectDAO);
    private final Scanner scanner = new Scanner(System.in);

    public ProjectConsole() throws SQLException {
    }


    public void projectAdd(){
        System.out.println("--- Recherche de client ---\n" +
                "Souhaitez-vous chercher un client existant ou en ajouter un nouveau ?\n" +
                "1. Chercher un client existant\n" +
                "2. Ajouter un nouveau client\n" +
                "Choisissez une option :");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:

                break;
            case 2:

                break;
            default:
                projectAdd();
                break;
        }
    }
    public void projectsDisplay(){
        List<Project> projects = projectRepo.readAll();
        if (projects.isEmpty()){
            System.out.println("No projects to display");
        }else {
            for (Project project : projects){
                System.out.println(project.toString());
            }
        }
    }
}
