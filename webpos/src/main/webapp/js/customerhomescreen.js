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
	
	
});