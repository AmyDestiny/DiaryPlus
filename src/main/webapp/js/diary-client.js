var app = angular.module('diaryApp', []);
app.controller('contextCtrl', function($scope, $http) {
    $http.get("/diary/openapi/list.do")
    .success(function(response) {
    	$scope.records = response.records;
    	console.log("response.msg:"+response.msg);
    	//alert("res:"+response);
    	// console.log("res:"+response.records.list[].date);
    	// var list = response.records.list;
    	// for (var i =list.length - 1; i >= 0; i--) {
    	// 	console.log(list[i].date);
    	// }
    }).error(function(){
    	console.log("angular get url error");
    });
    $scope.$on('ngRepeatFinished', function (ngRepeatFinishedEvent) {
        //下面是在render完成后执行的js
    	console.log("ngRepeatFinished...then do initClickEvent()");
    	setTimeout('initClickEvent()',100);
    });
  
});
app.directive('onFinishRenderFilters', function ($timeout) {
    return {
        restrict: 'A',
        link: function(scope, element, attr) {
            if (scope.$last === true) {
                $timeout(function() {
                    scope.$emit('ngRepeatFinished');
                });
            }
        }
    };
});
app.filter("trustHtml",function($sce){
	return function(input){
		 return $sce.trustAsHtml(input);
	};
});
function initClickEvent(){

	//修复图片太高的问题
	var maxHeight = 400;
	$(".main .showBig").each(function(e,target){
		var $target = $(target);
		var h = $target.height();
		var w = $target.width();
		
		if(h > maxHeight){
			w = w / h * maxHeight;
			$target.height(maxHeight);
			$target.width(w);
		}
		
	});	
	
	$(".main .year .list").each(function (e, target) {
		var $target=  $(target);
		var $ul = $target.find("ul");
		$target.height($ul.outerHeight());
		$ul.css("position", "absolute");
		
	}); 

	$(".main .year").each(function (e,target){
		 $(target).addClass("close");
	});
	$(".main .year").first().removeClass("close");
	
	$(".main .year>h2>a").click(function (e) {
		e.preventDefault();
		$(this).parents(".year").toggleClass("close");
	});
	$.getScript("js/bigger-image.js");
	console.log("init success");
}