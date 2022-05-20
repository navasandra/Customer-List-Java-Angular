import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/app/model/customer';
import { CustomerService } from 'src/app/services/customer-service';

@Component({
  selector: 'app-customer-table',
  templateUrl: './customer-table.component.html',
  styleUrls: ['./customer-table.component.css'],
})
export class CustomerTableComponent implements OnInit {
  customers?: Customer[];
  customer!: Customer | null;
  constructor(private customerService: CustomerService) {}

  ngOnInit() {
    this.getCustomers();
  }

  getCustomers() {
    this.customerService.getCustomers().subscribe(
      (response) => {
        this.customers = response;
      },
      (error) => {
        alert('Something went wrong. Unable to properly load the list.');
      }
    );
  }

  selectCustomer(customer: Customer) {
    this.customer = customer;
  }
  addNewCustomer() {
    this.customer = new Customer();
    this.customer.id = null;
    // setting customer id to be null
  }

  saveNewCustomer(customer: Customer) {
    this.customers?.push(customer);
    // adding new customer to the list and pushing it to back end
    this.getCustomers();
    // reloading the list with the new customer & correct new id
  }

  closeDialog() {
    this.customer = null;
    this.getCustomers();
  }
}
