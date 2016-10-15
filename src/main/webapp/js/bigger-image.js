	$(".showBig").click(function(){
		$("#showImg").attr("src",$(this).attr("src"));
		$("#imgBox").show();
		$("#imgBox").fadeIn(500,function(){
			$("#showImg").slideDown();
		});
		
	});
	$("#imgBox").click(function(){
		$("#showImg").slideDown();
		$("#showImg").slideUp(500,function(){
			$("#imgBox").hide();
		});
	});