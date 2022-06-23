package com.bootcamp.G4.repositories;

import com.bootcamp.G4.model.Cuentas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentasRepository extends JpaRepository<Cuentas, Long>{

    @Query(value = "SELECT id FROM token_wallet t WHERE t.id_wallet = ?1 AND t.token_name = ?2", nativeQuery = true)
    public Long findByIdWalletAndToken(@Param ("1") Long idWallet, String token_name);
    

}
