package org.example.repository;

import org.example.ConexionBaseDatos;
import org.example.model.Categoria;
import org.example.model.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryProductImpl implements RepositoryProduct{


    //Esto seria como nuestro ORM (Object Relational Mapping)

    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getConnection();
    }
    //despues de categoria
    @Override
    public List findAll() {

        List<Producto> productos = new ArrayList<>();

        try(
                Connection conn = getConnection(); //Esto hace que se cierre la conexion
                Statement stmt = conn.createStatement();
                ResultSet res = stmt.executeQuery("select p.*, c.nombre as categoria" +
                        " from productos as p inner join categorias as c on p.categoria_id = c.id");

        ){
            while (res.next()){
                Producto producto = crearProducto(res);
                productos.add(producto);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return productos;
    }

    @Override
    public Producto findById(int id){
        Producto producto = null;
        try(Connection conn = getConnection();
            PreparedStatement stmt = conn
                    .prepareStatement("select p.*, c.nombre as categoria" +
                            " from productos as p inner join categorias as c on (p.categoria_id = c.id) where p.id = ?")
        ){
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();

            if(res.next()){
                producto = crearProducto(res);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return producto;
    }

    @Override
    public void save(Object o) {
        String sql = "insert into productos(nombre, precio, categoria_id, fecha_registro) values(?, ?, ?, ?)";
        try(
                Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)){
            Producto p = (Producto) o;
            stmt.setString(1, p.getNombre());
            stmt.setInt(2, p.getPrecio());
            stmt.setInt(3, Math.toIntExact(p.getCategoria().getId()));
            stmt.setDate(4, new Date(p.getFechaRegistro().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Object o) {
        String sql = "update productos set nombre = ?, precio = ?, categoria_id=? , fecha_registro = ? where id = ?";
        try(
                Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)){
            Producto p = (Producto) o;
            stmt.setString(1, p.getNombre());
            stmt.setInt(2, p.getPrecio());
            stmt.setInt(3, Math.toIntExact(p.getCategoria().getId()));
            stmt.setDate(4, new Date(p.getFechaRegistro().getTime()));
            stmt.setInt(5, p.getId());
            stmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void deleteById(int id) {

        String sql = "delete from productos where id = ?";
        try(
                Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    private Producto crearProducto(ResultSet res) throws SQLException {
        Producto producto = new Producto();
        producto.setId(res.getInt("id"));
        producto.setNombre(res.getString("nombre"));
        producto.setPrecio(res.getInt("precio"));
        producto.setFechaRegistro(res.getDate("fecha_registro"));
        Categoria cateogoria = new Categoria();
        cateogoria.setId(res.getLong("categoria_id"));
        cateogoria.setNombre(res.getString("categoria"));
        producto.setCategoria(cateogoria);
        return producto;
    }



    //antde categoria

    /*
    @Override
    public List findAll() {

        List<Producto> productos = new ArrayList<>();

        try(
                Statement stmt = getConnection().createStatement();
                ResultSet res = stmt.executeQuery("select * from productos");

                ){
                while (res.next()){
                    Producto producto = crearProducto(res);
                    productos.add(producto);
                }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return productos;
    }

    @Override
    public Producto findById(int id){
        Producto producto = null;
        try(PreparedStatement stmt = getConnection()
                .prepareStatement("select * from productos where id = ?");
            ){
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();

            if(res.next()){
                producto = crearProducto(res);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return producto;
    }

    @Override
    public void save(Object o) {
        String sql = "insert into productos(nombre, precio, fecha_registro) values(?, ?, ?)";
        try(PreparedStatement stmt = getConnection().prepareStatement(sql)){
            Producto p = (Producto) o;
            stmt.setString(1, p.getNombre());
            stmt.setInt(2, p.getPrecio());
            stmt.setDate(3, new Date(p.getFechaRegistro().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Object o) {
        String sql = "update productos set nombre = ?, precio = ?, fecha_registro = ? where id = ?";
        try(PreparedStatement stmt = getConnection().prepareStatement(sql)){
            Producto p = (Producto) o;
            stmt.setString(1, p.getNombre());
            stmt.setInt(2, p.getPrecio());
            stmt.setDate(3, new Date(p.getFechaRegistro().getTime()));
            stmt.setInt(4, p.getId());
            stmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void deleteById(int id) {

        String sql = "delete from productos where id = ?";
        try(PreparedStatement stmt = getConnection().prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    private Producto crearProducto(ResultSet res) throws SQLException {
        Producto producto = new Producto();
        producto.setId(res.getInt("id"));
        producto.setNombre(res.getString("nombre"));
        producto.setPrecio(res.getInt("precio"));
        producto.setFechaRegistro(res.getDate("fecha_registro"));
        return producto;
    }

     */
}

