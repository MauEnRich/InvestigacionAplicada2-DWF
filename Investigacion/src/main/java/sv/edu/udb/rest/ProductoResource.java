package sv.edu.udb.rest;

import sv.edu.udb.model.Producto;
import sv.edu.udb.repository.ProductoRepository;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/productos")
public class ProductoResource {

    @Inject
    ProductoRepository productoRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }
}
