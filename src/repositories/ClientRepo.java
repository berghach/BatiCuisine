package repositories;

import entities.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientRepo implements Repository<Client> {
    private List<Client> clients = new ArrayList<>();

    @Override
    public Client create(Client client) {
        clients.add(client);
        return client;
    }

    @Override
    public Optional<Client> read(int id) {
        return clients.stream()
                .filter(client -> client.getId() == id)
                .findFirst();
    }

    @Override
    public List<Client> readAll() {
        return new ArrayList<>(clients);
    }

    @Override
    public Client update(Client client) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
