$(function () {
    //login
    $("#login-form button").click(function () {
        login();
    });
    // 标签事件
    $("#myTab a").click(function (e) {
        e.preventDefault();
        $('#myTab li').removeClass('active');
        $(e.target).parent().addClass('active');
        var content=$(e.target).html();
        //发出后台请求
        if("Users" == content){
            getUserInfo();
        }else if(content == "Message"){

        }else {

        }
        $(this).tab('show');
    });
    
    // +User
    $("#addUser-btn").click(function () {
        $("#addUser").toggleClass("hidden");
    });
    $('#addUser button').click(function () {
        postNewUser();
    });

});

function postNewUser() {
    $.ajax({
            url:"user/add",
            type: "post",
            data:$('#addUser').serialize(),
            success:function (data) {
                $("#addUser").toggleClass("hidden");
                if(data.code == 110){
                    $("#user-table tbody").html("Unauthorized, please login correctly first!");
                    alert("failed : "+data.msg);
                    return;
                }
                alert("succeeded.");
                getUserInfo();
            },
            error:function (data) {
            alert("failed:"+data.msg);
        }
    });
}

function getUserInfo() {
    $.ajax({
        url: "user/users",
        type: "get",
        success: function (data) {
            if(data.code!=200){
                alert("Failed : "+data.msg)
                return;
            }
            insertUserInfo(data.data)
        },
        dataType: "json",
        error: function (data) {
            // do nothing
        }
    });
}

function insertUserInfo(data) {
    var items=data;
    if(items == null)return;
    var table=$("#user-table tbody");
    table.html("");
    for(var i=1;i<=items.length;i++){
        var item=items[i-1];
        table.append(
            "<tr>" + "<td>" + i + "</a></td>" + "<td>" + item.username
            + "</td>" + "<td>" + item.role + "</td>"
            + "<td>" + "<a><span class='glyphicon glyphicon-pencil'></span></a>" + "</td>" + "</tr>");
    }
}

function login() {
    $.ajax({
        url: "user/login",
        type: "post",
        data: $('#login-form').serialize(),
        success: function (data) {
            var status=data.code;
            if(status !== 200){
                $("#home").html("<h3>Login Failed!</h3><br>" +
                    "<a class='btn btn-primary' onclick='location.reload()'>re-login</a>")
            }else {
                $("#home").html("<h3>Successfully Logged in.<br>You can go on with next parts.</h3>");
            }
        },
        dataType: "json",
        error: function (data) {
            // do nothing
        }
    })
}