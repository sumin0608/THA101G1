
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
                    html += '<div class="list-group notifyunread">' +
                        '<a href="#" class="list-group-item list-group-item-action" aria-current="true" style="height: 93px; width:600px;">' +
                        '<div class="row h-100">' +
                        '<div class="col-2 h-100"><img src="./lib/img/' + historyData.photo + '" width="72px" height="72px" alt="" style="object-fit:cover"></div>' +
                        '<div class="col-10">' +
                        '<h3>' + historyData.message + '</h3>' +
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
