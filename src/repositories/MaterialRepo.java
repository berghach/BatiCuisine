package repositories;

import dao.MaterialDAO;
import entities.Material;

import java.util.List;
import java.util.Optional;

public class MaterialRepo implements Repository<Material>{
    private final MaterialDAO materialDAO;

    public MaterialRepo(MaterialDAO materialDAO) {
        this.materialDAO = materialDAO;
    }

    @Override
    public Material create(Material material) {
        materialDAO.save(material);
        return material;
    }

    @Override
    public Optional<Material> read(int id) {
        return materialDAO.get(id);
    }

    @Override
    public List<Material> readAll() {
        return materialDAO.getAll();
    }

    @Override
    public Material update(Material material) {
        materialDAO.update(material);
        return material;
    }

    @Override
    public boolean delete(int id) {
        Optional<Material> material = materialDAO.get(id);
        if (material.isPresent()){
            return materialDAO.delete(material.get());
        }else {
            throw new RuntimeException("Material not found");
        }
    }
}
