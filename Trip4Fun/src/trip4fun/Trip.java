package trip4fun;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import java.util.Date;

/**
 * Session Bean implementation class BeanSessione
 */
@Stateful
@LocalBean



public class Trip {
	String destinazione;
	int idDestinazione;

	Date checkIn;
	Date checkOut;
	

	public String getDestinazione() {
		return destinazione;
	}
	
	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}
	
	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}
	
	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	
	public int getIdDestinazione() {
		return idDestinazione;
	}

	public void setIdDestinazione(int idDestinazione) {
		this.idDestinazione = idDestinazione;
	}
}


