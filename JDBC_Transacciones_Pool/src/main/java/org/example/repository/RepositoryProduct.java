package org.example.repository;

import java.sql.SQLException;
import java.util.List;

public interface RepositoryProduct<T> {
    //estos seran nuestros metodos
    List<T> findAll() throws SQLException;

    T findById(int id) throws SQLException;

    T save(T t) throws SQLException;


    void update(T t) throws SQLException;

    void deleteById(int id) throws SQLException;

}
