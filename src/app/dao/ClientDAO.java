package app.dao;

import app.config.DBConfig;
import app.dto.ClientDTO;
import app.entity.Client;
import org.hibernate.Session;

import org.hibernate.Query;

import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends AbstractDAOImpl<Client> {

    public ClientDAO(Class<Client> entityClass) {
        super(entityClass);
    }

    @Override
    public Client save(Client entity) {
        return super.save(entity);
    }

    @Override
    public List<Client> getAll() {
        return super.getAll();
    }

    @Override
    public Client findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public String update(Client entity) {
        return super.update(entity);
    }

    public List<ClientDTO> countMostLoyaltyClients() {
        Session session = DBConfig.getSessionFactory().openSession();
        Query query = session.createSQLQuery("select c.id,c.full_name,count(c.id)\n" +
                "from reservation\n" +
                "         join client c on reservation.id_client = c.id\n" +
                "group by c.id");
        List<Object[]> objects = query.list();
        List<ClientDTO> clientDTOList = new ArrayList<>();

        for (Object[] row : objects) {
            ClientDTO clientDTO = new ClientDTO();
            clientDTO.setId(Integer.valueOf(row[0].toString()));
            clientDTO.setFullName(row[1].toString());
            clientDTO.setAmount(Integer.valueOf(row[2].toString()));

            clientDTOList.add(clientDTO);
        }
        return clientDTOList;
    }
}
