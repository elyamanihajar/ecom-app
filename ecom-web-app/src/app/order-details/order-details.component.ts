import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-order-details',
  standalone: false,
  templateUrl: './order-details.component.html',
  styleUrl: './order-details.component.css'
})
export class OrderDetailsComponent implements OnInit {
  orderDetails:any;
  orderId!:number;
  constructor(private http:HttpClient, private router:Router, private route:ActivatedRoute) {
    this.orderId = this.route.snapshot.params['orderId'];
  }
  ngOnInit() {
    this.http.get('http://localhost:8880/billing-service/bills/'+this.orderId)
      .subscribe(
        {
          next: data => {
            this.orderDetails = data;
          },
          error: error => {

          }
        }
      )
  }
}
