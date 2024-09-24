package repositories;

import dao.WorkforceDAO;
import entities.Workforce;

import java.util.List;
import java.util.Optional;

public class WorkforceRepo implements Repository<Workforce>{
    private final WorkforceDAO workforceDAO;

    public WorkforceRepo(WorkforceDAO workforceDAO) {
        this.workforceDAO = workforceDAO;
    }

    @Override
    public Workforce create(Workforce workforce) {
        workforceDAO.save(workforce);
        return workforce;
    }

    @Override
    public Optional<Workforce> read(int id) {
        return workforceDAO.get(id);
    }

    @Override
    public List<Workforce> readAll() {
        return workforceDAO.getAll();
    }

    @Override
    public Workforce update(Workforce workforce) {
        workforceDAO.update(workforce);
        return workforce;
    }

    @Override
    public boolean delete(int id) {
        Optional<Workforce> workforce = workforceDAO.get(id);
        if (workforce.isPresent()) {
            return workforceDAO.delete(workforce.get());
        }else {
            throw new RuntimeException("Workforce not found");
        }
    }
}
