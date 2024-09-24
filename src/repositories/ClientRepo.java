package repositories;

import dao.ClientDAO;
import entities.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientRepo implements Repository<Client> {
    private final ClientDAO clientDAO;

    public ClientRepo(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Override
    public Client create(Client client) {
        boolean isSaved = clientDAO.save(client);
        if (isSaved) {
            return client;
        } else {
            throw new RuntimeException("Failed to create client");
        }
    }
    public Optional<Client> readByName(String name) {
        return clientDAO.getByName(name);
    }
    @Override
    public Optional<Client> read(int id) {
        return clientDAO.get(id);
    }

    @Override
    public List<Client> readAll() {
        return clientDAO.getAll();
    }

    @Override
    public Client update(Client client) {
        boolean isUpdated = clientDAO.update(client);
        if (isUpdated) {
            return client;
        } else {
            throw new RuntimeException("Failed to update client");
        }
    }

    @Override
    public boolean delete(int id) {
        Optional<Client> client = clientDAO.get(id);
        if (client.isPresent()) {
            return clientDAO.delete(client.get());
        } else {
            throw new RuntimeException("Client not found");
        }
    }
}
