export class Ticket{
    id?:number;
    amount:number;
    name_token:string;
    id_wallet:number;
    type:number;

     constructor(amount: number,name_token:string,id_wallet:number,type:number){
        this.amount=amount;
        this.id_wallet=id_wallet;
        this.name_token=name_token;
        this.type=type;
       }
}