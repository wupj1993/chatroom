/*
 * Copyright (c) 2017 wupj e-mail:wpjlovehome@gmail.com
 */

/**
 * Created by WPJ587 on 2017/1/9.
 */
var stompClient = null;
var chatType = 0;
function connect() {
    if(stompClient==null){
        var socket = new SockJS('/chat');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe('/groups/chatting', function (greeting) {
                console.log("服务器",greeting);
                groupChatting(greeting);
            });
            var userId=$("#user_id").val();
            stompClient.subscribe('/single/' + userId + '/chat', function(message){
                console.log("单独聊",message);
                showSingle(message);
            });
            stompClient.subscribe('/single/'+userId+'/friend',function (message) {
               console.log("消息来了",message);
                showFriend(message);
            });
            friendList();
        });
    }

}
function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    console.log("Disconnected");
}
function sendMsg() {
    stompClient.send("/group", {}, JSON.stringify({'content': $("#user_message").val()}));
}
function sendSingleMsg() {
    stompClient.send("/chat", {}, JSON.stringify({'content': $("#user_message").val(),toUser:$("#toId").val()}));
    var msg="<div class='alert alert-dismissible alert-info text-right'>"+
        ""+$("#user_message").val()+" <strong>:我</strong></div>"
    $("#chat_content").append(msg);
}
function groupChatting(message) {
    var message= JSON.parse(message.body);
    var userName=message.userName;
    var content=JSON.parse(message.content).content;
    console.log(message);
    var msg = "<div class='alert alert-dismissible alert-success'>" +
     "<strong>"+userName+":</strong>"+content+" </div>"
    $("#chat_content").append(msg);
}
function showSingle(message) {
    var message= JSON.parse(message.body);
    var fromUser=$("#talk_with").val();
    var content=message.content;
    // 首先判断当前是否是发送消息来的用户聊天界面（有没有正在和他聊天）、
    //<span class="withripple label label-danger">+12</span> 目前先做发来消息冒泡
    console.log(message);
    var msg="<div class='alert alert-dismissible alert-primary'>"+
        "<strong>"+fromUser+":</strong>"+content+" </div>"
    $("#chat_content").append(msg);
}
function initTab() {
    $('#friend_list a').click(function (e) {
        e.preventDefault();
        $(this).tab('show')
    });
    $('#test a').click(function (e) {
        e.preventDefault();
        $(this).tab('show')
    });
    $(".group-chat").click(function (e) {
        chatType = 1;
    });
}
/**
 * 点击好友
 */
function chatWith(element) {
    var id=element.getAttribute("data-id");
    $("#toId").val(id);
    $("#talk_with").val($("div[data-id="+id+"] div[class=row-content]>h5")[0].innerHTML);
    $("#now_user").html($("div[data-id="+id+"] div[class=row-content]>h5")[0].innerHTML);
    $("#now_user_motto").html($("div[data-id="+id+"] div[class=row-content]>p")[0].innerHTML);
}
/**
 * 注销.
 */
function logout() {
    $("#logout").submit();
}
/**
 * 好友列表
 */
function friendList() {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    stompClient.send("/friend/list", {},{_csrf:token,_csrf_header:header});
}
/**
 * 展示好友
 */
function showFriend(friends) {
    var friends= JSON.parse(friends.body);
    var list="";
    $.each(friends,function (index,item) {
        list += " <div class='list-group-item single-chat' data-id=" + item.id + "><div class='row-picture'><img class='circle' src='/img/header.jpg' alt='icon'/>  </div>"
            +"<div class='row-content'> <h5 class=list-group-item-heading>"+item.userNick+"</h5>"
            +" <p class='list-group-item-text'>"+item.userMotto+"</p> </div></div>"
            +" <div class='list-group-separator'></div></div>";
    });
    $("#friends").append(list);
    $(".single-chat").click(function () {
        chatType = 0;
        chatWith($(this).context);
    });
}

$(function () {
    $.material.init();
    connect();
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send_msg" ).click(function() {
        if (chatType == 0) {
            sendSingleMsg();
        } else {
            sendMsg();
        }

    });

    initTab();
});