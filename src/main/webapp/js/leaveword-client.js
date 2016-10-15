$(document).ready(function(){

    $("#submit").click(function(){
        var txt = $("#content").val();
        alert("提交了"+txt);
    });
    $(".main .comments .comment a").click(function(){
        var t = $(this).siblings(".name").text();
        var txt = $("#content").val();
        $("#content").val(txt + " @" + t+" ");
    });
});