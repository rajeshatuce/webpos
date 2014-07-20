<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <div class="col-sm-3 col-md-2 sidebar">
               <ul class="nav nav-sidebar">
                	 <c:forEach var="category" items="${categoryList}">
    						<c:choose>
 								 <c:when test="${category.selected == 'true'}">
                                         	<li class="active"><a href="home?categoryId=${category.categoryId}">${category.categoryName}</a></li>
  								  </c:when>
  								  <c:otherwise>
                                            <li ><a href="home?categoryId=${category.categoryId}" class="sideSubMenu" data-content="">${category.categoryName}</a></li>
  								  </c:otherwise>
  						     </c:choose>
		        	 </c:forEach>
          </ul>
             </div>