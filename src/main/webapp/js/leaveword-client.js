$(document).ready(function(){
    get_comments(current_page);
    //监听提交
    $("#submit").click(function(){
        if(!check_allow_submit()){
            alert("你发表留言太快了，先喝杯茶吧！！");
            return ;
        }
        var txt = $("#content").val();
        txt = html_transfer(txt);
        $.ajax({
            url:"/leaveword/publish",
            type:"POST",
            dataType:"json",
            data:{
                nickname:$("#nickname").val(),
                content:txt,
            },
            success:function () {
                $.cookie("gentlehu_last_submit",new Date().getTime(),{expires:7});
                alert("发表成功，站长审核后将会显示到留言板。");
            },
            error:function () {
                alert("对不起，留言提交失败！！！请稍后再试。");
            }
            
        })
    });

});
//获取数据并且显示
function get_comments(pn) {
    current_page = current_page > 0 ? current_page : 1;
    current_page = current_page <= page_count ? current_page : page_count;

    $.ajax({
        url:"/leaveword/list",
        type:"GET",
        dataType:"json",
        data:{
            pn:pn
        },
        success:function (response) {
            if(response.code == 200){
                console.log("获取留言列表成功 & pn = "+pn);
                console.log("responset:::" + JSON.stringify(response));
                page_count = 1 +  Math.floor(response.data.count / page_size);
                comments_diaplay(response.data.list);
            }
        },
        error:function () {
            alert("获取信息异常！！！");
        }
    });
}
//将数据填充到页面
function comments_diaplay(comments){
    var html = "";
    for(var i=0;i<comments.length;i++){
        var e = comments[i];
        html += " <li class='comment'><img src='/images/head.jpg' class='header' />" +
            "<div class='name'>" + e.publisher + "</div><p class='floor badge'>" + e.id + "</p><a href='#content'>回复</a>" +
            "<div class='date'>" + e.createtime + "</div>" +
            "<div class='content'>" + e.content + "</div></li>";
    }
    $("#list").empty();
    $("#list").append(html);
    //设置页码
    $("#current-page").text(current_page);
    $("#page-count").text(page_count);
    //设置监听
    $(".main .comments .comment a").click(function(){
        var t = $(this).siblings(".name").text();
        var txt = $("#content").val();
        $("#content").val(txt + " @" + t+" ");
    });
}
//检查上次发表时间
function check_allow_submit() {
    var last_submit = $.cookie("gentlehu_last_submit");
    if(last_submit == null || (new Date().getTime() - parseInt(last_submit) > 1000 * 60 * 10)){
        //两次提交时间不得小于10分钟
        return true;
    }
    return false;
}
//转义HTML字符
function html_transfer(txt) {
    return txt.replace(/[<>&"]/g,function(c){return {'<':'&lt;','>':'&gt;','&':'&amp;','"':'&quot;'}[c];});
}
//转义回车符
function f(txt) {
    return txt.replace(/[\n]/g,function (c) { return {'\n':'<br>'}[c];})
}
