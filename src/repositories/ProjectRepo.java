package repositories;

import dao.ProjectDAO;
import entities.Project;

import java.util.List;
import java.util.Optional;

public class ProjectRepo implements Repository<Project>{
    private final ProjectDAO projectDAO;

    public ProjectRepo(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    @Override
    public Project create(Project project) {
        projectDAO.save(project);
        return project;
    }

    @Override
    public Optional<Project> read(int id) {
        return projectDAO.get(id);
    }

    @Override
    public List<Project> readAll() {
        return projectDAO.getAll();
    }

    @Override
    public Project update(Project project) {
        projectDAO.update(project);
        return project;
    }

    @Override
    public boolean delete(int id) {
        Optional<Project> project = projectDAO.get(id);
        if (project.isPresent()){
            return projectDAO.delete(project.get());
        }else {
            throw new RuntimeException("Project not found");
        }
    }
}
