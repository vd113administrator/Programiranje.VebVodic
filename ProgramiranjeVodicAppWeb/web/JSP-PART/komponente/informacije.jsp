<%-- 
    Document   : informacije
    Created on : Dec 29, 2017, 8:19:21 AM
    Author     : Mikec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <jsp:useBean id="vodic" class="programiranje.vodic.beans.VodicBean" scope="session"/>
        <jsp:useBean id="okrug" class="programiranje.vodic.beans.util.PageEnviromentBean" scope="session"/>
        <table cellspacing="0" border="1" style="border-color: black">
              <tr><td><b>Сесија</b></td><td><jsp:include page="/InfoServlet"></jsp:include></td></tr>
              <tr><td><b>Корен</b></td><td><jsp:getProperty name="vodic" property="osnovnaPutanja"/></td></tr>
        </table>
        <br><br>
