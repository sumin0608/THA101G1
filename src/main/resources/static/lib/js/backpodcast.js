
var timestamp = new Date(new Date().getTime() + (480 * 60000)).toISOString();

$(function () {
    connect();

    function connect() {
        // create a websocket
        webSocket = new WebSocket("ws://localhost:8080/ixercise/checkbell/1114");

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

                var html = "";

                var messages = JSON.parse(jsonObj.message);
                console.log(messages);
                for (var i = messages.length; i > 0; i--) {



                    var html = "";
                    html = `  <div class="list-group notifyunread"><a href="#" class="list-group-item list-group-item-action" aria-current="true"
                        style="height: 93px; width:600px;"><div class="row h-100">
                            <div class="col-2 h-100"><img src="../lib/img/`+ messages[i].photo + ` " width="72px" height="72px" alt="" style="object-fit:cover">
                            </div>
                            <div class="col-10">
                              <h3 >`+ messages[i].message + `</h3></div></div></a></div> `;
                    $("#listart").prepend(html);





                };



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

    $("#bellul").on("click", function () {
        console.log("點擊鈴鐺有成功");
        var jsonObj = {
            "type": "history",
            "acountId": 1114,
            "message": "",
            "photo": null,
            "messagetime": null,
        };

        webSocket.send(JSON.stringify(jsonObj))

    })




});
