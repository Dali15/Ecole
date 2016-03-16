<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- html, head and starting body tag ... -->
<table>
	 <tr><td>sdfsmmmm121edfze</td></tr>
    <c:forEach var="element" items="${listData}">
 		${element.nom}
     
        <tr>
            <td>${element.nom}</td> 
            <td>${element.prenom}</td> 
           
            <td>haha</td>
        </tr> 
    </c:forEach>
</table>