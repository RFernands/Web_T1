<%-- 
    Document   : listateatro
    Created on : 25/04/2019, 16:54:56
    Author     : NATASHA
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<f:bundle basename="i18n.mensagens">
    <html>
        <head>
            <title><f:message key="promo"/></title>
        </head>
        <body>
        <center>
            <h1><f:message key="promo"/></h1>
            <h2>
                <a href="/SistemaWeb1/"><f:message key="pagina.principal"/></a>
                &nbsp;&nbsp;&nbsp;
                <a href="promocaocadastro"><f:message key="cadastrar.promo"/></a>
                &nbsp;&nbsp;&nbsp;

            </h2>
        </center>
        <div align="center">
            <table border="1" cellpadding="5">
                <caption><h2><f:message key="lista.promo"/></h2></caption>
                <tr>
                    <th><f:message key="nome"/></th>
                    <th><f:message key="data"/></th>
                    <th><f:message key="horario"/></th>
                    <th><f:message key="preco"/></th>
                    <th><f:message key="url.site"/></th>
                    <th><f:message key="cnpj.teatro"/></th>
                </tr>
                <c:forEach var="promocao" items="${requestScope.listaPromocoes}">
                    <tr>
                        <td><c:out value="${promocao.nomePeca}" /></td>
                        <td><c:out value="${promocao.dataPeca}" /></td>
                        <td><c:out value="${promocao.horario}" /></td>
                        <td><c:out value="${promocao.precoPeca}" /></td>

                        <td><a href="/SistemaWeb1/promocao/promocaoporsite?URL=<c:out value='${promocao.URLdoSite}' />"
                               onclick>
                                <c:out value="${promocao.URLdoSite}" /></a></td>

                        <td><a href="/SistemaWeb1/promocao/promocaoporteatro?CNPJ=<c:out value='${promocao.CNPJdoTeatro}' />"
                               onclick>
                                <c:out value="${promocao.CNPJdoTeatro}" /></a></td>

                        <td><c:out value="${promocao.ID}" /></td>
                        <td><a href="promocaoedicao?ID=<c:out value='${promocao.ID}' />"><f:message key="edicao"/></a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="promocaoremocao?ID=<c:out value='${promocao.ID}' />"
                               onclick="return confirm('<f:message key="msg.remocao"/>');">
                                <f:message key="remocao"/>
                            </a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>	
    </body>
</html>
</f:bundle>