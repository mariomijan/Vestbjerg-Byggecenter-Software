package model;

import java.util.Date;

public class Booking
{
	private int id;
	private Date startDate;
	private Date endDate;
	private int discount;
	private Invoice i;
	private Guest g;
	private Room r;

	public Booking()
	{
		
	}
	
	public Booking(int id, Date startDate, Date endDate, int discount, Invoice i, Guest g, Room r)
	{
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.discount = discount;
		this.i = i;
		this.g = g;
		this.r = r;
	}

	public Booking(Date startDate, Date endDate, int discount, Invoice i, Guest g, Room r)
	{
		this.startDate = startDate;
		this.endDate = endDate;
		this.discount = discount;
		this.i = i;
		this.g = g;
		this.r = r;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Date getStartDate()
	{
		return startDate;
	}

	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}

	public Date getEndDate()
	{
		return endDate;
	}

	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}

	public int getDiscount()
	{
		return discount;
	}

	public void setDiscount(int discount)
	{
		this.discount = discount;
	}

	public Invoice getI()
	{
		return i;
	}

	public void setI(Invoice i)
	{
		this.i = i;
	}

	public Guest getG()
	{
		return g;
	}

	public void setG(Guest g)
	{
		this.g = g;
	}

	public Room getR()
	{
		return r;
	}

	public void setR(Room r)
	{
		this.r = r;
	}

}
