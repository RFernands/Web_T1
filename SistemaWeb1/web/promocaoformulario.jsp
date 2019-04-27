<%-- 
    Document   : formulario
    Created on : 25/04/2019, 14:11:18
    Author     : NATASHA
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html> 
    <head>
        <title>Promoções </title> 
    </head>
    <body>
    <center>
        <h1>Promoções</h1>
        <h2>
            <a href="/SistemaWeb1/">Página Principal</a>
            &nbsp;&nbsp;&nbsp;
            <a href="promocaocadastro">Cadastrar Promoção</a>
            &nbsp;&nbsp;&nbsp;
           
        </h2>    </center>    <div align="center">
            <c:if test="${promocao != null}"> 
                <form action="promocaoatualizacao" method="post"> 
                </c:if>
                    <c:if test="${promocao == null}">
                        <form action="promocaoinsercao" method="post"> 
                        </c:if>  
                            <table border="1" cellpadding="5">
                                <caption>
                                    <h2> 
                                        <c:if test="${promocao != null}">
                                            Edi aã oç
                                        </c:if>
                                            <c:if test="${promocao == null}">
                                                Cadastro
                                            </c:if>
                                    </h2>
                                </caption>
                                <c:if test="${promocao != null}"> 
                                    <input type="hidden" name="ID" value="<c:out value='${promocao.ID}' />" />
                                </c:if>
                                    <tr> 
                                        <th>Nome: </th>
                                        <td>
                                            <input type="text" name="nomePeca" size="45" required
                                                   value="<c:out value='${promocao.nomePeca}' />"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>Data </th>
                                        <td>
                                            <input type="text" name="dataPeca" size="45" required
                                                   value="<c:out value='${promocao.dataPeca}' />"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>Horario: </th>
                                        <td>
                                            <input type="text" name="horario" size="5" required
                                                   value="<c:out value='${promocao.horario}' />"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>Preço: </th> 
                                        <td>
                                            <input type="text" name="precoPeca" size="45" required
                                                   value="<c:out value='${promocao.precoPeca}' />"
                                                   /> 
                                        </td>
                                    </tr> 
                                    <tr>
                                        <th>URL: </th> 
                                        <td>
                                            <input type="text" name="URLdoSite" size="45" required
                                                   value="<c:out value='${promocao.URLdoSite}' />"
                                                   /> 
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>CNPJ do teatro: </th> 
                                        <td>
                                            <input type="text" name="CNPJdoTeatro" size="45" required
                                                   value="<c:out value='${promocao.CNPJdoTeatro}' />"
                                                   /> 
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