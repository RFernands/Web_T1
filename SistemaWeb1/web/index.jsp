<%-- 
    Document   : index
    Created on : 26/04/2019, 10:37:51
    Author     : NATASHA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<f:bundle basename="i18n.mensagens">
<!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title><f:message key="page.title"/></title>
        </head>
        <body>
            <h1><f:message key="bem.vindo"/></h1>

            <h2>
                <a href="teatro/lista"><f:message key="teatros"/></a>
                &nbsp;&nbsp;&nbsp;
                <a href="site/lista"><f:message key="sites.venda"/></a>
                &nbsp;&nbsp;&nbsp;
                <a href="promocao/lista"><f:message key="promo"/></a>
                &nbsp;&nbsp;&nbsp;

            </h2>
        </body>
    </html>
</f:bundle>
