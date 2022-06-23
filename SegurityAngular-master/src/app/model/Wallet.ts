import { Cuenta } from "./Cuenta";

export class Wallet{
    id:number;
    token_wallet: Cuenta[] = [];
    
    constructor(id:number, cuentas:Cuenta[]){
        this.id=id;
        this.token_wallet=cuentas;
    }
}