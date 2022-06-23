
package com.bootcamp.G4.repositories;

import com.bootcamp.G4.model.Ticket;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long>{

    @Query(value = "SELECT * FROM tickets  WHERE tickets.id_wallet = ?1", nativeQuery = true)
    public ArrayList<Ticket> getTicketsById(@Param ("1") Long idWallet);
    
}