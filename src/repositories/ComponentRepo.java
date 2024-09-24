package repositories;

import dao.ClientDAO;
import dao.ComponentDAO;
import entities.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComponentRepo implements Repository<Component>{
    private final ComponentDAO componentDAO;

    public ComponentRepo(ComponentDAO componentDAO) {
        this.componentDAO = componentDAO;
    }

    @Override
    public Component create(Component component) {
        try {
            boolean isSaved = componentDAO.save(component);
            if (isSaved) {
                return component;
            } else {
                throw new RuntimeException("Failed to create component");
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Access not allowed for creating components", e);
        }
    }

    @Override
    public Optional<Component> read(int id) {
        return componentDAO.get(id);
    }

    @Override
    public List<Component> readAll() {
        return componentDAO.getAll();
    }

    @Override
    public Component update(Component component) {
        try {
            boolean isUpdated = componentDAO.update(component);
            if (isUpdated) {
                return component;
            } else {
                throw new RuntimeException("Failed to update component");
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Access not allowed for updating components", e);
        }
    }

    @Override
    public boolean delete(int id) {
        Optional<Component> component = componentDAO.get(id);
        if (component.isPresent()) {
            return componentDAO.delete(component.get());
        } else {
            throw new RuntimeException("Component not found");
        }
    }
}
