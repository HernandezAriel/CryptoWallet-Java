
package com.bootcamp.G4.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "tickets")
public class Ticket {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Long id_wallet;
    private String name_token;
    private double amount;
    private int type;

    public Ticket(Long id_wallet, String name_token, double amount) {
        this.id_wallet = id_wallet;
        this.name_token = name_token;
        this.amount = amount;

    }

   
    
    
}
