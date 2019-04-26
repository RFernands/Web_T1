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
        <title>Teatros</title>
    </head>
    <body>
    <center>
        <h1>Teatros</h1>
        <h2>
            <a href="teatro/lista">Teatros</a>
            &nbsp;&nbsp;&nbsp;
            <a href="site/lista">Sites de Venda de Ingresso</a>
            &nbsp;&nbsp;&nbsp;
            <a href="promocao/lista">Promoções</a>
            &nbsp;&nbsp;&nbsp;

        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de Teatros</h2></caption>
            <tr>
                <th>Nome</th>
                <th>Cidade</th>
                <th>CNPJ</th>
            </tr>
            <c:forEach var="teatro" items="${requestScope.listaTeatros}">
                <tr>
                    <td><c:out value="${teatro.nome}" /></td>
                    <td><c:out value="${teatro.cidade}" /></td>
                    <td><c:out value="${teatro.CNPJ}" /></td>
                    <td><a href="teatroedicao?CNPJ=<c:out value='${teatro.CNPJ}' />">Edição</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="teatroremocao?CNPJ=<c:out value='${teatro.CNPJ}' />"
                    onclick="return confirm('Tem certeza de que deseja excluir este item?');">
                    Remoção
                </a></td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>