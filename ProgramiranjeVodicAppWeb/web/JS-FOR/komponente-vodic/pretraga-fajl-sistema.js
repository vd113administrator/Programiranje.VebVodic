/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function vodic_forma_postavi(str){
    document.forms['vodic_forma'].vodic_filex.value = str;
}

function vodic_forma_postavi_podaci(str){
    document.forms['vodic_forma'].vodic_datax.value = str;
}

function vodic_forma_postavi_poruka(str){
    document.forms['vodic_forma'].vodic_poruka.value = str; 
}

function vodic_forma_postavi_status(str){
    document.forms['vodic_forma'].vodic_status.value = str; 
}

function vodic_froma_ocitaj(){
    return document.forms['vodic_forma'].vodic_filex.value;
}

function vodic_froma_ocitaj_podaci(){
    return document.forms['vodic_forma'].vodic_datax.value;
}

function vodic_froma_ocitaj_poruka(){
    return document.forms['vodic_forma'].vodic_poruka.value;
}

function vodic_froma_ocitaj_status(){
    return document.forms['vodic_forma'].vodic_status.value;
}

function vodic_forma_reakcija(str){
    vodic_forma_postavi(str);
    vodic_forma_postavi_podaci("");
    document.forms['vodic_forma'].submit();
}

function vodic_forma_reakcija_podaci(str){
    vodic_forma_postavi_podaci(str);
    document.forms['vodic_forma'].submit();
}

function vodic_forma_reakcija_poruka(str){
    vodic_forma_postavi_poruka(str);
    document.forms['vodic_forma'].submit();
}

function vodic_forma_reakcija_status(str){
    vodic_forma_postavi_status(str);
    document.forms['vodic_forma'].submit();
}

function vodic_forma_example(str){
    encodeUriComponenet(str); escape(str);
    str = decodeUriComponenet(str);
    str = unescape(str);
}