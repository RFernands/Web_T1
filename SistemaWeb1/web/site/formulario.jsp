<%-- 
    Document   : formulario
    Created on : 25/04/2019, 14:11:18
    Author     : NATASHA
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html> 
    <head>
        <title>Sites de Venda de Ingressos </title> 
    </head>
    <body>
    <center>
        <h1>Sites de Venda de Ingressos</h1>
        <h2>
            <a href="inicial">Pagina Inicial</a>
            &nbsp;&nbsp;&nbsp;
            <a href="adminlogin">Área de Administrador</a>
            &nbsp;&nbsp;&nbsp;
            <a href="criarpromocoes">Criar Promoções</a>
        </h2>    </center>    <div align="center">
            <c:if test="${site != null}"> 
                <form action="atualizacao" method="post"> 
                </c:if>
                    <c:if test="${site == null}">
                        <form action="insercao" method="post"> 
                        </c:if>  
                            <table border="1" cellpadding="5">
                                <caption>
                                    <h2> 
                                        <c:if test="${site != null}">
                                            Edi aã oç
                                        </c:if>
                                            <c:if test="${site == null}">
                                                Cadastro
                                            </c:if>
                                    </h2>
                                </caption>
                                <c:if test="${site != null}"> 
                                    <input type="hidden" name="id" value="<c:out value='${site.id}' />" />
                                </c:if>
                                    <tr> 
                                        <th>Nome: </th>
                                        <td>
                                            <input type="text" name="nome" size="45" required
                                                   value="<c:out value='${site.nome}' />"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>Cidade: </th>
                                        <td>
                                            <input type="text" name="cidade" size="45" required
                                                   value="<c:out value='${site.url}' />"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>CNPJ: </th>
                                        <td>
                                            <input type="text" name="cnpj" size="45" required
                                                   value="<c:out value='${site.telefone}' />"/>
                                        </td>
                                    </tr>
                                    <tr> 
                                        <td colspan="2" align="center"> 
                                            <input type="submit" value="Salva" />
                                        </td>
                                    </tr> 
                            </table>
                        </form> 
        </div>
</body>
</html>