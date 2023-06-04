$(document).ready(function () {

    // 頁籤<<評價紀錄的課程>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    $(".coursebtn_evaluate").click(function () {
        console.log(this);
        $.ajax({
            url: "/ixercise/coursecomment/" + 1, //假設1號會員"/{accountIdReviewed}，之後抓session會員id
            type: "GET",
            contexttype: "application/json",
            // data: JSON.stringify({}),
            success: function (resp) {
                // console.log("resp>>" + resp[0].commentContent);
                let tableData = '';
                const successful = resp[0].successful;
                console.log("success?>>" + successful);
                if (successful === true) {
                    for (let i = 0; i < resp.length; i++) {
                        let createdAt = new Date(resp[i].createdAt);
                        let eventName;
                        let courseStartDate;
                        let formattedDate = createdAt.toISOString().split('T')[0]; //只拿日期，切掉時間
                        tableData += `<div href="#" class="list-group-item list-group-item-action re_commentplace"
                                aria-current="true" style="height: 118px;">`
                        tableData += `<div class="row h-100">`
                        tableData += `<div class="col-2 h-100 overflow-hidden">`
                        tableData += `<img src="https://picsum.photos/500/200/?random=10" alt="" width="100px"
                                            height="100px" class="rounded-circle" style="object-fit:cover;">`
                        tableData += `</div>`
                        tableData += `<div class="col-8">`
                        tableData += `<div class="d-flex w-100 justify-content-between">`
                        //串接課程資料，用課程id(courseId)去找對應的中文名字
                        $.ajax({
                            url: "/ixercise/course/courseId/" + resp[i].courseId,
                            type: "GET",
                            dataType: "json",
                            data: { id: resp[i].courseId }, //
                            async: false, // 设置为同步请求，确保获取到eventName后再进行下一步 
                            success: function (c) {
                                eventName = c.eventName;
                                courseStartDate = c.courseStartDate;
                            },
                            error: function (xhr, status, error) {
                                alert("Error: " + xhr.responseText);
                            }
                        });
                        tableData += `<h5 class="mb-1 re_course">${eventName}</h5>`
                        tableData += `<p class="mb-1">日期:${courseStartDate}</p>`;
                        tableData += `<small class="re_reviewerId">參加者Id:${resp[i].accountIdReviewer}</small>`
                        tableData += `<small class="re_createdAt">留言日期:${formattedDate}</small>`
                        tableData += `</div>`

                        tableData += `<div class='fixstar_block'>`
                        for (let j = 0; j < resp[i].commentRating; j++) {
                            tableData += `<span class='fixstar -on' data-star='1'><i
                                                    class='fas fa-star'></i></span>`
                        }
                        for (let k = 0; k < 5 - resp[i].commentRating; k++) {
                            tableData += `<span class='fixstar' data-star='1'><i
                                                    class='fas fa-star'></i></span>`
                        }
                        tableData += `</div>`

                        tableData += `<div class="col-10" style="overflow:auto;">${resp[i].commentContent}</div>`
                        tableData += `</div>`
                        //評論的照片區塊，暫時不開放
                        // tableData += `<div class="col-2">
                        //              <img src="../lib/img/comment/${resp[i].photo}" alt="" width="100px"
                        //                 height="100px" style="object-fit:contain; max-width: 100px; max-height: 100px;">
                        //              </div>`
                        tableData += `</div></div>`
                    }
                    $(".evaluatelist").empty().append(tableData);
                }
            },
            error: function (xhr, status, error) {
                alert("Error: " + xhr.responseText);
            }
        });
    });

    // 頁籤<<參加紀錄的課程>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    $(document).on("click", '#coursebtn_attendrecord', function () {
        // console.log(this);
        $.ajax({
            url: "/ixercise/courseAttendee/accountId/" + 2, //假設2號會員{accountId}，之後抓session會員id
            type: "GET",
            contexttype: "application/json",
            // data: JSON.stringify({}),
            success: function (resp1) {
                console.log("resp1.reason:>>" + resp1[0].reason);
                const resp1successful2 = resp1[0].successful;
                console.log("resp1successful2:" + resp1successful2);
                let tableData2 = '';
                if (resp1successful2 === true) {
                    for (let i = 0; i < resp1.length; i++) {
                        if (resp1[i].commentStatus == 0) {      //0是尚未評價
                            console.log("進入迴圈");
                            tableData2 += `<div id="listpapa" >`;

                            tableData2 += `<div href="#" class="list-group-item list-group-item-action" aria-current="true" style="height: 118px;">`;
                            tableData2 += `<div class="row h-100">`;
                            tableData2 += `<div class="show_givecomment" style="display:none;">評價狀態:<p>${resp1[i].commentStatus}</p></div>`;

                            $.ajax({
                                url: "/ixercise/course/courseId/" + resp1[i].courseId, //2號會員參加的{courseId}
                                type: "GET",
                                contexttype: "application/json",
                                async: false, //非同步的（asynchronous），表示該請求是同步的
                                success: function (resp) {
                                    console.log("resp.eventName2>>" + resp.eventName);
                                    console.log("successful2>>" + resp.successful);
                                    if (resp.successful === true) {
                                        tableData2 += `<div class="col-2 h-100">
                                                        <img src="/ixercise/lib/img/course/${resp.photo}" alt="紙上得來終覺淺，絕知此事要躬行" width="100px"
                                                        height="100px" class="overflow-hidden" style="object-fit:cover;">
                                                        </div>`;
                                        tableData2 += `<div class="col-8">`;
                                        tableData2 += ` <div class="d-flex w-100 justify-content-between"><h5 class="mb-1 ">${resp.eventName}</h5></div>`;
                                        tableData2 += ` <p class="mb-1">活動日期: ${resp.courseStartDate}</p>`;
                                        tableData2 += ` <small>狀態: </small><small class="attendstatus">已完成</small>`;
                                        //隱藏區courseId
                                        tableData2 += `<div class="courseId displaynone">courseId:${resp.courseId}</div>`;
                                        tableData2 += `</div>`;
                                        tableData2 += `<div class="col-2"><a class="btn btn-primary givecomment" href="#" role="button">前往評價</a></div>`;
                                        tableData2 += `</div>`;
                                        tableData2 += `</div>`;
                                        // <!-- 評論欄位 -->
                                        tableData2 += `<div class="card col-12 commentplace displaynone">
                                                        <div class="card-body p-4">
                                                            <div class="d-flex flex-start w-100">`;
                                        //撈會員session照片
                                        tableData2 += `<img class="rounded-circle shadow-1-strong me-3"
                                                            src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(21).webp"
                                                            alt="帥哥" width="65" height="65" />`;
                                        tableData2 += `         <div class="w-100">
                                                                    <h5>留言評論</h5>
                                                                    <!-- 評分星星 -->
                                                                    <div class='star_block'>
                                                                        <span class='star' data-star='1'><i class='fas fa-star'></i></span>
                                                                        <span class='star' data-star='2'><i class='fas fa-star'></i></span>
                                                                        <span class='star' data-star='3'><i class='fas fa-star'></i></span>
                                                                        <span class='star' data-star='4'><i class='fas fa-star'></i></span>
                                                                        <span class='star' data-star='5'><i class='fas fa-star'></i></span>
                                                                    </div>
                                                                    <div class="form-outline">
                                                                        <textarea class="form-control textareac" id="textAreaExample"
                                                                            rows="4"></textarea>
                                                                        <label class="form-label"
                                                                            for="textAreaExample">若欲檢舉請勾選，並詳述您的體驗</label>
                                                                    </div>
                                                                    <!-- 下方按鈕 -->
                                                                    <div class="d-flex justify-content-between mt-3">
                                                                        <button type="button" class="btn btn-danger sendcomment">
                                                                            Send
                                                                            <i class="fas fa-long-arrow-alt-right ms-1"></i>
                                                                        </button>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>`;  //<!-- 評論欄位 -->
                                        tableData2 += `</div>`;
                                    }
                                },
                                error: function (xhr, status, error) {
                                    alert("Error: " + xhr.responseText);
                                }
                            });//內層$.ajax()結束
                        }
                    }
                }
                $(".attendrecordlist").empty().append(tableData2);
            },
            error: function (xhr, status, error) {
                alert("Error: " + xhr.responseText);
            }
        });

    });

    // 頁籤<<評價管理的課程>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    $("#coursebtn_evaluatemanager").click(function () {
        // console.log(this);
        $.ajax({
            url: "/ixercise/coursecomment/attendrecord/" + 1, //假設1號會員{accountIdReviewer}，之後抓session會員id
            type: "GET",
            contexttype: "application/json",
            // data: JSON.stringify({}),
            success: function (resp) {
                console.log("resp>>" + resp[0].commentContent);
                const successful3 = resp[0].successful;
                console.log("success2>>" + successful3);
                if (successful3 === true) {
                    let tableData3 = '';
                    for (let i = 0; i < resp.length; i++) {
                        var createdAt3 = new Date(resp[i].createdAt);
                        let formattedDate3 = createdAt3.toISOString().split('T')[0]; //只拿日期，切掉時間
                        let eventName3;
                        let courseStartDate3;
                        tableData3 += `<div href="#" class="list-group-item list-group-item-action re_commentplace"
                        aria-current="true" style="height: 118px;">`
                        tableData3 += `<div class="row h-100">`
                        tableData3 += `<div class="col-2 h-100 overflow-hidden">`
                        tableData3 += `<img src="https://picsum.photos/500/200/?random=10" alt="" width="100px"
                                    height="100px" class="rounded-circle" style="object-fit:cover;">`
                        tableData3 += `</div>`
                        tableData3 += `<div class="col-8">`
                        tableData3 += `<div class="d-flex w-100 justify-content-between">`
                        //串接課程資料，用課程id(courseId)去找對應的中文名字
                        $.ajax({
                            url: "/ixercise/course/courseId/" + resp[i].courseId, //抓session會員
                            type: "GET",
                            dataType: "json",
                            // data: { id: resp[i].courseId },
                            async: false, // 设置同步请求，确保eventName后再进行下一步 
                            success: function (c) {
                                console.log("c: " + c);
                                console.log("c.eventNamec: " + c.eventName);
                                eventName3 = c.eventName;
                                courseStartDate3 = c.courseStartDate;
                            },
                            error: function (xhr, status, error) {
                                alert("Error: " + xhr.responseText);
                            }
                        });
                        tableData3 += `<h5 class="mb-1 re_course">${eventName3}</h5>`
                        tableData3 += `<p class="mb-1">日期:${courseStartDate3}</p>`;
                        tableData3 += `<small class="re_reviewedId">教練id:${resp[i].accountIdReviewed}</small>`
                        tableData3 += `<small class="re_createdAt">留言日期:${formattedDate3}</small>`
                        tableData3 += `</div>`

                        tableData3 += `<div class='fixstar_block'>`
                        for (let j = 0; j < resp[i].commentRating; j++) {
                            tableData3 += `<span class='fixstar -on' data-star='1'><i
                                            class='fas fa-star'></i></span>`
                        }
                        for (let k = 0; k < 5 - resp[i].commentRating; k++) {
                            tableData3 += `<span class='fixstar' data-star='1'><i
                                            class='fas fa-star'></i></span>`
                        }
                        tableData3 += `</div>`

                        tableData3 += `<div class="col-10" style="overflow:auto;">${resp[i].commentContent}</div>`
                        tableData3 += `</div>`
                        tableData3 += `<div class="col-2"><a class="btn btn-primary editcomment" href="#" role="button">前往修改評價</a></div>`;
                        tableData3 += `</div></div>`
                    }
                    $(".evaluatemanagerlist").empty().append(tableData3);
                }
            },
            error: function (xhr, status, error) {
                alert("Error: " + xhr.responseText);
            }
        });
    });



    // 檢舉勾勾
    $('.report').click(function () {
        var isChecked = $('.flexCheckDefault').prop('checked');
        $('.flexCheckDefault').prop('checked', !isChecked);
    });
    // 評分星星
    $(document).on('click', '.star_block .star', function () {
        $(this).siblings().removeClass('-on');
        $(this).addClass('-on');
        $(this).prevAll().addClass('-on');
    });
    // Delete selected image
    // $(".delete-btn").click(function () {
    //     $(".photo-dropzone").val("");
    // });

    // 前往評價 按鈕打開(最近的)隱藏評論區
    $(document).on('click', '.givecomment', function (e) {
        var commentPlace = $(this).closest('#listpapa').find('.commentplace');
        commentPlace.toggleClass('displaynone');
        // $('.commentplace').toggleClass('displaynone');
    });

    //送出評論
    $(document).on('click', '.sendcomment', function (e) {
        e.preventDefault();
        // resp1[i].commentStatus == 0;
        // 沒寫評論先擋
        let commentContent = $(".textareac").val();
        let commentRating = $('.star.-on:last').data('star');
        console.log("commentContent: " + commentContent);
        console.log("commentRating: " + commentRating);

        if (commentContent == "") {
            console.log("沒寫評論");
            swal("請寫評論!!!", "say something", "warning");
        } else if (commentRating == null) {
            console.log("沒給星星");
            swal("請給星星，最低一顆!!!", "say something", "warning");
        }
        else {
            //     let formData = new FormData();
            //     formData.append('file', file);

            // 步驟二、存入資料庫
            let courseId = $(".courseId").text();
            let accountIdReviewed = $(".accountIdReviewed").text();
            let accountIdReviewer = $(".accountIdReviewer").text();
            console.log(accountIdReviewed);
            // console.log(commentContent);
            // console.log(commentRating);
            // console.log("photo=" + photo);
            $.ajax({
                url: "/ixercise/coursecomment",
                type: "POST",
                contentType: 'application/json',
                data: JSON.stringify({
                    courseId: courseId,
                    accountIdReviewed: accountIdReviewed,
                    accountIdReviewer: accountIdReviewer,
                    commentContent: commentContent,
                    commentRating: commentRating
                }),
                success: function (resp) {
                    console.log("resp>>" + resp);
                    swal("Warning!", resp.message, "warning");
                },
                error: function (xhr, status, error) {
                    alert("Error: " + xhr.responseText);
                }
            });
            // 步驟二、結束
        };
        var textarea = $('.textareac');// 清空textarea的值
        textarea.val('');
        $('.star').siblings().removeClass('-on');// 清空星星
        $('.flexCheckDefault').prop('checked', false);// 清空檢舉勾勾
        $('.commentplace').toggleClass('displaynone');//隱藏評論填寫表格
    });//送出評論-結束

    //修改評論--不開放
    $(document).on('click', '.editcomment', function (e) {
        e.preventDefault();
        console.log(".editcomment: " + this);
        alert("來不及了，送出就不要後悔，哈哈");
    });

    // 頁籤<<舉辦活動的課程>>>>>不寫在這>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    // $(".coursebtn_holdrecord").click(function () {
    //  console.log(this);
    // });
});
