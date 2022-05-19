import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from '../model/customer';

@Injectable({
  providedIn: 'root',
})
export class CustomerService {
  constructor(private http: HttpClient) {}

  getCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>('/api/rest/customers/get-customers');
  }

  addCustomer(customer: Customer): Observable<Customer> {
    return this.http.post<Customer>(
      '/api/rest/customers/post-customer',
      customer
    );
  }
}
