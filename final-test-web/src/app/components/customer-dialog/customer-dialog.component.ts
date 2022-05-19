import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Customer } from '../../model/customer';

import { CustomerService } from 'src/app/services/customer-service';

@Component({
  selector: 'app-customer-dialog',
  templateUrl: './customer-dialog.component.html',
  styleUrls: ['./customer-dialog.component.css'],
})
export class CustomerDialogComponent {
  display: boolean | undefined;

  @Input() customer!: Customer;
  @Output() closeDialogEvent = new EventEmitter();
  @Output() saveNewCustomerEvent = new EventEmitter<Customer>();

  constructor(private customerService: CustomerService) {}

  ngOnInit() {
    this.display = true;
  }

  saveNewCustomer() {
    this.customerService.addCustomer(this.customer).subscribe(
      (response) => {
        this.display = false;
        this.customer.id = 5;
        // temporary assignment of id to customer, new and correct id will be generated on back end
        this.saveNewCustomerEvent.emit(this.customer);
        alert('New customer was successfully added');
      },
      (error) => {
        alert(
          'The form was not completed correctly. Please make sure all the details are valid, the date is provided in YYYY-MM-DD format and the email has not been registered previously.'
        );
      }
    );
  }

  closeDialog() {
    this.display = false;
    this.closeDialogEvent.emit();
  }
}
