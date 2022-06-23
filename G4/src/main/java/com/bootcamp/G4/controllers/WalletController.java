package com.bootcamp.G4.controllers;

import com.bootcamp.G4.model.Exchange;
import com.bootcamp.G4.model.Ticket;
import com.bootcamp.G4.model.TokenReducido;
import com.bootcamp.G4.model.TransferToken;
import com.bootcamp.G4.model.Wallet;
import com.bootcamp.G4.services.WalletService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/MyWallet")
public class WalletController {
    
    @Autowired
    WalletService wS;

    @GetMapping
    public ArrayList<Wallet> getAllWallets(){
        return wS.getAllWallets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Wallet> getWalletById(@PathVariable("id") Long id){
        Wallet wallet = wS.findById(id);
        if(wallet!=null){
            return ResponseEntity.status(HttpStatus.OK).body(wallet);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @GetMapping("/Tickets/{id}")
    public ResponseEntity<ArrayList<Ticket>> getTicketsById(@PathVariable("id") Long id){
        ArrayList<Ticket> ticket = wS.getTicketsById(id);
        if(ticket!=null){
            return ResponseEntity.status(HttpStatus.OK).body(ticket);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<String> saveWallet(@RequestBody Wallet wallet){
        wS.saveWallet(wallet);
        return ResponseEntity.ok().body("Success.");
    }

    @PostMapping("/AddToken/")
    public ResponseEntity<TokenReducido> addToken(@RequestBody TokenReducido tokenReducido){
        wS.addToken(tokenReducido);
        return ResponseEntity.ok().body(tokenReducido);
    }
    
    @PostMapping("/BuyToken/")
    public ResponseEntity<Ticket> buyToken(@RequestBody Ticket ticket) throws Exception{
        wS.buyToken(ticket);
        return ResponseEntity.ok().body(ticket);
    }
    
    @PostMapping("/SellToken/")
    public ResponseEntity<Ticket> sellToken(@RequestBody Ticket ticket) throws Exception {
        int e;
        e = wS.sellToken(ticket);
        if(e==1)return ResponseEntity.status(200).body(ticket);
        else if(e==2) return ResponseEntity.status(400).body(ticket);
        else return ResponseEntity.status(400).body(ticket);
        
    }
    
    @PostMapping("/ExchangeToken/")
    public ResponseEntity<Exchange> exchangeToken(@RequestBody Exchange exchange) throws Exception {
        int e;
        e = wS.exchangeToken(exchange);
        if(e==1)return ResponseEntity.status(200).body(exchange);
        else if(e==2) return ResponseEntity.status(400).body(exchange);
        else return ResponseEntity.status(400).body(exchange);
    }

    @PostMapping("/transfer")
    public ResponseEntity<TransferToken> transferToken(@RequestBody TransferToken token) throws Exception{
        wS.transferCrypto(token);
        if(token != null){
            return ResponseEntity.ok().body(token);
        }
        return ResponseEntity.badRequest().body(token);
    }
}
