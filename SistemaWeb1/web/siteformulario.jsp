<%-- 
    Document   : formulario
    Created on : 25/04/2019, 14:11:18
    Author     : NATASHA
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<f:bundle basename="i18n.mensagens">
<html> 
    <head>
        <title><f:message key="sites.venda"/></title> 
    </head>
    <body>
    <center>
        <h1><f:message key="sites.venda"/></h1>
        <h2>
            <a href="/SistemaWeb1/"><f:message key="pagina.principal"/></a>
            &nbsp;&nbsp;&nbsp;
            <a href="sitecadastro"><f:message key="cadastrar.site"/></a>
            &nbsp;&nbsp;&nbsp;
            
        </h2>    </center>    <div align="center">
            <c:if test="${site != null}"> 
                <form action="siteatualizacao" method="post"> 
                </c:if>
                    <c:if test="${site == null}">
                        <form action="siteinsercao" method="post"> 
                        </c:if>  
                            <table border="1" cellpadding="5">
                                <caption>
                                    <h2> 
                                        <c:if test="${site != null}">
                                            <f:message key="edicao"/>
                                        </c:if>
                                            <c:if test="${site == null}">
                                                <f:message key="cadastro"/>
                                            </c:if>
                                    </h2>
                                </caption>
                                <c:if test="${site != null}"> 
                                    <input type="hidden" name="id" value="<c:out value='${livro.id}' />" />
                                </c:if>
                                    <tr> 
                                        <th><f:message key="nome"/>: </th>
                                        <td>
                                            <input type="text" name="nome" size="45" required
                                                   value="<c:out value='${site.nome}' />"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th><f:message key="url"/>: </th>
                                        <td>
                                            <input type="text" name="URL" size="45" required
                                                   value="<c:out value='${site.URL}' />"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th><f:message key="telefone"/>: </th>
                                        <td>
                                            <input type="text" name="telefone" size="45" required
                                                   value="<c:out value='${site.telefone}' />"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th><f:message key="email"/>: </th>
                                        <td>
                                            <input type="text" name="email" size="45" required
                                                   value="<c:out value='${site.email}' />"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th><f:message key="senha"/>: </th>
                                        <td>
                                            <input type="text" name="senha" size="45" required
                                                   value="<c:out value='${site.senha}' />"/>
                                        </td>
                                    </tr>
                                    <tr> 
                                        <td colspan="2" align="center"> 
                                            <input type="submit" value="<f:message key="salvar"/>" />
                                        </td>
                                    </tr> 
                            </table>
                        </form> 
        </div>
</body>
</html>
</f:bundle>