package trip4fun;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import  java.util.*;

/**
 * Session Bean implementation class BeanSessione
 */
@Stateful
@LocalBean
public class BeanSessione {
	boolean autentificato = false;
	String userName = "";
	String nome = "";
	String cognome = "";
	int idUser;
	
	ArrayList<Trip> tripList;
	
	public ArrayList<Trip> getTripList() {
		return tripList;
	}

	public void setTripList(ArrayList<Trip> tripList) {
		this.tripList = tripList;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public boolean isAutentificato() {
		return autentificato;
	}

	public void setAutentificato(boolean autentificato) {
		this.autentificato = autentificato;
	}

	/**
     * Default constructor. 
     */
    public BeanSessione() {
        // TODO Auto-generated constructor stub
    }
    
}
