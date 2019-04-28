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
            <title><f:message key="sites.venda"/></title>
        </head>
        <body>
        <center>
            <h1><f:message key="sites"/></h1>
            <h2>
                <a href="/SistemaWeb1/"><f:message key="pagina.principal"/></a>
                &nbsp;&nbsp;&nbsp;
                <a href="sitecadastro"><f:message key="cadastrar.site"/></a>
                &nbsp;&nbsp;&nbsp;

            </h2>
        </center>
        <div align="center">
            <br/>
            <h3><f:message key="msg.promo.por.site"/></h3>

            <table border="1" cellpadding="5">
                <caption><h2><f:message key="lista.sites"/></h2></caption>
                <tr>
                    <th><f:message key="nome"/></th>
                    <th><f:message key="url"/></th>
                    <th><f:message key="telefone"/></th>
                </tr>

                <f:message key="url.site"/>: <select id="URLdoSite" name="URLdoSite">
                    <c:forEach var="site" items="${listaSites}">   
                        <option value="<c:out value="${site.URL}" />"><c:out value="${site.URL}"/></option>                            </c:forEach>
                    </select>

                <c:forEach var="site" items="${requestScope.listaSites}">
                    <tr>
                        <td><c:out value="${site.nome}" /></td>

                        <td><a href="/SistemaWeb1/promocao/promocaoporsite?URL=<c:out value='${site.URL}' />"
                               onclick>                    
                                <c:out value="${site.URL}" /></a></td>
                        <td><c:out value="${site.telefone}" /></td>
                        <td><a href="siteedicao?URL=<c:out value='${site.URL}' />"><f:message key="edicao"/></a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="siteremocao?URL=<c:out value='${site.URL}' />"
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