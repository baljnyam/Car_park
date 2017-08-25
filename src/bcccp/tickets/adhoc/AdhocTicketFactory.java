/*This class create a barcode based on date and time of entry i.e. System time
 * as it is assumed that one car enters at one time only 
 * carparkId and ticketNo are parsed as parameters
 * 
 */

package bcccp.tickets.adhoc;


public class AdhocTicketFactory implements IAdhocTicketFactory {

	@Override
	public IAdhocTicket make(String carparkId, int ticketNo) {
		// TODO Auto-generated method stub
		String barcode = String.valueOf(System.currentTimeMillis());
		IAdhocTicket adhocTicket = new AdhocTicket (carparkId, ticketNo, barcode);
		return adhocTicket;
	}


}
