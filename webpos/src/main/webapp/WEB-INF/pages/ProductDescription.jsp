<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="media">
  <div class="col-sm-6 col-md-5">
				<div class="thumbnail">
					<img alt="135%x194" class="" data-src="holder.js/135%x194"
						style="height: 440px; width: 380px; display: block;"
						src="getResource?imageId=${product.productImageUrl}">
						<div class="caption">
						<p class="alignCenter">${product.productName}</p>
						<h3 class="alignCenter">Rs.${product.productPrice}</h3>
						<form id="toggleCartForm" action="selectProduct" method="post">
						<input type="hidden" id="selectedProduct" name="selectedProduct"
							value="${product.inventoryId}" />
						<input type="hidden" name="categoryId" value="" id="categoryId" />
						<input type="hidden" name="addProductToCart" id="addProductToCart" value="0" />
						</form>
						
					</div>
				
				</div>
			</div>
  <div class="media-body">
    <h4 class="media-heading">Product Description</h4>
    <p>${product.productDescription}</p>
    <p>Color: ${product.color}</p>
    <p>Size: ${product.size} </p>
    <p>Quantity Available: ${product.quantityAvailable}</p>
    <p><a id="cartButton" class="btn btn-primary btn-lg" id="toggleCart" title="Add to Cart" role="button">
    <c:choose>
    <c:when test="${isSelectedProductAddedToCart}">
    <img  height="50" witdth="90" src="../img/tick.png"/>
    </c:when>
    <c:otherwise>
    <img  height="50" witdth="90" src="../img/shopping_cart.png"/>
    </c:otherwise>
    
    </c:choose>
    
    
    </a></p>
  </div>
</div>