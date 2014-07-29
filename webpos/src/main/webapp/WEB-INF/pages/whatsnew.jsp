<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="starter-template">
	<div class="row">
		<c:forEach var="product" items="${productList}">
			<div class="col-sm-6 col-md-3">
				<div class="thumbnail">
					<img alt="135%x194" class="productImage" data-src="holder.js/135%x194"
						style="height: 194px; width: 160px; display: block;"
						src="getResource?imageId=${product.productImageUrl}">
					<div class="caption">
						<p>${product.productName}</p>
						<h3>Rs.${product.productPrice}</h3>
						<input type="hidden" id="productKey"
							value="${product.inventoryId}" />
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
<form id="productSelection" action="selectProduct" method="post">
 <input type="hidden" name="selectedProduct" id="selectedProduct"/>
 <input type="hidden" name="categoryId" id="categoryId"/>
</form>