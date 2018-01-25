/**
 * 
 */
package model;

/**
 * @author Kerim
 *
 */
public class Room
{
	private int id;
	private boolean status;
	private RoomType rt;

	/**
	 * @param id
	 * @param status
	 * @param rt
	 */
	public Room(int id, boolean status, RoomType rt)
	{
		this.id = id;
		this.status = status;
		this.rt = rt;
	}

	public Room(boolean status, RoomType rt)
	{
		this.status = status;
		this.rt = rt;
	}

	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus()
	{
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(boolean status)
	{
		this.status = status;
	}

	/**
	 * @return the rt
	 */
	public RoomType getRt()
	{
		return rt;
	}

	/**
	 * @param rt
	 *            the rt to set
	 */
	public void setRt(RoomType rt)
	{
		this.rt = rt;
	}

}
