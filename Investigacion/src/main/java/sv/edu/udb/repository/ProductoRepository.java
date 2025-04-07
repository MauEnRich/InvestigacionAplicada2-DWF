package sv.edu.udb.repository;

import sv.edu.udb.model.Producto;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class ProductoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Producto> findAll() {
        return entityManager.createQuery("SELECT p FROM Producto  p", Producto.class).getResultList();
    }

    public Producto findById(Long id) {
        return entityManager.find(Producto.class, id);
    }

    @Transactional
    public Producto save(Producto producto) {
        if (producto.getId() == null) {
            entityManager.persist(producto);
            return producto;
        } else {
            return entityManager.merge(producto);
        }
    }

    @Transactional
    public void delete(Long id) {
        Producto producto = findById(id);
        if (producto != null) {
            entityManager.remove(producto);
        }
    }
}
