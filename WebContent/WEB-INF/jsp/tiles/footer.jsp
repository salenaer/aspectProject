<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<c:out value="<hr>" escapeXml="false" />

<c:if test='${BankingWebUser!=null}'>Logged in as: <c:out value="${BankingWebUser.email}"/> | <a href=./logout.htm>Logout</a></c:if>

<c:if test='${BankingWebUser==null}'>Not logged in.</c:if>

