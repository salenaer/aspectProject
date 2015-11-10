<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1><c:out value="${BankingWebUser.name }"/>, these are your accounts: </h1>

<ul>
<c:forEach items="${accounts}" var="account">
<li>
	<c:url value="./accountDetails.htm" var="blue"><c:param name="name" value="${account.name}"></c:param></c:url>
	<b><bean:write name="account" property="name"/>: </b>
	<c:out value="${account.value }"/>
	
	( <a href='<c:out value="${blue}"/>'> View History </a> )
	 
</li>
</c:forEach>
</ul>