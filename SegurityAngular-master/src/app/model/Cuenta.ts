export class Cuenta {
    id?:number;
    amount_tokens:number;
    tokenName:string;
    id_wallet:number;
    valor_total:number;
    get(amount_tokens:number){
        return this.amount_tokens;
    }
    constructor(amountToken: number,tokenName:string,id_wallet:number,valor_total:number){
    this.amount_tokens=amountToken;
    this.id_wallet=id_wallet;
    this.tokenName=tokenName;
    this.valor_total=valor_total;
    }
}