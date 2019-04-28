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
        <title><f:message key="teatros"/> </title> 
    </head>
    <body>
    <center>
        <h1><f:message key="teatros"/></h1>
        <h2>
            <a href="/SistemaWeb1/"><f:message key="pagina.principal"/></a>
            &nbsp;&nbsp;&nbsp;
            <a href="teatrocadastro"><f:message key="cadastrar.teatro"/></a>
            &nbsp;&nbsp;&nbsp;
        </h2>    </center>    <div align="center">
            <c:if test="${teatro != null}"> 
                <form action="teatroatualizacao" method="post"> 
                </c:if>
                    <c:if test="${teatro == null}">
                        <form action="teatroinsercao" method="post"> 
                        </c:if>  
                            <table border="1" cellpadding="5">
                                <caption>
                                    <h2> 
                                        <c:if test="${teatro != null}">
                                            <f:message key="edicao"/>
                                        </c:if>
                                            <c:if test="${teatro == null}">
                                                <f:message key="cadastro"/>
                                            </c:if>
                                    </h2>
                                </caption>
                                <c:if test="${teatro != null}"> 
                                    <input type="hidden" name="id" value="<c:out value='${livro.id}' />" />
                                </c:if>
                                    <tr> 
                                        <th><f:message key="nome"/>: </th>
                                        <td>
                                            <input type="text" name="nome" size="45" required
                                                   value="<c:out value='${teatro.nome}' />"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th><f:message key="cidade"/>: </th>
                                        <td>
                                            <input type="text" name="cidade" size="45" required
                                                   value="<c:out value='${teatro.cidade}' />"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th><f:message key="cnpj"/>: </th>
                                        <td>
                                            <input type="text" name="cnpj" size="5" required
                                                   value="<c:out value='${teatro.CNPJ}' />"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th><f:message key="email"/>: </th> 
                                        <td>
                                            <input type="text" name="email" size="45" required
                                                   value="<c:out value='${teatro.email}' />"
                                                   /> 
                                        </td>
                                    </tr> 
                                    <tr>
                                        <th><f:message key="senha"/>: </th> 
                                        <td>
                                            <input type="text" name="senha" size="45" required
                                                   value="<c:out value='${teatro.senha}' />"
                                                   /> 
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