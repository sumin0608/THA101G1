
var timestamp = new Date(new Date().getTime() + (480 * 60000)).toISOString();
var localStorageId = localStorage.getItem('accountId');
$(function () {
    connect();

    function connect() {
        // create a websocket
        webSocket = new WebSocket("ws://localhost:8080/ixercise/checkbell/" + localStorageId);

        webSocket.onopen = function (event) {
            console.log("Connect Success!");

        };




        webSocket.onmessage = function (e) {
            var jsonObj = JSON.parse(e.data);
            console.log(e);
            console.log("我事前!");
            if ("new" == jsonObj.type) {
                console.log("我事後!");
                let html = "";


                html = `<div class="list-group notifyunread"><a href="#" class="list-group-item list-group-item-action" aria-current="true"
                        style="height: 93px; width:600px;"><div class="row h-100">
                        <div class="col-12 h-100">
                        <div class="d-flex w-100 justify-content-between">
                            <h1 class="text-muted">目前無任何提示......</h1>
                            </div></div></div></a></div>`;
                $("#listart").html(html);
                console.log("我new有被執行到");
            }

            else if ("history" === jsonObj.type) {


                var messages = JSON.parse(jsonObj.message);
                console.log(messages);
                var html = "";
                for (var i = messages.length - 1; i >= 0; i--) {
                    var historyData = JSON.parse(messages[i]);
                    // 获取当前时间
                    var currentTime = new Date();

                    // 将从数据库获取的时间转换为日期对象
                    var dbTime = new Date(historyData. messagetime);

                    // 计算时间差（以毫秒为单位）
                    var timeDiff = currentTime - dbTime

                    // 转换时间差为不同单位
                    var minutesDiff = Math.floor(timeDiff / (1000 * 60));
                    var hoursDiff = Math.floor(timeDiff / (1000 * 60 * 60));
                    var daysDiff = Math.floor(timeDiff / (1000 * 60 * 60 * 24));

                    // 根据时间差的单位显示不同的文本
                    var timeAgo;
                    if (minutesDiff < 60) {
                        timeAgo = minutesDiff + " 分钟前";
                    } else if (hoursDiff < 24) {
                        timeAgo = hoursDiff + " 小时前";
                    } else {
                        timeAgo = daysDiff + " 天前";
                    }

                    // 输出时间差
                    console.log(timeAgo);





                    html += '<div class="list-group notifyunread">' +
                        '<a href="#" class="list-group-item list-group-item-action" aria-current="true" style="height: 93px; width:600px;">' +
                        '<div class="row h-100">' +
                        '<div class="col-2 h-100"><img src="./lib/img/' + historyData.photo + '" width="72px" height="72px" alt="" style="object-fit:cover"></div>' +
                        '<div class="col-8">' +
                        '<h5>' + historyData.message + '</h5>' +
                        '</div>' +
                        '<div class="col-2">' + timeAgo +
                        '</div>' +

                        '</div>' +
                        '</a>' +
                        '</div>';
                }

                $("#listart").html(html);



            } else if ("podcast" === jsonObj.type) {
                console.log(jsonObj.photo);


                $("#adddot").addClass('n-dot');


            }

        };




        webSocket.onclose = function (event) {
            console.log("Disconnected!");
        };
    }



    function updateFriendName(name) {
        statusOutput.innerHTML = name;
    }


    // 獲取代碼中的 SVG 元素

    $('#bellul').on('click', function () {

        console.log("點擊鈴鐺有成功");
        $("#adddot").removeClass('n-dot');

        var jsonObj = {
            "type": "history",
            "acountId": localStorageId,
            "message": "",
            "photo": null,
            "messagetime": null,
        };

        webSocket.send(JSON.stringify(jsonObj))


        // var dropdownMenu = $('#bellul');
        // dropdownMenu.toggleClass('show');
    });







});
