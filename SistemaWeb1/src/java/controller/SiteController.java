package controller;

import model.Site;
import dao.SiteDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/site/*")
public class SiteController extends HttpServlet {

    private SiteDAO dao;

    @Override
    public void init() {
        dao = new SiteDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/sitecadastro":
                    apresentaFormCadastro(request, response);
                    break;
                case "/siteinsercao":
                    insere(request, response);
                    break;
                case "/siteremocao":
                    remove(request, response);
                    break;
                case "/siteedicao":
                    apresentaFormEdicao(request, response);
                    break;
                case "/siteatualizacao":
                    atualize(request, response);
                    break;
                default:
                    lista(request, response);
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }

    private void lista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Site> listaSites = dao.getAll();
        request.setAttribute("listaSites", listaSites);
        RequestDispatcher dispatcher = request.getRequestDispatcher("site/lista.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("site/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String URL = request.getParameter("URL");
        Site site = dao.get(URL);
        RequestDispatcher dispatcher = request.getRequestDispatcher("site/formulario.jsp");
        request.setAttribute("site", site);
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String URL = request.getParameter("URL");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        Site site = new Site(email, senha, URL, nome, telefone);
        dao.insert(site);
        response.sendRedirect("lista");
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("UTF-8");        
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String URL = request.getParameter("URL");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        Site site = new Site(email, senha, URL, nome, telefone);
        dao.update(site);
        response.sendRedirect("lista");
    }

    private void remove(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String URL = request.getParameter("URL");
        Site site = dao.get(URL);
        dao.delete(site);
        response.sendRedirect("lista");
    }
}
