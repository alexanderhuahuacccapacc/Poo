package pe.edu.upeu.syscenterlife.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.syscenterlife.dao.ClienteDao;
import pe.edu.upeu.syscenterlife.modelo.Cliente;
// este codigo esta el CRUD 
@Service
public class ClienteService {

    ClienteDao clienteDao=new ClienteDao();

    List<Cliente> listaCli = new ArrayList<>();
    //datos permanentes que puedes agregar

    public boolean saveEntidad(Cliente categoria) { //crear
        return this.listaCli.add(categoria);
    }

    public List<Cliente> listarEntidad() {  //report

        return clienteDao.listarCliente();
    }

    public Cliente buscarCliente(String dnirucx) {  //buscrar
        return listaCli.stream()
                .filter(cliente -> cliente.getDniruc().equals(dnirucx))
                .findFirst()
                .orElse(null); // Devuelve null si no se encuentra ningún cliente
    }

    public Cliente updateEntidad(Cliente clientex) {  //udpat p actualizar
        listaCli.stream()
                .filter(cliente
                        -> cliente.getDniruc().equals(clientex.getDniruc())) // Filtrar por DNI
                .findFirst() // Obtener el primer cliente que cumpla con el filtro
                .ifPresent(cliente
                        -> cliente.setNombres(clientex.getNombres()));
        // para cambiar el DNI solo debemos cambiar l nombre por dni
//return this.listaCli.set(index, cliente);
        return buscarCliente(clientex.getDniruc());
    }

    public void deleteRegistEntdad(String dato) {  //eliminar 
        this.listaCli.remove(listaCli.stream()
                .filter(cliente -> cliente.getDniruc().equals(dato))
                .findFirst().orElse(null));
    }
}
