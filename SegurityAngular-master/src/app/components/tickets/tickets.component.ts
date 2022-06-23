import { Component, OnInit } from '@angular/core';
import { Ticket } from 'src/app/model/Ticket';
import { TicketsService } from 'src/app/services/tickets.service';

@Component({
  selector: 'app-tickets',
  templateUrl: './tickets.component.html',
  styleUrls: ['./tickets.component.css']
})
export class TicketsComponent implements OnInit {
    ticket :Ticket[]= [];

  constructor(private tS:TicketsService) { }
  ngOnInit(): void {
    this.getTickets();
  }
  async getTickets(){
    (await this.tS.getTickets()).subscribe(data => {
      console.log(data);
      this.ticket=data;
      console.log(this.ticket)
    })
  }

}
