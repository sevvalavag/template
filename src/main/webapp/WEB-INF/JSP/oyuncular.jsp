<%@ page import="sevval_main.Oyuncu" %><%--
  Created by IntelliJ IDEA.
  User: Şevval
  Date: 21.07.2022
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<%= oyuncular.length%>--%>
<%--${oyuncular}--%>

   <c:forEach items="${oyuncular}" var="oyuncu">
    <tr>
       <td> <a href="/oyuncudetay?id=${oyuncu.id}"> ${oyuncu.isim}</a> </td>
          <br>
    </tr>
</c:forEach>

<p>Yeni oyuncu oluştur</p>

<form action="/yenioyuncu" method="GET" id="nameForm">
    <div>
        <label for="nameField">yeni oyuncunun ismi</label>
        <input name="isim" id="nameField">
        <button>Kaydet</button>
    </div>
</form>


</body>
</html>
