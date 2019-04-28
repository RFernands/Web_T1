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
            <title><f:message key="promo"/> </title> 
        </head>
        <body>
        <center>
            <h1><f:message key="promo"/></h1>
            <h2>
                <a href="/SistemaWeb1/"><f:message key="pagina.principal"/></a>
                &nbsp;&nbsp;&nbsp;
                <a href="promocaocadastro"><f:message key="cadastrar.promo"/></a>
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
                                    <f:message key="edicao"/>
                                </c:if>
                                <c:if test="${promocao == null}">
                                    <f:message key="cadastro"/>
                                </c:if>
                            </h2>
                        </caption>
                        <c:if test="${promocao != null}"> 
                            <input type="hidden" name="ID" value="<c:out value='${promocao.ID}' />" />
                        </c:if>
                        <tr> 
                            <th><f:message key="nome"/>: </th>
                            <td>
                                <input type="text" name="nomePeca" size="45" required
                                       value="<c:out value='${promocao.nomePeca}' />"/>
                            </td>
                        </tr>
                        <tr>
                            <th><f:message key="data"/>: </th>
                            <td>
                                <input type="text" name="dataPeca" size="45" required
                                       value="<c:out value='${promocao.dataPeca}' />"/>
                            </td>
                        </tr>
                        <tr>
                            <th><f:message key="horario"/>: </th>
                            <td>
                                <input type="text" name="horario" size="5" required
                                       value="<c:out value='${promocao.horario}' />"/>
                            </td>
                        </tr>
                        <tr>
                            <th><f:message key="preco"/>: </th> 
                            <td>

                                <input type="text" name="precoPeca" size="45" required
                                       value="<c:out value='${promocao.precoPeca}' />"
                                       /> 
                            </td>
                        </tr> 
                        <tr>
                            <th><f:message key="url.site"/>: </th> 
                            <td>

                                <select id="URLdoSite" name="URLdoSite">
                                    <c:forEach var="site" items="${requestScope.listaSites}">   
                                        <option value="<c:out value="${site.URL}" />"><c:out value="${site.URL}"/></option>                            </c:forEach>
                                    </select>



                                </td>
                            </tr>
                            <tr>
                                <th><f:message key="cnpj.teatro"/>: </th> 
                                <td>
                                    <input type="text" name="CNPJdoTeatro" size="45" required
                                           value="<c:out value='${promocao.CNPJdoTeatro}' />"
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