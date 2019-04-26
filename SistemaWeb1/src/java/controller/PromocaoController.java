package controller;

import model.Promocao;
import dao.PromocaoDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/promocao/*")
public class PromocaoController extends HttpServlet {

    private PromocaoDAO dao;

    @Override
    public void init() {
        dao = new PromocaoDAO();
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
                case "/cadastro":
                    apresentaFormCadastro(request, response);
                    break;
                case "/insercao":
                    insere(request, response);
                    break;
                case "/remocao":
                    remove(request, response);
                    break;
                case "/edicao":
                    apresentaFormEdicao(request, response);
                    break;
                case "/atualizacao":
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
        List<Promocao> listaPromocoes = dao.getAll();
        request.setAttribute("listaPromocoes", listaPromocoes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("promocao/lista.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("promocao/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int ID = Integer.parseInt(request.getParameter("ID"));
        Promocao promocao = dao.get(ID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("promocao/formulario.jsp");
        request.setAttribute("promocao", promocao);
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("UTF-8");
        String URLdoSite = request.getParameter("URLdoSite");
        String CNPJdoTeatro = request.getParameter("CNPJdoTeatro");
        String nomePeca = request.getParameter("nomePeca");
        float precoPeca = Float.parseFloat(request.getParameter("precoPeca"));
        String dataPeca = request.getParameter("dataPeca");
        String horario = request.getParameter("horario");
        Promocao promocao = new Promocao(URLdoSite, CNPJdoTeatro, nomePeca, precoPeca, dataPeca, horario);
        dao.insert(promocao);
        response.sendRedirect("lista");
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("UTF-8");
        String URLdoSite = request.getParameter("URLdoSite");
        String CNPJdoTeatro = request.getParameter("CNPJdoTeatro");
        String nomePeca = request.getParameter("nomePeca");
        float precoPeca = Float.parseFloat(request.getParameter("precoPeca"));
        String dataPeca = request.getParameter("dataPeca");
        String horario = request.getParameter("horario");
        Promocao promocao = new Promocao(URLdoSite, CNPJdoTeatro, nomePeca, precoPeca, dataPeca, horario);
        dao.update(promocao);
        response.sendRedirect("lista");
    }

    private void remove(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int ID = Integer.parseInt(request.getParameter("ID"));
        Promocao promocao = dao.get(ID);
        dao.delete(promocao);
        response.sendRedirect("lista");
    }
}