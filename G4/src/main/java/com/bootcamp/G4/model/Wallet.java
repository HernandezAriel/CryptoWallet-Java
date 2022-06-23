package com.bootcamp.G4.model;

import java.util.List;
import javax.persistence.CascadeType;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "wallets")
public class Wallet {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany(targetEntity = Cuentas.class, cascade =  CascadeType.ALL)
    @JoinColumn(name= "id_wallet", referencedColumnName= "id") 
    private List<Cuentas> token_wallet;
    
}
