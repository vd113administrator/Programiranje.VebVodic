<%-- 
    Document   : index
    Created on : Dec 28, 2017, 3:02:49 PM
    Author     : Mikec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="okrug" class="programiranje.vodic.beans.util.PageEnviromentBean" scope="session"/>
<jsp:useBean id="poruke" class="programiranje.vodic.beans.util.InformacioniBean" scope="session"/>
<%
    if(poruke.getStatus()==null)
        response.sendRedirect("/ProgramiranjeVodicAppWeb/index.jsp");
    else if(poruke.getStatus().equals(""))
        response.sendRedirect("/ProgramiranjeVodicAppWeb/index.jsp");
    else{
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Програмирање</title>
        <link type="text/css" rel="stylesheet" href="CSS-RES/tabulacija.css"/>
        <link type="text/css" rel="stylesheet" href="CSS-RES/index-link.css"/>
    </head>
    <body bgcolor="#ccffcc">
        <jsp:setProperty name="okrug" property="klasa" value="index-link-success"/>
        <div style="font-family: Lucida Console,Lucida Sans Typewriter,monaco,Bitstream Vera Sans Mono,monospace">
            <br><hr><br>
            <jsp:include page="/JSP-PART/komponente/zaglavlje.jsp"></jsp:include>
            <br><hr><br>
            <jsp:include page="/JSP-PART/komponente-vodic/pretraga-fajl-sistema.jsp"></jsp:include>
            <br><hr><br>
            <dl>
                <dt><b>Статусни код</b></dt>
                <dd>${poruke.status}</dd>
            </dl>
            <dl>
                <dt><b>Порука</b></dt>
                <dd>${poruke.poruka}</dd>
            </dl>
            <br><hr><br>
        </div>
    </body>
</html>
<%
       poruke.setStatus("");
       poruke.setPoruka("");
    }
%>