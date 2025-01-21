<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>聊天</title>

    <script type="text/javascript">
        //判断当前浏览器是否支持WebSocket
        var webSocket = null;
        if ('WebSocket' in window) {
            webSocket = new WebSocket("ws://localhost:9001/socket/127.0.0.1");
        }
        else if ('MozWebSocket' in window) {
            webSocket = new MozWebSocket("ws://localhost:9001/socket/127.0.0.1");
        }
        else {
            alert('Not support webSocket');
        }

        //打开socket,握手
        webSocket.onopen = function (event) {
            alert("websocket已经连接");
        }
        //接收推送的消息
        webSocket.onmessage = function (event) {
            console.info(event);
            alert(event.data);
        }
        //错误时
        webSocket.onerror = function (event) {
            console.info("发生错误");
            alert("websocket发生错误" + event);
        }

        //关闭连接
        webSocket.onclose = function () {
            console.info("关闭连接");
        }

        //监听窗口关闭
        window.onbeforeunload = function (event) {
            webSocket.close();
        }
    </script>
</head>
<body>

</body>
</html>