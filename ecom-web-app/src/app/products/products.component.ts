import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-products',
  standalone: false,
  templateUrl: './products.component.html',
  styleUrl: './products.component.css'
})
export class ProductsComponent implements OnInit{
  products:any;
  constructor(private http:HttpClient) {
  }
  ngOnInit() {
    this.http.get('http://localhost:8880/inventory-service/api/products').subscribe(
      {
        next: data => {
          this.products = data;
        },
        error: error => {

        }
      }
    )
  }

}
