package ctrl;

import model.Invoice;

public class InvoiceCtrl {
	public InvoiceCtrl(){
		
	}
	//TODO Calcualte the total price based on the chosen room
	public Invoice createInvoice(){
		Invoice i = new Invoice(1,2000);
		return i;
	}
}
