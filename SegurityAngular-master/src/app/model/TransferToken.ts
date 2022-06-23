export class TransferToken{
    transferWalletId:number;
    receptorWalletId:number;
    tokenName:string;
    amount:number;
    constructor(transferWalletId:number,
        receptorWalletId:number,
        tokenName:string,
        amount:number
    ){
        this.amount=amount;
        this.receptorWalletId=receptorWalletId;
        this.tokenName=tokenName;
        this.transferWalletId=transferWalletId;
    }
}

