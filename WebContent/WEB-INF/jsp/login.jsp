  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
  
    <h1> Please provide your login details: </h1>
 
	
 <form:form>

			<table>
			<tr>
			<td>
			   <form:label path="email">Email Address:</form:label></td>
               <td><form:input path="email"/> </td>
               <td><form:errors path="email"/></td></tr>
          
			  <tr><td> <form:label path="password">Password:</form:label></td>
                <td><form:password path="password" /></td>
              <td> <form:errors path="password"/></td></tr>
           <tr><td colspan=3 align=center>
               <button type="submit">Login</button>
           
       	</td></tr></table>
       </form:form>
           
 