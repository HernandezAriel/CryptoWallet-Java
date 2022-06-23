
package com.bootcamp.G4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Exchange {
    private Long id_wallet;
    
    private double priceToken1;
    private String tokenName1;
    private double amount; //a pasar del precio 1
    
    private double priceToken2;
    private String tokenName2;
    
    
    
    
}
