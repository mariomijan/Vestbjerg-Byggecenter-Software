package model;

/**
 * 
 * @author Kerim
 *
 */

public class RoomType
{
	private int id;
	//private String status;
	private double roomPrice;
	private String roomType;
	private String description;
	
	/**
	 * @param id
	 * @param status
	 * @param roomPrice
	 * @param roomType
	 * @param description
	 */
	
	public RoomType(int id, /*String status,*/ double roomPrice, String roomType, String description)
	{
		this.id = id;
		//this.status = status;
		this.roomPrice = roomPrice;
		this.roomType = roomType;
		this.description = description;
	}

	/**
	 * @param id
	 * @param status
	 * @param roomPrice
	 * @param roomType
	 * @param description
	 */
	
	public RoomType(/*String status, */double roomPrice, String roomType, String description)
	{
		//this.status = status;
		this.roomPrice = roomPrice;
		this.roomType = roomType;
		this.description = description;
	}

	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * @return the status
	 */
	/*
	public boolean isStatus()
	{
		return status;
	}

	/**
	 * @param status the status to set
	 */
	/*
	public void setStatus(boolean status)
	{
		this.status = status;
	}*/

	/**
	 * @return the roomPrice
	 */
	public double getRoomPrice()
	{
		return roomPrice;
	}

	/**
	 * @param roomPrice the roomPrice to set
	 */
	public void setRoomPrice(double roomPrice)
	{
		this.roomPrice = roomPrice;
	}

	/**
	 * @return the roomType
	 */
	public String getRoomType()
	{
		return roomType;
	}

	/**
	 * @param roomType the roomType to set
	 */
	public void setRoomType(String roomType)
	{
		this.roomType = roomType;
	}

	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	@Override
    public String toString()
    {
        return roomType;
    }
}
