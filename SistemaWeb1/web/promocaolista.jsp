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
        <title>Promocoes</title>
    </head>
    <body>
    <center>
        <h1>Promocoes</h1>
        <h2>
            <a href="teatrocadastro">Pagina Inicial</a>
            &nbsp;&nbsp;&nbsp;
            <a href="sitecadastro">Área de Administrador</a>
            &nbsp;&nbsp;&nbsp;
            <a href="criarpromocoes">Criar Promoções</a>
            &nbsp;&nbsp;&nbsp;
            <a href="listacidades">Buscar por Cidade</a>

        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de Promocoes</h2></caption>
            <tr>
                <th>Nome</th>
                <th>Data</th>
                <th>Horario</th>
                <th>Preço</th>
                <th>URL</th>
                <th>CNPJ do Teatro</th>
            </tr>
            <c:forEach var="promocao" items="${requestScope.listaPromocoes}">
                <tr>
                    <td><c:out value="${promocao.nomePeca}" /></td>
                    <td><c:out value="${promocao.dataPeca}" /></td>
                    <td><c:out value="${promocao.horario}" /></td>
                    <td><c:out value="${promocao.precoPeca}" /></td>
                    <td><c:out value="${promocao.URLdoSite}" /></td>
                    <td><c:out value="${promocao.CNPJdoTeatro}" /></td>                    
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>