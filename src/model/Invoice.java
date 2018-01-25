package model;

import java.util.Date;

public class Invoice 
{
	private int invoiceNo;
	private Date paymentDate;
	private double totalPrice;
	
	//TODO set the invoiceNo & paymentDate from the database??
	public Invoice(int invoiceNo, double TotalPrice)
	{
		this.invoiceNo = invoiceNo;
		this.paymentDate = paymentDate;
		this.totalPrice = totalPrice;
	}

	public int getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
