<%--
  Created by IntelliJ IDEA.
  User: Şevval
  Date: 21.07.2022
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

${oyuncu}
<br>
<br>
${oyuncu.isim}
<br>
${oyuncu.dogumTarihi}

<br>
<br>

<form action="/oyuncudetay?filename=${oyuncu.okunandosya.name}" method="POST">
    <label for="dname">Dizi adı:</label>
    <br>
    <input type="text" id="dname"
           name="dname"><br><br>
    <input type="submit" value="Yeni Dizi Ekle">
</form>

</body>
</html>
