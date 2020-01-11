package it.corvallis.webservices.exception;

public class PromoNotFoundException  extends Exception
{
 
	private static final long serialVersionUID = -5630320396706560376L;
	
	private String messaggio;
	
	public PromoNotFoundException()
	{
		super();
	}

	public PromoNotFoundException(String Messaggio)
	{
		super(Messaggio);
		this.messaggio = Messaggio;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}
	
	

}
