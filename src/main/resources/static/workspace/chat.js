/*
 * Copyright (c) 2017 wupj e-mail:wpjlovehome@gmail.com
 */

/**
 * Created by WPJ587 on 2017/1/9.
 */
var stompClient = null;

function connect() {
    if(stompClient==null){
        var socket = new SockJS('/chat');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe('/groups/chatting', function (greeting) {
                console.log("服务器",greeting);
                showGreeting(greeting);
            });
            var userId=$("#user_id").val();
            stompClient.subscribe('/single/' + userId + '/chat', function(message){
                console.log("单独聊",message);
                showGreeting(message);
            });
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
    debugger
    stompClient.send("/chat", {}, JSON.stringify({'content': $("#user_message").val(),userId:$("toId").val()}));
}
function showGreeting(message) {
    var message= JSON.parse(message.body)
    var userName=message.userName;
    var content=JSON.parse(message.content).content;
    console.log(message);
    var msg="<div class='alert alert-dismissible alert-default'>"+
     "<strong>"+userName+":</strong>"+content+" </div>"
    $("#chat_content").append(msg);
}
function initTab() {
    $('#friend_list a').click(function (e) {
        e.preventDefault();
        $(this).tab('show')
    });  $('#test a').click(function (e) {
        e.preventDefault();
        $(this).tab('show')
    });
}
/**
 * 点击好友
 */
function chatWith(element) {
    console.log(element);
    var id=element.getAttribute("data-id");
    console.log(id);
    $("#toId").val(id);
}

$(function () {
    $.material.init();
    connect();
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send_msg" ).click(function() {
        // sendMsg();
        sendSingleMsg();
    });
    $(".list-group-item").click(function () {
        chatWith($(this).context);
    });
    initTab();
});