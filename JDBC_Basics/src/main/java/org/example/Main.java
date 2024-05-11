package org.example;

import org.example.model.Categoria;
import org.example.model.Producto;
import org.example.repository.RepositoryProduct;
import org.example.repository.RepositoryProductImpl;


import java.sql.SQLException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Hello world!");

        //try(Connection conn = ConexionBaseDatos.getConnection()){
        RepositoryProduct<Producto> repositoryProduct = new RepositoryProductImpl();

        System.out.println("======== Lista de productos =========");
        repositoryProduct.findAll().forEach(p -> System.out.println(p));
        //Obtiene el producto con id = 1
        System.out.println("======== Obtener un producto =========");
        System.out.println(repositoryProduct.findById(2));
        Producto producto = new Producto();
        Categoria categoria = new Categoria();

        //Inserta un nuevo producto

        producto.setNombre("Producto 4");
        producto.setPrecio(4000);
        producto.setFechaRegistro(new Date());

        categoria.setId(3L);
        producto.setCategoria(categoria);
        repositoryProduct.save(producto);

        producto.setNombre("Producto 5");
        producto.setPrecio(100);
        producto.setFechaRegistro(new Date());
        categoria.setId(2L);
        producto.setCategoria(categoria);
        repositoryProduct.save(producto);

        producto.setNombre("Producto 6");
        producto.setPrecio(200);
        producto.setFechaRegistro(new Date());
        categoria.setId(1L);
        producto.setCategoria(categoria);
        repositoryProduct.save(producto);

        producto.setNombre("Producto 7");
        producto.setPrecio(300);
        producto.setFechaRegistro(new Date());
        categoria.setId(3L);
        producto.setCategoria(categoria);
        repositoryProduct.save(producto);

        System.out.println("======== Lista de productos =========");
        repositoryProduct.findAll().forEach(p -> System.out.println(p));

        //Actualiza el producto con id = 1
        producto = new Producto();
        producto.setId(4);
        producto.setNombre("Producto editado");
        producto.setPrecio(10);
        producto.setFechaRegistro(new Date());
        categoria.setId(1L);
        producto.setCategoria(categoria);
        repositoryProduct.update(producto);

        System.out.println("======== Producto actualizado =========");
        System.out.println(repositoryProduct.findById(4));

        System.out.println("======== Lista de productos =========");
        repositoryProduct.findAll().forEach(p -> System.out.println(p));

        //Elimina el producto con id = 1
        System.out.println("======== Eliminar un producto =========");
        System.out.println("El producto eliminado es: " + repositoryProduct.findById(2));
        repositoryProduct.deleteById(2);
        System.out.println("======== Lista de productos =========");
        repositoryProduct.findAll().forEach(p -> System.out.println(p));

        //} catch (SQLException e) {
        //  e.printStackTrace();
        //}
    }
}