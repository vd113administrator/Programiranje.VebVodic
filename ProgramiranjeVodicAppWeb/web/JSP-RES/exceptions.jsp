<%-- 
    Document   : index
    Created on : Dec 28, 2017, 3:02:49 PM
    Author     : Mikec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true"%>  
<% 
    if(pageContext.getErrorData().getStatusCode()==404){
        response.sendRedirect("/ProgramiranjeVodicAppWeb/index.jsp");
    }else{
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Програмирање</title>
        <link type="text/css" rel="stylesheet" href="CSS-RES/tabulacija.css"/>
        <link type="text/css" rel="stylesheet" href="CSS-RES/index-link.css"/>
        <jsp:useBean id="okrug" class="programiranje.vodic.beans.util.PageEnviromentBean" scope="session"/>
    </head>
    <body bgcolor="#ffe6e6">
        <jsp:setProperty name="okrug" property="klasa" value="index-link-error"/>
        <div style="font-family: Lucida Console,Lucida Sans Typewriter,monaco,Bitstream Vera Sans Mono,monospace">
            <br><hr><br>
            <jsp:include page="/JSP-PART/komponente/zaglavlje.jsp"></jsp:include>
            <br><hr><br>
            <jsp:include page="/JSP-PART/komponente-vodic/pretraga-fajl-sistema.jsp"></jsp:include>
            <br><hr><br>
            <dl>
                <dt><b>Статусни код</b></dt>
                <dd>${pageContext.errorData.statusCode}</dd>
            </dl>
            <dl>
                <dt><b>Име сервлета</b></dt>
                <dd>${pageContext.errorData.servletName}</dd>
            </dl>
            <dl>
                <dt><b>Долазна путања</b></dt>
                <dd>${pageContext.errorData.requestURI}</dd>
            </dl>
            <dl>
                <dt><b>Тип изузетка</b></dt>
                <dd>${pageContext.exception.getClass().getName()}</dd>
            </dl>
            <dl>
                <dt><b>Опис изузетка</b></dt>
                <dd>${pageContext.exception.message}</dd>
            </dl>
            <dl>
                <dt onclick="errsteFF()" class="manual-link"><b>Детаљи изузетка</b></dt>
                <dd id="errste" style="display: none"><%
                    Exception ex = pageContext.getException(); 
                    for(StackTraceElement ste: ex.getStackTrace()){
                        out.println(ste.toString());
                    }
                %></dd>
            </dl>
            <script>
                function errsteFF(){
                    var show = document.getElementById("errste").style.display; 
                    if(show==="none") document.getElementById("errste").style.display="block"; 
                    else document.getElementById("errste").style.display="none";
                }
            </script>
            <br><hr><br>
        </div>
    </body>
</html>
<%
    }
%>