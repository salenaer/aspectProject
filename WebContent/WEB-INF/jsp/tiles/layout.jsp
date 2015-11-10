<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<html:xhtml/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="./html/blue.css" >
<title><tiles:getAsString name="title"/> </title>
</head>
<body>
<div id="main">
<div id="header">
<h1><tiles:getAsString name="title"/></h1>

<div id="menu">
<tiles:insert attribute="menu"/>
</div>
</div>
<div id="panel">


<tiles:insert attribute="body"/>

</div>


<tiles:insert attribute="footer"/>

</div>

</body>
</html>  