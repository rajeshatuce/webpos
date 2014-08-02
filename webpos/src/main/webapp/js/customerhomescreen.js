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
});