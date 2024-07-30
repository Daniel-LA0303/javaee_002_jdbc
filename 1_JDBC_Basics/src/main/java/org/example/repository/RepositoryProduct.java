package org.example.repository;

import java.sql.SQLException;
import java.util.List;

public interface RepositoryProduct<T> {
    //estos seran nuestros metodos
    List<T> findAll();

    T findById(int id) throws SQLException;

    void save(T t);


    void update(T t);

    void deleteById(int id);

}
