package com.eamapp.crud.crudspringboot.repositorie;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import com.eamapp.crud.crudspringboot.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
    @Query(value = "SELECT c.name, c.lastname1, c.lastname2, o.amount, o.date, o.id_comercial FROM clients c INNER JOIN orders o ON c.id = o.id_client ORDER BY c.lastname1, c.lastname2, c.name", nativeQuery = true)
    List<Object[]> clientsWithOrders();
    @Query(value = "SELECT name, lastname1, lastname2 FROM clients WHERE id NOT IN (SELECT DISTINCT id_client FROM orders) ORDER BY lastname1, lastname2, name", nativeQuery = true)
    List<Object[]> clientsWithoutOrders();
}
