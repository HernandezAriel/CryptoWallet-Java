
package com.bootcamp.G4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenReducido { 
    private String tokenName;   
    private Long id_Wallet;
}
