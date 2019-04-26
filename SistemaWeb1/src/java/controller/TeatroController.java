package controller;

import model.Teatro;
import dao.TeatroDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/teatro/*"})
public class TeatroController extends HttpServlet {

    private TeatroDAO dao;

    @Override
    public void init() {
        dao = new TeatroDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        String action = request.getRequestURI();
        action = action.split("/")[action.split("/").length - 1];
        try {
            switch (action) {
                case "teatrocadastro":
                    apresentaFormCadastro(request, response);
                    break;
                case "teatroinsercao":
                    insere(request, response);
                    break;
                case "teatroremocao":
                    remove(request, response);
                    break;
                case "teatroedicao":
                    apresentaFormEdicao(request, response);
                    break;
                case "teatroatualizacao":
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
        List<Teatro> listaTeatros = dao.getAll();
        request.setAttribute("listaTeatros", listaTeatros);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/teatrolista.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/teatroformulario.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String CNPJ = request.getParameter("CNPJ");
        Teatro teatro = dao.get(CNPJ);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/teatroformulario.jsp");
        request.setAttribute("teatro", teatro);
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String CNPJ = request.getParameter("cnpj");
        String nome = request.getParameter("nome");
        String cidade = request.getParameter("cidade");
        Teatro teatro = new Teatro(email, senha, CNPJ, nome, cidade);
        dao.insert(teatro);
        response.sendRedirect("lista");
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String CNPJ = request.getParameter("CNPJ");
        String nome = request.getParameter("nome");
        String cidade = request.getParameter("cidade");
        Teatro teatro = new Teatro(email, senha, CNPJ, nome, cidade);
        dao.update(teatro);
        response.sendRedirect("lista");
    }

    private void remove(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String CNPJ = request.getParameter("CNPJ");
        Teatro teatro = dao.get(CNPJ);
        dao.delete(teatro);
        response.sendRedirect("lista");
    }

    private void filterCidade(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cidade = request.getParameter("cidade");
        List<Teatro> listaTeatros = dao.getByCity(cidade);
        request.setAttribute("listaTeatros", listaTeatros);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/teatrolista.jsp");
        dispatcher.forward(request, response);
    }
}
