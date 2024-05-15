package com.emergentes.dao;
import com.emergentes.modelo.seminario;
import java.util.List;

/**
 *
 * @author Villalba
 */
public interface SeminarioDAO {
    public void insert(seminario seminario) throws Exception;
    public void update(seminario seminario) throws Exception;
    public void delete(int id) throws Exception;
    public seminario getById(int id) throws Exception;
    public List<seminario> getAll() throws Exception;
}
