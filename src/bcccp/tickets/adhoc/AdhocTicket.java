/*
 * This method creates an adhocTicket object
 */
package bcccp.tickets.adhoc;

// import java.util.Date;

public class AdhocTicket implements IAdhocTicket {
	
	private String carparkId;
	private int ticketNo;
	private long entryDateTime;
	private long paidDateTime;
	private long exitDateTime;
	private float charge;
	private String barcode;

	
	
	public AdhocTicket(String carparkId, int ticketNo, String barcode) {
		//TDO Implement constructor
		carparkId = this.carparkId;
		ticketNo = this.ticketNo;
		barcode = this.barcode;
	}


	@Override
	public int getTicketNo() {
		// TODO Auto-generated method stub
		return ticketNo;
	}


	@Override
	public String getBarcode() {
		// TODO Auto-generated method stub
		return barcode;
	}


	@Override
	public String getCarparkId() {
		// TODO Auto-generated method stub
		return carparkId;
	}


	@Override
	public void enter(long dateTime) {
		// TODO Auto-generated method stub
		this.entryDateTime = dateTime;
	}


	@Override
	public long getEntryDateTime() {
		// TODO Auto-generated method stub
		return entryDateTime;
	}


	/* 	Checks whether the ticket is valid at current time; 
	 *  ie the entryDateTime has been initiated
	 *  and the exitDateTime has not happened
	 * @see bcccp.tickets.adhoc.IAdhocTicket#isCurrent()
	 */
	@Override
	public boolean isCurrent() {
		// TODO Auto-generated method stub
		if ((entryDateTime > 0) && (exitDateTime==0)) { 
			return true;
		}
		else return false;
	}


	@Override
	public void pay(long dateTime, float charge) {
		// TODO Auto-generated method stub
		this.paidDateTime = dateTime;
		this.charge = charge;
	}


	@Override
	public long getPaidDateTime() {
		// TODO Auto-generated method stub
		return paidDateTime;
	}


	@Override
	public boolean isPaid() {
		// TODO Auto-generated method stub
		if (paidDateTime >0 & charge >=0) // the ticket is paid if paidDateTime is initiated & charge is activated
			return true;
		else return false;
	}


	@Override
	public float getCharge() {
		// TODO Auto-generated method stub
		return charge;
	}


	@Override
	public void exit(long dateTime) {
		// TODO Auto-generated method stub
		this.exitDateTime = dateTime;
	}


	@Override
	public long getExitDateTime() {
		// TODO Auto-generated method stub
		return exitDateTime;
	}


	@Override
	public boolean hasExited() {
		// TODO Auto-generated method stub
		if (exitDateTime <= System.currentTimeMillis()) {
			return true;
		}
		return false;
	}

	
	
}
