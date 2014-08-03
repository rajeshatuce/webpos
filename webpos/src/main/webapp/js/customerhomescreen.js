$(document).ready(function(){
	
	$(".productImage").click(function(event){
		var selectedObj=event.target;
		var selectedProduct=$(selectedObj).parent().find("input:hidden").val();
		$("#selectedProduct").val(selectedProduct);
		var childLink=$(".active").children()[0];
		var linkRef=$(childLink).attr('href');
		$("#categoryId").val(linkRef.split("=")[1]);
		$("#productSelection").submit();
	});
	
	$("#cartButton").click(function(event){
		var childLink=$(".active").children()[0];
		var linkRef=$(childLink).attr('href');
		$("#categoryId").val(linkRef.split("=")[1]);
		if($("#cartButton").find("img").attr("src").indexOf("shopping_cart.png")!=-1){
			$("#addProductToCart").val(1);
		}else{
			$("#addProductToCart").val(0);
		}
		$("#toggleCartForm").submit();
		return false;
	});
	
	$("#shoppingcart").dialog({
		autoOpen: false,
		height:450,
		width:800,
		modal:true,
		show: {
		effect: "blind",
		duration: 1000
		},
		hide: {
		effect: "explode",
		duration: 1000
		},
		 buttons: {
			 "Place Order": function(){
				 
			 },
			 Cancel: function() {
				 $("#shoppingcart").dialog( "close" );
			 }
			 }
			 
		});
	
	$("#myShoppingCartBtn").click(function(event){
		$("#myCartAjaxLoad").show();
		 $( "#shoppingcart" ).dialog( "open" );
		 fetchMyCartContent();
	});
});

function fetchMyCartContent(){
	var tableHeadSection='<table class="table table-hover">'+
      '<thead><tr><th>#</th><th>Product</th><th>Detail</th><th>Quantity</th><th>Price</th><th>Delete</th></tr></thead><tbody>';
	var tableTailSection=' </tbody></table>';
	var rowStart='<tr>';
	var rowEnd='</tr>';
	var colStart='<td>';
	var colEnd='</td>';
	$("#myCartContent").empty();
	$.ajaxSetup({ cache: false });
	$.getJSON( "myCart", function( data ) {
		var tableSection=tableHeadSection;
		var i=1;
		$.each(data,function(counter,productObj){
			var row=rowStart;
			row=prepareColumn(row, i, colStart, colEnd);
			var productImage='<img alt="135%x194" class="" data-src="holder.js/135%x194" style="height: 194px; width: 160px; display: block;" src="getResource?imageId='+productObj.productImageUrl+'">';
			row=prepareColumn(row, productImage, colStart, colEnd);
			var productName='<h4>'+productObj.productName+'</h4>';
			row=prepareColumn(row, productName, colStart, colEnd);
			var selectQuantity=getQuantityColumn(productObj.quantityAvailableSelectList);
			row=prepareColumn(row, selectQuantity, colStart, colEnd);
			var price='Rs. '+productObj.productPrice;
			row=prepareColumn(row, price, colStart, colEnd);
			var deleteIcon='<a id="deleteFromMyCartButton" class="btn btn-primary btn-lg" id="toggleCart" title="Delete From My Cart" role="button">'+
				'<img src="../img/deleteicon.png" height="40" width="40"/></a>';
			row=prepareColumn(row, deleteIcon, colStart, colEnd);
			row=row+rowEnd;
			tableSection=tableSection+row;
			i++;
		});
			
		tableSection=tableSection+tableTailSection;
		$("#myCartAjaxLoad").hide();
		$("#myCartContent").append(tableSection);
		$("#myCartContent").show();
});
}

function prepareColumn(row,content,colStart,colEnd){
	row=row+colStart;
	row=row+content;
	row=row+colEnd;
	return row;
}

function getQuantityColumn(quantityList){
	var quantity='<select class="form-control">';
	for(i=0;i<quantityList.length;i++){
		quantity=quantity+' <option value="'+quantityList[i]+'">'+quantityList[i]+'</option>';
	}
	quantity=quantity+'</select>';
	return quantity;
}