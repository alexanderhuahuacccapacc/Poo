package pe.edu.upeu.syscenterlife.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.syscenterlife.modelo.Producto;
import pe.edu.upeu.syscenterlife.repositorio.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;
    //Create
    public Producto guardarEntidad(Producto cliente){
    return clienteRepository.save(cliente);
    }
    //Report
    public List<Producto> listarEntidad(){
    return clienteRepository.findAll();
    }
    //Update
    public Producto actualizarEntidad(Producto cliente){
    return clienteRepository.save(cliente);
    }
    //Delete
    public void eliminarRegEntidad(String dniruc){
        clienteRepository.delete(clienteRepository.findById(dniruc).get());
    }
    //Buscar
    public Producto buscarCliente(String dniruc){
        return clienteRepository.findById(dniruc).get();
    }
}
