package com.emergentes.controlador;

import com.emergentes.dao.SeminarioDAO;
import com.emergentes.dao.SeminarioDAOimpl;
import com.emergentes.modelo.seminario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Villalba
 */
@WebServlet(name = "inicio", urlPatterns = {"/inicio"})
public class inicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            SeminarioDAO dao = new SeminarioDAOimpl();
            int id;
            seminario sem = new seminario();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("seminario", sem);
                    request.getRequestDispatcher("frmsemiario.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    sem = dao.getById(id);
                    System.out.println(sem);
                    request.setAttribute("seminario", sem);
                    request.getRequestDispatcher("frmsemiario.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath()+"/inicio");
                    break;
                case "view":
                    List<seminario> lista = dao.getAll();
                    request.setAttribute("seminario", lista);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                default:
                    break;
            }
            
        } catch (Exception e) {
            System.out.println("Error "+ e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombres");
        String apellido = request.getParameter("apellidos");
        String seminari = request.getParameter("seminario");
        String confimado = request.getParameter("confimado");
        String fecha = request.getParameter("fecha");
        seminario sem = new seminario();
        sem.setId(id);
        sem.setNombre(nombre);
        sem.setApellidos(apellido);
        sem.setSeminarios(seminari);
        sem.setConfimado(confimado);
        sem.setFecha(fecha);
        
        if (id==0) {
            try {
                SeminarioDAO dao = new SeminarioDAOimpl();
                dao.insert(sem);
                response.sendRedirect(request.getContextPath()+"/inicio");
            } catch (Exception e) {
                System.out.println("Error "+ e.getMessage());
            }
        }else{
            try {
                SeminarioDAO dao = new SeminarioDAOimpl();
                dao.update(sem);
                response.sendRedirect(request.getContextPath()+"/inicio");
            } catch (Exception e) {
                System.out.println("Error "+ e.getMessage());
            }
        }
    }

}
