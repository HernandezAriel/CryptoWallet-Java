export class Crypto {
    ask: number;
    totalAsk: number;
    bid: number;
    totalBid: number;
    time: number;

    constructor( ask: number,
        totalAsk: number,
        bid: number,
        totalBid: number,
        time: number) {
            this.ask=ask;
            this.bid=bid;
            this.time=time;
            this.totalAsk=totalAsk;
            this.totalBid=totalBid;
        
    }
}