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
	$("#shoppingcart").on("change", ".myCartQuantityDropdown", function(event) {
		var quantity=$(event.target).val();
		var unitPrice=$(event.target).parent().parent().find("[name='originalPrice']").val();
		var totalPrice=quantity*unitPrice;
		$(event.target).parent().parent().find("[name='originalPrice']").parent().find("span").text("Rs. "+totalPrice.format(2,3));
		reCalculateAndSetTotalPriceOfMyCart();
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
		var productList=data.productList;
		$.each(productList,function(counter,productObj){
			var row=rowStart;
			row=prepareColumn(row, i, colStart, colEnd,productObj.inventoryId,'id');
			var productImage='<img alt="135%x194" class="" data-src="holder.js/135%x194" style="height: 194px; width: 160px; display: block;" src="getResource?imageId='+productObj.productImageUrl+'">';
			row=prepareColumn(row, productImage, colStart, colEnd);
			var productName='<h4>'+productObj.productName+'</h4>';
			row=prepareColumn(row, productName, colStart, colEnd);
			var selectQuantity=getQuantityColumn(productObj.quantityAvailableSelectList);
			row=prepareColumn(row, selectQuantity, colStart, colEnd);
			var price='Rs. '+productObj.productPrice;
			row=prepareColumn(row, price, colStart, colEnd,productObj.originalProductPrice,'originalPrice');
			var deleteIcon='<a id="deleteFromMyCartButton" class="btn btn-primary btn-lg" id="toggleCart" title="Delete From My Cart" role="button">'+
				'<img src="../img/deleteicon.png" height="40" width="40"/></a>';
			row=prepareColumn(row, deleteIcon, colStart, colEnd);
			row=row+rowEnd;
			tableSection=tableSection+row;
			i++;
		});
			
		tableSection=tableSection+tableTailSection;
		$('#shoppingcart').dialog('option', 'title', 'Total Cart Value: Rs. '+data.formattedTotalPrice);
		$("#myCartAjaxLoad").hide();
		$("#myCartContent").append(tableSection);
		$("#myCartContent").show();
});
}

function prepareColumn(row,content,colStart,colEnd,hiddenValue,name){
	row=row+colStart;
	
	if(hiddenValue!=null){
		row=row+'<span class="">'+content+'</span>';
		row=row+'<input type="hidden" name="'+name+'" value="'+hiddenValue+'"/>';
	}else{
		row=row+content;
	}
	row=row+colEnd;
	return row;
}

function getQuantityColumn(quantityList){
	var quantity='<select class="form-control myCartQuantityDropdown">';
	for(i=0;i<quantityList.length;i++){
		quantity=quantity+' <option value="'+quantityList[i]+'">'+quantityList[i]+'</option>';
	}
	quantity=quantity+'</select>';
	return quantity;
}

function reCalculateAndSetTotalPriceOfMyCart(){
	var productList=$("#myCartContent").find("tbody").find("tr");
	var totalPrice=0.0;
	$.each(productList,function(counter,product){
		var quantity=$(product).find("select").val();
		var unitPrice=$(product).find("[name='originalPrice']").val();
		var indiviadualPrice=quantity*unitPrice;
		totalPrice=totalPrice+indiviadualPrice;
	});
	$('#shoppingcart').dialog('option', 'title', 'Total Cart Value: Rs. '+totalPrice.format(2,3));
}

Number.prototype.format = function(n, x) {
    var re = '\\d(?=(\\d{' + (x || 3) + '})+' + (n > 0 ? '\\.' : '$') + ')';
    return this.toFixed(Math.max(0, ~~n)).replace(new RegExp(re, 'g'), '$&,');
};