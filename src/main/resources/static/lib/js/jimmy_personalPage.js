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
                        let formattedDate = createdAt.toISOString().split('T')[0]; //只拿日期，切掉時間
                        let eventName;
                        let courseStartDate;
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
                            url: "/ixercise/course/corseId/" + resp[i].courseId,
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

    // 頁籤<<參加紀錄的課程>>>>>>>>>>>>>>>>>>>>>要改!!course_attendees>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    $(document).on("click", '#coursebtn_attendrecord', function () {
        console.log(this);
        $.ajax({
            url: "/ixercise/coursecomment/attendrecord/" + 1, //假設1號會員{accountIdReviewer}，之後抓session會員id
            type: "GET",
            contexttype: "application/json",
            // data: JSON.stringify({}),
            success: function (resp) {
                console.log("resp>>" + resp[0].commentContent);
                const successful2 = resp[0].successful;
                console.log("success2>>" + successful2);
                if (successful2 === true) {
                    let tableData2 = '';
                    for (let i = 0; i < resp.length; i++) {
                        tableData2 += `<div href="#" class="list-group-item list-group-item-action" aria-current="true" style="height: 118px;">`;
                        tableData2 += `<div class="row h-100">`;
                        tableData2 += `<div class="col-2 h-100">
                                <img src="https://picsum.photos/300/200/?random=10" alt="" width="100px"
                                    height="100px" class="overflow-hidden" style="object-fit:cover;">
                                </div>`;
                        tableData2 += `<div class="col-8">`;

                        tableData2 += ` <div class="d-flex w-100 justify-content-between"><h5 class="mb-1 ">${resp[i].courseId}</h5></div>`;
                        tableData2 += ` <p class="mb-1">活動時間</p>`;
                        tableData2 += ` <small>報名狀態: </small><small class="attendstatus">已完成</small>`;
                        tableData2 += `<div class="show_givecomment"><p>未評價</p></div>`;

                        tableData2 += `<div class="courseId displaynone">courseId:${resp[i].courseId}</div>
                                <div class="accountIdReviewed displaynone">accountIdReviewed:${resp[i].accountIdReviewed}</div>
                                <div class="accountIdReviewer displaynone">accountIdReviewer:${resp[i].accountIdReviewer}</div>`;

                        tableData2 += `</div>`;
                        tableData2 += `<div class="col-2"><a class="btn btn-primary givecomment" href="#" role="button">前往評價</a></div>`;
                        tableData2 += `</div>;`
                        tableData2 += `</div>`;
                    }
                    $(".attendrecordlist").empty().append(tableData2);
                }
            },
            error: function (xhr, status, error) {
                alert("Error: " + xhr.responseText);
            }
        });

    });

    // 頁籤<<評價管理的課程>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    $("#coursebtn_evaluatemanager").click(function () {
        console.log(this);
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
                            url: "/ixercise/course/corseId/" + resp[i].courseId,
                            type: "GET",
                            dataType: "json",
                            data: { id: resp[i].courseId }, //
                            async: false, // 设置为同步请求，确保获取到eventName后再进行下一步 
                            success: function (c) {
                                eventName3 = c.eventName;
                                courseStartDate3 = c.courseStartDate;
                            },
                            error: function (xhr, status, error) {
                                alert("Error: " + xhr.responseText);
                            }
                        });
                        tableData3 += `<h5 class="mb-1 re_course">${eventName3}</h5>`
                        tableData3 += `<p class="mb-1">日期:${courseStartDate3}</p>`;
                        tableData3 += `<small class="re_reviewedId">教練Id:${resp[i].accountIdReviewed}</small>`
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

    // 用來判斷if/else顯現下方"前往評價"按鈕，如果評論過按鈕隱藏
    var show_givecomment = $('.show_givecomment p').text();
    console.log(show_givecomment);
    if (show_givecomment === "已評價") {
        $('.givecomment').addClass('displaynone');
    }
    // 前往評價 按鈕打開隱藏評論區
    // $('.givecomment').click(function () {
    //     $('.commentplace').toggleClass('displaynone');
    // });
    // 檢舉勾勾
    $('.report').click(function () {
        var isChecked = $('.flexCheckDefault').prop('checked');
        $('.flexCheckDefault').prop('checked', !isChecked);
    });
    // 評分星星
    $(".star_block").on('click', '.star', function () {
        $(this).siblings().removeClass('-on');
        $(this).addClass('-on');
        $(this).prevAll().addClass('-on');
    });
    // Delete selected image
    $(".delete-btn").click(function () {
        $(".photo-dropzone").val("");
    });

    //修改評論
    $(document).on('click', '.editcomment', function (e) {
        e.preventDefault();
        console.log(".editcomment: " + this);
    });

    //送出評論
    $(document).on('click', '.sendcomment', function (e) {
        e.preventDefault();
        // 步驟一、、先存圖片
        let fileInput = $(".photo-dropzone")[0];
        let file = fileInput.files[0];

        // 沒寫評論先擋
        let commentContent = $(".textareac").val();
        let commentRating = $('.star.-on:last').data('star');
        if (commentContent == "") {
            console.log("沒寫評論");
            swal("請寫評論!!!", "say something", "warning");
        } else if (commentRating == null) {
            console.log("沒給星星");
            swal("請給星星，最低一顆!!!", "say something", "warning");
        } else {
            let formData = new FormData();
            formData.append('file', file);
            $.ajax({
                url: "/ixercise/coursecomment/upload-photo",
                type: 'POST',
                data: formData,
                processData: false,
                contentType: false,
                success: function (response) {
                    // 步驟二、存入資料庫
                    let courseId = $(".courseId").text();
                    let accountIdReviewed = $(".accountIdReviewed").text();
                    let accountIdReviewer = $(".accountIdReviewer").text();
                    let photo;
                    if (file != null) {
                        var a = true
                    } else { var a = false };
                    console.log("a=" + a);
                    if (a === true) {
                        photo = file.name;
                    } else { photo = null }
                    // console.log(accountIdReviewed);
                    // console.log(commentContent);
                    // console.log(commentRating);
                    console.log("photo=" + photo);
                    $.ajax({
                        url: "/ixercise/coursecomment",
                        type: "POST",
                        contentType: 'application/json',
                        data: JSON.stringify({
                            courseId: courseId,
                            accountIdReviewed: accountIdReviewed,
                            accountIdReviewer: accountIdReviewer,
                            commentContent: commentContent,
                            commentRating: commentRating,
                            photo: photo
                        }),
                        success: function (resp) {
                            console.log("resp>>" + resp);
                            swal("Warning!", resp.message, "warning");
                        },
                        error: function (xhr, status, error) {
                            alert("Error: " + xhr.responseText);
                        }
                    });
                },// 步驟二、結束
                error: function (xhr, status, error) {
                    alert("Error: " + xhr.responseText);
                }
            });
        };
        var textarea = $('.textareac');// 清空textarea的值
        textarea.val('');
        $('.star').siblings().removeClass('-on');// 清空星星
        $('.flexCheckDefault').prop('checked', false);// 清空檢舉勾勾
        $('.commentplace').toggleClass('displaynone');//隱藏評論填寫表格
    });
    //送出評論-結束



    // 頁籤<<舉辦活動的課程>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    $(".coursebtn_holdrecord").click(function () {
        console.log(this);
    });

    // // 打開評價
    // $('#unflodcomment').click(function () {
    //     $('.commentplace').toggleClass('displaynone');
    // });
});