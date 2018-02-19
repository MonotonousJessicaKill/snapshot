
$(function () {

    // 模态框注册事件
    $('#myModal').modal('toggle');
    $("#search-btn").click(function () {
        $('#myModal').modal('toggle');
    });

    // 为分页按钮注册事件
    $("nav").on('click', 'a', function (event) {
        var page = 0;
        var prev = null;
        if(event.target.innerHTML == "&gt;&gt;+10"){
            page = eval($(".pagination a:eq(10)").html());
            prev = false;
        }else if(event.target.innerHTML == "-10&lt;&lt;"){
            page = eval($(".pagination a:eq(1)").html() -1);
            prev = true;
        }else page = eval(event.target.innerHTML -1);
        getAndPushJson($("#key").val(), page,prev);
    });

    // 为表格获取submit注册事件
    $("#sub-btn").click(function () {
        var key = $("#key").val();
        getAndPushJson(key, 0,false);
    });

    $("tbody").on('click', 'a', function (event) {
        var itemId = eval(event.target.innerHTML);
        var jsonObj=u.getStorage(itemId);
        console.log(JSON.stringify(jsonObj,null,4));
        $("#modal-body-each").html(JSON.stringify(jsonObj,null,4));
    })
});

// 表格数据ajax
function getAndPushJson(key, page, prev) {
    if(key == ""){
        key="all";
    }
    $.ajax({
        url: "/wade/search/" + key + "/" + page,
        type: "get",
        data: {},
        success: function (data) {
            var data = data.data;
            insertData(data,page,prev);
        },
        dataType: "json",
        error: function (data) {
            // do nothing
        }
    });
}

function insertData(data,page,prev) {
    $('#myModal').modal('hide');
    var content = data.content;
    $('tbody').html("");
    for (var i = 0; i < content.length; i++) {
        var item = content[i];
        u.setStorage(item.id, item);
        $("tbody").append(
            "<tr>" + "<td><a class='forID ' data-toggle=\"modal\" data-target=\"#myModal-1\"> " + item.id + "</a></td>" + "<td>" + item.title
            + "</td>" + "<td>" + new Date(item.startDate) + "</td>"
            + "<td>" + new Date(item.finishDate) + "</td>" + "</tr>");
    }
    // 插入分页

    if(page !== 0 && prev == true){
        $(".pagination").html("");
        $(".pagination").append("<li><a>" + '-10&lt;&lt;' + "</a></li>");
        for (var j = page-9; j <= page; j++) {

            $(".pagination").append("<li><a>" + j + "</a></li>");

        }
        $(".pagination").append("<li><a>" + "&gt;&gt;+10" + "</a></li>");
    }
    if(prev == false){

        $(".pagination").html("");
        $(".pagination").append("<li><a>" + '-10&lt;&lt;' + "</a></li>");
        for (var j = page+1; j <= page+10; j++) {

            $(".pagination").append("<li><a>" + j + "</a></li>");

        }
        $(".pagination").append("<li><a>" + "&gt;&gt;+10" + "</a></li>");
    }


    // 设置当前请求页为.active
    $(".pagination li").removeClass("active");
    $(".pagination li:eq(" + (page + 1) + ")").addClass("active");

    $("#tb-area").removeClass("hidden");


}


function onKeyDown(event) {
    var e = event || window.event || arguments.callee.caller.arguments[0];
    if (e && e.keyCode == 27) { // 按 Esc
        // do nothing
    }
    if (e && e.keyCode == 13) { // enter 键
        var key = $("#key").val();
        getAndPushJson(key, 0, false);
    }

}

//定义全局变量函数
var uzStorage = function () {
    var ls = window.localStorage;
    return ls;
};
//定义全局变量u
var u = {};
u.setStorage = function (key, value) {
    var v = value;
    if (typeof v == 'object') {
        v = JSON.stringify(v);
        v = 'obj-' + v;
    } else {
        v = 'str-' + v;
    }
    var ls = uzStorage();
    if (ls) {
        ls.setItem(key, v);
    }
};
//获取缓存
u.getStorage = function (key) {
    var ls = uzStorage();
    if (ls) {
        var v = ls.getItem(key);
        if (!v) {
            return;
        }
        if (v.indexOf('obj-') === 0) {
            v = v.slice(4);
            return JSON.parse(v);
        } else if (v.indexOf('str-') === 0) {
            return v.slice(4);
        }
    }
};