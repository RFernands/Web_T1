<%-- 
    Document   : listateatro
    Created on : 25/04/2019, 16:54:56
    Author     : NATASHA
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Sites de Venda de Ingressos</title>
    </head>
    <body>
    <center>
        <h1>Sites</h1>
        <h2>
            <a href="/SistemaWeb1/">Página Principal</a>
            &nbsp;&nbsp;&nbsp;
            <a href="sitecadastro">Cadastrar Site de Venda de Ingresso</a>
            &nbsp;&nbsp;&nbsp;

        </h2>
    </center>
    <div align="center">
        <br/>
        <h3>Clique na URL do site para ver todas as promoções desse site</h3>
        
        <table border="1" cellpadding="5">
            <caption><h2>Lista de Sites de Venda de Ingresso</h2></caption>
            <tr>
                <th>Nome</th>
                <th>URL</th>
                <th>Telefone</th>
            </tr>
            <c:forEach var="site" items="${requestScope.listaSites}">
                <tr>
                    <td><c:out value="${site.nome}" /></td>
                   
                    <td><a href="/SistemaWeb1/promocao/promocaoporsite?URL=<c:out value='${site.URL}' />"
                    onclick>                    
                        <c:out value="${site.URL}" /></a></td>
                    <td><c:out value="${site.telefone}" /></td>
                    <td><a href="siteedicao?URL=<c:out value='${site.URL}' />">Edição</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="siteremocao?URL=<c:out value='${site.URL}' />"
                    onclick="return confirm('Tem certeza de que deseja excluir este item?');">
                    Remoção
                </a></td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>