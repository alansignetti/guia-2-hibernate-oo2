package negocio;


import java.time.LocalDate;
import dao.ContactoDao;
import java.util.List;

import org.hibernate.HibernateException;

import dao.ClienteDao;
import negocio.ContactoABM;
import datos.Cliente;
import datos.Contacto;
public class ClienteABM {
    ClienteDao dao = new ClienteDao();
    
    public Cliente traer(long idCliente) {
        Cliente c = dao.traer(idCliente);
        return c;
    }
    public Cliente traer(int dni) {
        Cliente c = dao.traer(dni);
        return c;
    }
    public int agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento) throws Exception {
        // consultar si existe un cliente con el mismo dni, si existe arrojar la excepcion
    	Cliente c = null;
      	
    	
    	 if (dao.traer(dni) == null){ // si no trae ningun objeto, significa que no esta cargado ese dni y lo agrega

       	  		c = new Cliente(apellido, nombre, dni, fechaDeNacimiento, null);
    	 }
    	 else {
    		 throw new Exception("El dni ingresado ya existe en la base de datos");	
    	 }	
        
        return dao.agregar(c);
    }
    

       

    public void modificar(Cliente c) throws Exception {

    	Cliente cliDni = new Cliente();
    	Cliente cliId = new Cliente();
    	cliDni= dao.traer(c.getDni()); // dni 3333 no existe, y no existe id para ese dni
    	cliId = dao.traer(c.getIdCliente()); // id=2 (dni modificado de 2222 a 3333)    cliId.getIdCliente() != 
    	// el c.dni != dliID.dni
    	if (cliDni == null & cliId.getDni() != c.getDni()) { // no existe un cliente con ese dni, y tampoco con ese id para ese dni    		
    		
    			dao.actualizar(c);		
		}
    	else {
    		throw new Exception("No se pudo modificar debido a que ese DNI ya existe en la Base de Datos");	
    	}

        
    }
    public void eliminar(long idCliente) throws Exception {
        //en este caso es física en gral. no se se aplicaría este caso de uso, si
        //se hiciera habría que validar que el cliente no tenga dependencias
        Cliente c = dao.traer(idCliente);
        // Implementar que si es null que arroje la excepción la Excepción
        if(c == null ){
        	throw new Exception("No se pudo eliminar el id: "+ idCliente +" , debido a que no existe en la Base de Datos");	
        }
        dao.eliminar(c);
    }
    public List < Cliente > traer() {
        return dao.traer();
    }
	public Cliente traerClienteYContacto(long idCliente) {
		
		Cliente c = dao.traer(idCliente);
		
		
		return c;
	}
}