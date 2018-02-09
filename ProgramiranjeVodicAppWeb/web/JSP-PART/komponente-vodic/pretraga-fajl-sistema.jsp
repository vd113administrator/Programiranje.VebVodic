<%-- 
    Document   : pretraga-fajl-sistema
    Created on : Dec 29, 2017, 8:19:56 AM
    Author     : Mikec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
        
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <jsp:useBean id="vodic" class="programiranje.vodic.beans.VodicBean" scope="session"/>
        <jsp:useBean id="okrug" class="programiranje.vodic.beans.util.PageEnviromentBean" scope="session"/>
        <jsp:setProperty name="vodic" property="naslov" value="ОСНОВНИ ВОДИЧ"></jsp:setProperty>
        <jsp:setProperty name="vodic" property="opis" value="ПРЕТРАГА КОРИЈЕНСКОГ ДИРЕКТОРИЈУМА"></jsp:setProperty>
        <script type='text/javascript' src="./JS-FOR/komponente-vodic/pretraga-fajl-sistema.js"></script>
        <form name='vodic_forma' method='post' action='VodicController'>
            <input type='hidden' name='vodic_filex'/>
            <input type='hidden' name='vodic_datax'/>
            <input type="hidden" name="vodic_poruka"/>
            <input type="hidden" name="vodic_status"/>
            <table border='1' cellspacing='0'>
                <tr>
                    <td><b><jsp:getProperty name="vodic" property="naslov"/>:</b></td>
                    <td><jsp:getProperty name="vodic" property="opis"/></td>
                </tr>
            </table>
            <br>
            <div class="${okrug.klasa}"><b><jsp:getProperty name="vodic" property="kodAktivnePutanje"/></b></div>
            <br>
            <table cellspacing="20">
                <tr valign="top">
                    <td><jsp:getProperty name="vodic" property="kodListeDirektorijuma"/></td>
                    <td><div class="tab1"></div></td>
                    <td><jsp:getProperty name="vodic" property="kodListeDatoteka"/></td>
                    <td>
                        <div class="tab1">
                            <table cellspacing='0' border='1'>
                                <tr>
                                    <td>
                                        <b>Директоријум : </b>
                                    </td>
                                    <td>
                                        <jsp:getProperty name="vodic" property="kodAktivnePutanje"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <b>Датотека : </b>
                                    </td>
                                    <td>
                                       <jsp:getProperty name="vodic" property="datoteka"/>
                                    </td>
                                </tr>
                            </table>
                            <dl>
                               <dt><b>ОПЕРАЦИЈЕ АПЛИКАЦИЈЕ : 2</b></dt>
                               <dd class="manual-link" onclick="vodic_forma_reakcija_status('vodic:app:save')">&gt;Чување стања&lt;</dd>
                               <dd class="manual-link" onclick="vodic_forma_reakcija_status('vodic:app:open')">&gt;Очитавање стања&lt;</dd>
                            </dl>
                            <dl>
                               <dt><b>ОПЕРАЦИЈЕ ДАТОТЕКА : 1</b></dt>
                               <dd class="manual-link" onclick="vodic_forma_reakcija_status('vodic:app:download')">&gt;Преузимање&lt;</dd>
                            </dl>
                        </div>
                    </td>
                </tr>
            </table>
        </form>