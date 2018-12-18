package br.com.clinicaVet.service;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 4244881451243023367L;

	public ServiceException(String mensagem) {
		super(mensagem);
	}

}
