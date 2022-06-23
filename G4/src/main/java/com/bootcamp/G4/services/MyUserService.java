package com.bootcamp.G4.services;

import com.bootcamp.G4.model.MyUser;
import com.bootcamp.G4.model.Role;
import com.bootcamp.G4.model.TokenReducido;
import com.bootcamp.G4.model.Wallet;
import com.bootcamp.G4.repositories.CuentasRepository;
import com.bootcamp.G4.repositories.MyUserRepository;
import com.bootcamp.G4.repositories.RoleRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserService {
    
    @Autowired
    MyUserRepository uR;
    
    @Autowired
    WalletService wS;

    @Autowired
    RoleRepository rRepository;

    @Autowired
    CuentasRepository cRepository;

    @Autowired
    WalletService wService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public ArrayList<MyUser> getAllUsers() {
        return (ArrayList<MyUser>) uR.findAll();
    }

    public MyUser saveUser(MyUser user) {
        //TRAIGO EL ROL
        Optional<Role> rol = rRepository.findByName("ROLE_USER"); 
        Role rols = rol.get();

        //CREO LA WALLET
        Wallet wallet = new Wallet();
        wallet.setToken_wallet(null);
        wService.saveWallet(wallet);
        //TOKEN REDUCIDO
        TokenReducido tReducido = new TokenReducido();
        tReducido.setTokenName("USDT");
        tReducido.setId_Wallet(wallet.getId()); //HAY QUE SETEARLO
        //AGREGO EL TOKEN A LA WALLET
        wService.addToken(tReducido);
        //AGREGO LA WALLET AL USER
        user.setWallet(wallet);
        //SETEO EL ROL
        user.setRole(rols);
        //HASH PASSWORD
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println("nada");
        //RETORNO EL USR
        uR.save(user);
        return user;
    }

    public Optional<MyUser> getUserByID(Long id) {
        return uR.findById(id);
    }
    /*
    //GET BY USER
    public Optional<MyUser> findByUserName(String userName) {
        return uR.findByUsername(userName);
    }
    */


    public Long findByUsername(String username)
    {
       MyUser u = uR.findByUsername(username).get();
       Long id = u.getId();
        if(id != null)
        {
            return id;
        }
        else
        return null;

    }

    //DELETE
    public boolean deleteById(Long id) {
        try {
            uR.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    //EDIT
    public boolean editByUserName(MyUser user) {
        if (uR.findById(user.getId()) != null){
            uR.save(user);
            return true;
        } else
            return false;        
    }
    
    
}
