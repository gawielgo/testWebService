package it.corvallis.webservices.exception;

import lombok.Data;

@Data
public class ErrorResponse 
{
	private int codice;
	private String messaggio;
	
}
