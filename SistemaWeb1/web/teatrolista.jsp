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
        <title><f:message key="teatros"/></title>
    </head>
    <body>
    <center>
        <h1><f:message key="teatros"/></h1>
        <h2>
            <a href="/SistemaWeb1/"><f:message key="pagina.principal"/></a>
            &nbsp;&nbsp;&nbsp;
            <a href="teatrocadastro"><f:message key="cadastrar.teatro"/></a>
            &nbsp;&nbsp;&nbsp;

        </h2>
    </center>
    <div align="center">
        <br/>
        <h3><f:message key="msg.promo.por.teatro"/></h3>
        <h3><f:message key="msg.teatro.por.cidade"/></h3>
        
        <table border="1" cellpadding="5">
            <caption><h2><f:message key="lista.teatros"/></h2></caption>
            <tr>
                <th><f:message key="nome"/></th>
                <th><f:message key="cidade"/></th>
                <th><f:message key="cnpj"/></th>
            </tr>
            <br/>
            <c:forEach var="teatro" items="${requestScope.listaTeatros}">
                <tr>
                    <td><a href="/SistemaWeb1/promocao/promocaoporteatro?CNPJ=<c:out value='${teatro.CNPJ}' />"
                    onclick>
                    <c:out value="${teatro.nome}" />  </a></td>
                    
                    
                    <td><a href="/SistemaWeb1/teatro/teatroporcidade?cidade=<c:out value='${teatro.cidade}' />"
                    onclick>
                    <c:out value="${teatro.cidade}" /></a></td>
                    <td><c:out value="${teatro.CNPJ}" /></td>
                    <td><a href="teatroedicao?CNPJ=<c:out value='${teatro.CNPJ}' />"><f:message key="edicao"/></a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="teatroremocao?CNPJ=<c:out value='${teatro.CNPJ}' />"
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