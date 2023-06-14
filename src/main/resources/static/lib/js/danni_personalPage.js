addEventListener("DOMContentLoaded", () => {

    const actId = localStorage.getItem("accountId");
    let urlParams = new URLSearchParams(window.location.search);
    let accountId = urlParams.get('accountId');
    // let accountId = localStorage.getItem("accountId");
    // const reason = $("#attendReason").val();

    $("#courseHistory").click(function (e) {
        const url = "../course/creator/" + accountId;
        const historyContainer = document.querySelector("#course-history-list");
        console.log(historyContainer);

// 使用 Fetch 函式發送 GET 請求
        fetch(url)
            .then(function (response) {
                // 處理回應

                return response.json();
            })
            .then(function (courseList) {
                // 處理回傳的資料
                console.log(courseList);
                historyContainer.innerHTML = "";
                if (courseList[0].successful == false) {
                    console.log("aaa");
                    historyContainer.innerHTML += `
                           <div class="row h-100">
                                                <div class="col-8 h-100">
                                                    <h5>您未舉辦任何課程</h5>
                                                </div>
                                                </div>
                        `;
                    return;
                }
                for (let courseKey of courseList) {
                    console.log("courseKey.eventName");
                    console.log(courseKey.eventName);
                    // <img class="card-img-top event_pic lazy"
                    //      src="/ixercise/lib/img/course/${filteredData[i].photo}" alt="紙上得來終覺淺，絕知此事要躬行" />`;
                    historyContainer.innerHTML += `
                                                  <!-- 一條紀錄====================== -->
                                    <div href="#" class="list-group-item list-group-item-action creatCourseList" aria-current="true" data-courseid4creator="${courseKey.courseId}"
                                        style="height: 118px;">
                                        <div class="row h-100">
                                            <div class="col-2 h-100">
                                                <img src="/ixercise/lib/img/course/${courseKey.photo}" alt="" width="100px"
                                                    height="100px" class="overflow-hidden" style="object-fit:cover;">
                                            </div>
                                            <div class="col-8">
                                                <div class="d-flex w-100 justify-content-between">
                                                    <h5 class="mb-1">${courseKey.eventName}</h5>
                                                </div>
                                                <p class="mb-1">${courseKey.courseStartDate}</p>
                                                <small>${courseKey.statusString}</small>
                                            </div>
                                            <div class="col-2 ">
                                                <a class="btn btn-primary mb-1 go2CourseIntro" href="#" role="button">查看課程</a>
<!--                                                <a class="btn btn-primary" href="#" role="button">付費廣告　</a>-->
                                            </div>
                                        </div>
                                    </div>
                `;

                }
            })
            .catch(function (error) {
                // 處理錯誤
                console.log('發生錯誤：', error);
            });


    });


    const course_calendar_list = document.querySelector('#course-calendar-list');
    const urls = getContextPath() + "/courseAttendee/calander/" + actId;
    // http://localhost:8080/ixercise/courseAttendee/calander/5
    const calendar = document.querySelector("#calendar-tab");
    calendar.addEventListener('click', () => {
        console.log("calendar has been clicked");


        $(document).on('click', '#calendarbtnC', function (e) {

            console.log("calendarbtnC>>" + this);
            console.log(urls);
            fetch(urls)
                .then(resp => resp.json())
                .then(evtList => {
                    course_calendar_list.innerHTML = "";
                    if (evtList[0].successful == false) {
                        console.log("aaa");
                        course_calendar_list.innerHTML += `
                           <div class="row h-100">
                                                <div class="col-8 h-100">
                                                    <h5>${evtList[0].message}</h5>
                                                </div>
                                                </div>
                        `;
                        return;
                    }
                    for (let course of evtList) {
                        console.log(course);
                        let statusButtons = '';

                        switch (course.status) {
                            case 1:
                                statusButtons = `<button class="ms-5 btn justify-content-end small btn-danger mb-1 cancelParticipation" href="#" role="button" >退出</button>`;
                                break;
                            case 2:
                                statusButtons = `<button class="btn btn-primary hopIntoChatRoom payMoney4Course" href="#" role="button" onclick="payMoney4Course()">已通過:    前往付款💵</button>`;
                                break;
                            case 3:
                                statusButtons = `<button class="btn btn-danger attendDenied" href="#" role="button" disabled>未通過　</button>`;
                                break;
                            case 4:
                                statusButtons = `<button class="btn btn-danger exitPending" href="#" role="button" disabled>退出待審核　</button>`;
                                break;
                            case 5:
                                statusButtons = `<button class="btn btn-danger exitSuccessful" href="#" role="button" disabled>退出成功　</button>`;
                                break;
                            default:
                                // Default buttons when course status doesn't match any case
                                statusButtons = `<button class="btn btn-primary" href="#" role="button">此課程不存在</button>`;
                                break;
                        }

                        course_calendar_list.innerHTML += `
                                            <!-- 一條紀錄====================== -->
                                        <div href="#" class="list-group-item list-group-item-action courseList" data-attendid="${course.attendId}" data-courseid="${course.courseID}" aria-current="true"
                                             style="height: 118px;">
                                            <div class="row h-100">
                                                <div class="col-2 h-100">
                                                    <img src="/ixercise/lib/img/course/${course.photo}" alt="" width="100px"
                                                         class="overflow-hidden" height="100px" style="object-fit:cover;">
                                                </div>
                                                <div class="col-8 courseInfoContainer">
                                                    <div class="d-flex w-100 justify-content-between courseNameContainer">
                                                        <h5 class="mb-1">${course.eventName}</h5>
                                                    </div>
                                                    <p class="mb-1">${course.courseStartDate}</p>
                                                    <small>${course.attendeesStatus}</small>
                                                </div>
                                                <div class="col-2 status-btn">
<!--                                                    <a class="ms-5 btn justify-content-end small btn-danger mb-1" href="#" role="button">退出</a>-->
<!--                                                    <a class="btn btn-primary" href="#" role="button">前往聊天室　</a>-->
                                                         ${statusButtons}
                                                </div>
                                            </div>
                                        </div>
                                   `;
                    }
                });

        });

        $(document).on('click', '#calendarbtnE', function (e) {
            console.log("canlnadarbtnE>>" + this);
            fetch(urls)
                .then(resp => resp.json())
                .then(evtList => {
                    course_calendar_list.innerHTML = "";
                    for (let eve of evtList) {
                        let statusButtons = '';
//
                        switch (eve.attendeeStatus) {
                            case 1:
                                statusButtons = `<button class="ms-5 btn justify-content-end small btn-danger mb-1 cancelParticipation" href="#" role="button" >退出</button>`;
                                break;
                            case 2:
                                statusButtons = `<button class="btn btn-primary hopIntoChatRoom" href="#" role="button">已通過　</button>`;
                                break;
                            case 3:
                                statusButtons = `<button class="btn btn-danger attendDenied" href="#" role="button" disabled>未通過　</button>`;
                                break;
                            case 4:
                                statusButtons = `<button class="btn btn-danger exitPending" href="#" role="button" disabled>退出待審核　</button>`;
                                break;
                            case 5:
                                statusButtons = `<button class="btn btn-danger exitSuccessful" href="#" role="button" disabled>退出成功　</button>`;
                                break;
                            default:
                                // Default buttons when course status doesn't match any case
                                statusButtons = `<button class="btn btn-primary" href="#" role="button">此課程不存在</button>`;
                                break;
                        }
//
                        course_calendar_list.innerHTML += `
                                        <!-- 一條紀錄====================== -->
                                         <div href="#" class="list-group-item list-group-item-action courseList" data-attendid="${eve.attendId}" aria-current="true"
                                              style="height: 118px;">
                                             <div class="row h-100">
                                                 <div class="col-2 h-100">
                                                     <img src="https://picsum.photos/500/200/?random=10" alt="" width="100px"
                                                          class="overflow-hidden" height="100px" style="object-fit:cover;">
                                                 </div>
                                                 <div class="col-8 courseInfoContainer">
                                                     <div class="d-flex w-100 justify-content-between courseNameContainer">
                                                         <h5 class="mb-1">${eve.eventName}</h5>
                                                     </div>
                                                     <p class="mb-1">${eve.courseStartDate}</p>
                                                        <small>${eve.attendeeStatus}</small>
                                                 </div>
                                                 <div class="col-2 status-btn">
 <!--                                                    <a class="ms-5 btn justify-content-end small btn-danger mb-1" href="#" role="button">退出</a>-->
 <!--                                                    <a class="btn btn-primary" href="#" role="button">前往聊天室　</a>-->
                                                          ${statusButtons}
                                                 </div>
                                             </div>
                                         </div>
                                    `;
                    }
                });
        });

    });


    function getContextPath() {
        return window.location.pathname.substring(0, window.location.pathname.indexOf('/', 2));
    }

    $("#course-calendar-list").on('click', '.cancelParticipation', function (e) {
        let cancelCheck = confirm("確認已提出取消報名此課程");
        if (cancelCheck) {
            console.log(cancelCheck);
            let attendId = $(this).closest(".courseList").attr("data-attendid");
            console.log(attendId);
            // let update
            // fetch()
            let urls = `../courseAttendee/updateStatusById/${attendId}/4`;
            fetch(urls, {
                method: 'PUT'
            })
                .then(response => response.json())
                .then(data => {
                    console.log('現在是updateStatusById~');
                    console.log(data);
                    if (!data.successful) {
                        alert('退出申請失敗');
                    } else {
                        location.reload();
                        // $("#calendar").click();
                        alert("已提出退出申請");
                    }
                })
                .catch(error => {
                    console.error('Error:', error);
                });

        }

    });


    $("#course-calendar-list").on('click', '.payMoney4Course', function (e) {
        let cancelCheck = confirm("是否前往課程付款: 按下通過將前往付款");
        if (cancelCheck) {
            let attendId = $(this).closest(".courseList").attr("data-courseid");
            // let url = `/ixercise/jimmy/course_intro_page.html?courseId=${attendId}&thismemberName=${thismemberName}&creator_hide' + creator_hide}`;
            let url = `/ixercise/jimmy/course_intro_page.html?courseId=${attendId}`;
            location = url;
        }
        // if (cancelCheck) {
        //     console.log(cancelCheck);
        //     let attendId = $(this).closest(".courseList").attr("data-attendid");
        //     console.log(attendId);
        //     // let update
        //     // fetch()
        //     let urls = `../courseAttendee/updateStatusById?attendId=${attendId}&status=4`;
        //     fetch(urls, {
        //         method: 'PUT'
        //     })
        //         .then(response => response.json())
        //         .then(data => {
        //             console.log('現在是updateStatusById~');
        //             console.log(data);
        //             if (!data.successful) {
        //                 alert('退出申請失敗');
        //             } else {
        //                 location.reload();
        //                 // $("#calendar").click();
        //                 alert("已提出退出申請");
        //             }
        //         })
        //         .catch(error => {
        //             console.error('Error:', error);
        //         });
        //
        // }

    });

    $("#course-history-list").on('click', '.go2CourseIntro', function (e) {
        let cancelCheck = confirm("是否前此課程");

        if (cancelCheck) {
            let attendId = $(this).closest(".creatCourseList").attr("data-courseid4creator");
            // let url = `/ixercise/jimmy/course_intro_page.html?courseId=${attendId}&thismemberName=${thismemberName}&creator_hide' + creator_hide}`;
            let url = `/ixercise/jimmy/course_intro_page.html?courseId=${attendId}`;
            location = url;
        }
    });
});  //loaded

// function payMoney4Course(){
//     let attendId = $(this).closest(".courseList").attr("data-attendid");
//     let url = `/ixercise/jimmy/course_intro_page.html?courseId=${courseId_hide}&thismemberName=${thismemberName}&creator_hide' + creator_hide}`;
//
// }
