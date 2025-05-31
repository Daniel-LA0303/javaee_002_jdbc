package org.example;

import org.example.model.Categoria;
import org.example.model.Producto;
import org.example.repository.RepositoryProduct;
import org.example.repository.RepositoryProductImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class Trasacciones {

    public static void main(String[] args) throws SQLException {

        /**
         * Transacciones
         */
        try(Connection conn = ConexionBaseDatos.getConnection()){

        	
        	// Inicio de la trasaccion
            if(conn.getAutoCommit()){
                conn.setAutoCommit(false); // lo ponemos false ya que por defecto esta en true esto significa que en true no 
                						   // hay transaccion mientras que en false ponemos que estaremos al pendiente con commit
            }


            System.out.println("Hello world!");

            try {
                RepositoryProduct<Producto> repositoryProduct = new RepositoryProductImpl();

                System.out.println("======== Lista de productos =========");
                repositoryProduct.findAll().forEach(p -> System.out.println(p));
                //Obtiene el producto con id = 1
                System.out.println("======== Obtener un producto =========");
                System.out.println(repositoryProduct.findById(2));
                Producto producto = new Producto();
                Categoria categoria = new Categoria();

                //Inserta un nuevo producto

                System.out.println("Inserta un nuevo producto");
                producto.setNombre("Producto 10");
                producto.setPrecio(10000);
                producto.setFechaRegistro(new Date());

                categoria.setId(3L);
                producto.setCategoria(categoria);
                /**
                 * Inserta el sku
                 */
                producto.setSku("asvcred");
                repositoryProduct.save(producto);


                System.out.println("======== Lista de productos =========");
                repositoryProduct.findAll().forEach(p -> System.out.println(p));

                //Actualiza el producto con id = 1
                producto = new Producto();
                producto.setId(17);
                producto.setNombre("Producto editado");
                producto.setPrecio(10);
                producto.setFechaRegistro(new Date());
                categoria.setId(1L);
                producto.setCategoria(categoria);
                producto.setSku("asvcred");
                repositoryProduct.update(producto);

                System.out.println("======== Producto actualizado =========");
                System.out.println(repositoryProduct.findById(4));

                System.out.println("======== Lista de productos =========");
                repositoryProduct.findAll().forEach(p -> System.out.println(p));

                conn.commit(); //se ejecuta si todas las consultas han salido bien
            }catch (SQLException exception){
                conn.rollback(); // deshace todos los cambios si algo ha salido mal
                exception.printStackTrace();
            }
        }


        //} catch (SQLException e) {
        //  e.printStackTrace();
        //}
    }
}
