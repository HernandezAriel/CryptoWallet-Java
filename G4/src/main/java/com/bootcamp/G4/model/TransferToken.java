package com.bootcamp.G4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferToken {
    private Long transferWalletId;

    private Long receptorWalletId;

    private String tokenName;

    private double amount;
}
