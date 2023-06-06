addEventListener("DOMContentLoaded", () => {

    console.log(getContextPath());

    const actId = sessionStorage.getItem("accountId");
    $("#holdrecord-tab").click(function (e) {
        const url = "../course/creator/" + actId;
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
                for (let courseKey of courseList) {
                    console.log(courseKey.eventName);

                    historyContainer.innerHTML += `
                                                  <!-- 一條紀錄====================== -->
                                    <div href="#" class="list-group-item list-group-item-action" aria-current="true"
                                        style="height: 118px;">
                                        <div class="row h-100">
                                            <div class="col-2 h-100">
                                                <img src="https://picsum.photos/500/200/?random=10" alt="" width="100px"
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
                                                <a class="btn btn-primary mb-1" href="#" role="button">審核參加者</a>
                                                <a class="btn btn-primary" href="#" role="button">付費廣告　</a>
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
        console.log(urls);
        fetch(urls)
            .then(resp => resp.json())
            .then(evtList => {
                course_calendar_list.innerHTML = "";
                for (let course of evtList) {
                    let statusButtons = '';

                    switch (course.courseStatus) {
                        case 1:
                            statusButtons = `<a class="ms-5 btn justify-content-end small btn-danger mb-1" href="#" role="button">退出</a>`;
                            break;
                        case 2:
                            statusButtons = `<a class="btn btn-primary" href="#" role="button">前往聊天室　</a>`;
                            break;
                        case 3:
                            statusButtons = `<a class="btn btn-danger" href="#" role="button" disabled>未通過　</a>`;
                            break;
                        default:
                            // Default buttons when course status doesn't match any case
                            statusButtons = `<a class="btn btn-primary" href="#" role="button">前往聊天室　</a>`;
                            break;
                    }

                    course_calendar_list.innerHTML += `
                                            <!-- 一條紀錄====================== -->
                                        <div href="#" class="list-group-item list-group-item-action" aria-current="true"
                                             style="height: 118px;">
                                            <div class="row h-100">
                                                <div class="col-2 h-100">
                                                    <img src="https://picsum.photos/500/200/?random=10" alt="" width="100px"
                                                         class="overflow-hidden" height="100px" style="object-fit:cover;">
                                                </div>
                                                <div class="col-8">
                                                    <div class="d-flex w-100 justify-content-between">
                                                        <h5 class="mb-1">${course.eventName}</h5>
                                                    </div>
                                                    <p class="mb-1">${course.courseStartDate}</p>
                                                    <small>${course.statusString}</small>
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


        function getContextPath() {
            return window.location.pathname.substring(0, window.location.pathname.indexOf('/', 2));
        }
    });
});