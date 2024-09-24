package repositories;

import dao.EstimateDAO;
import entities.Client;
import entities.Estimate;

import java.util.List;
import java.util.Optional;

public class EstimateRepo implements Repository<Estimate>{
    private final EstimateDAO estimateDAO;

    public EstimateRepo(EstimateDAO estimateDAO) {
        this.estimateDAO = estimateDAO;
    }

    // Create a new estimate
    @Override
    public Estimate create(Estimate estimate) {
        estimateDAO.save(estimate);
        return estimate;
    }

    // Read an estimate by ID
    @Override
    public Optional<Estimate> read(int id) {
        return estimateDAO.get(id);
    }

    // Read all estimates
    @Override
    public List<Estimate> readAll() {
        return estimateDAO.getAll();
    }

    // Update an existing estimate
    @Override
    public Estimate update(Estimate estimate) {
        estimateDAO.update(estimate);
        return estimate;
    }

    // Delete an estimate by ID
    @Override
    public boolean delete(int id) {
        Optional<Estimate> estimate = estimateDAO.get(id);
        if (estimate.isPresent()) {
            return estimateDAO.delete(estimate.get());
        } else {
            throw new RuntimeException("Estimate not found");
        }
    }
}
