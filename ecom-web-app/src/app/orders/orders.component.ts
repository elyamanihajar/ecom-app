import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-orders',
  standalone: false,
  templateUrl: './orders.component.html',
  styleUrl: './orders.component.css'
})
export class OrdersComponent implements OnInit {
  orders:any;
  customerId!:number;
  constructor(private http:HttpClient, private router:Router, private route:ActivatedRoute) {
    this.customerId = this.route.snapshot.params['customerId'];
  }
  ngOnInit() {
    this.http.get('http://localhost:8880/billing-service/api/bills/search/byCustomerID?projection=fullBill&customerId='+this.customerId)
      .subscribe(
      {
        next: data => {
          this.orders = data;
        },
        error: error => {

        }
      }
    )
  }

  getOrderDetails(o: any) {
    this.router.navigateByUrl('/order-details/'+o.id);
  }
}
