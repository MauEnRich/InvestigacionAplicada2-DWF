package sv.edu.udb.service;

import sv.edu.udb.model.Producto;
import sv.edu.udb.repository.ProductoRepository;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("api/productos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductoService {

    @Inject
    private ProductoRepository productoRepository;

    @GET
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @GET
    @Path("/{id}")
    public Producto getProductoById(@PathParam("id") Long id) {
        return productoRepository.findById(id);
    }

    @POST
    @Transactional
    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Producto updateProducto(@PathParam("id") Long id, Producto producto) {
        producto.setId(id);
        return productoRepository.save(producto);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void deleteProducto(@PathParam("id") Long id) {
        productoRepository.delete(id);
    }
}
