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
						<input type="hidden" id="productKey"
							value="${product.inventoryId}" />
					</div>
				
				</div>
			</div>
  <div class="media-body">
    <h4 class="media-heading">Product Description</h4>
    <p>${product.productDescription}</p>
    <p><a class="btn btn-primary btn-lg" title="Add to Cart" role="button"><img height="50" witdth="90" src="../img/shopping_cart.png"/></a></p>
  </div>
</div>