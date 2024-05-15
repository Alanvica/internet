package com.emergentes.dao;

import com.emergentes.modelo.seminario;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Villalba
 */
public class SeminarioDAOimpl extends ConexionDB implements SeminarioDAO {

    @Override
    public void insert(seminario seminario) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("insert into estudiantes(nombres, apellidos, seminario, confimado, fecha) values(?, ?, ?, ?, ?)");
            ps.setString(1, seminario.getNombre());
            ps.setString(2, seminario.getApellidos());
            ps.setString(3, seminario.getSeminarios());
            ps.setString(4, seminario.getConfimado());
            ps.setString(5, seminario.getFecha());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(seminario seminario) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("update estudiantes set nombres =?, apellidos=?, seminario=?, confimado=?, fecha=? where id=?");
            ps.setString(1, seminario.getNombre());
            ps.setString(2, seminario.getApellidos());
            ps.setString(3, seminario.getSeminarios());
            ps.setString(4, seminario.getConfimado());
            ps.setString(5, seminario.getFecha());
            ps.setInt(6, seminario.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("delete from estudiantes where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public seminario getById(int id) throws Exception {
        seminario sem = new seminario();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("select * from estudiantes where id= ? limit 1");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                sem.setId(rs.getInt("id"));
                sem.setNombre(rs.getString("nombres"));
                sem.setApellidos(rs.getString("apellidos"));
                sem.setSeminarios(rs.getString("seminario"));
                sem.setConfimado(rs.getString("confimado"));
                sem.setFecha(rs.getString("fecha"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return sem;
    }

    @Override
    public List<seminario> getAll() throws Exception {
        List<seminario> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("select * from estudiantes");
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<seminario>();
            while (rs.next()) {
                seminario sem = new seminario();
                sem.setId(rs.getInt("id"));
                sem.setNombre(rs.getString("nombres"));
                sem.setApellidos(rs.getString("apellidos"));
                sem.setSeminarios(rs.getString("seminario"));
                sem.setConfimado(rs.getString("confimado"));
                sem.setFecha(rs.getString("fecha"));
                lista.add(sem);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }

}
