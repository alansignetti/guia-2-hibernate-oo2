package test;

import datos.Cliente;
import negocio.ClienteABM;
import negocio.ContactoABM;

public class TestAgregarContacto {
	public static void main(String[] args) {
		ClienteABM abmCliente = new ClienteABM();
		long idCliente = 2;
		Cliente cliente = abmCliente.traer(idCliente);
		System.out.println(cliente);
		ContactoABM abmContacto = new ContactoABM();
		abmContacto.agregar("prueba@contacto2", "22-2222-2222", "022-2222-2222", cliente);
	}
}
