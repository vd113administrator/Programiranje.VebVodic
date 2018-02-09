<%-- 
    Document   : index
    Created on : Dec 28, 2017, 3:02:49 PM
    Author     : Mikec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="/JSP-RES/exceptions.jsp" %>  

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Програмирање</title>
        <link type="text/css" rel="stylesheet" href="CSS-RES/tabulacija.css"/>
        <link type="text/css" rel="stylesheet" href="CSS-RES/index-link.css"/>
        <jsp:useBean id="okrug" class="programiranje.vodic.beans.util.PageEnviromentBean" scope="session"/>
        <jsp:useBean id="poruke" class="programiranje.vodic.beans.util.InformacioniBean" scope="session"/>
    </head>
    <body bgcolor="aliceblue">
        <jsp:setProperty name="okrug" property="klasa" value="index-link"/>
        <div style="font-family: Lucida Console,Lucida Sans Typewriter,monaco,Bitstream Vera Sans Mono,monospace">
            <br><hr><br>
            <jsp:include page="/JSP-PART/komponente/zaglavlje.jsp"></jsp:include>
            <br><hr><br>
            <jsp:include page="/JSP-PART/komponente-vodic/pretraga-fajl-sistema.jsp"></jsp:include>
            <br><hr><br>
        </div>
    </body>
</html>
