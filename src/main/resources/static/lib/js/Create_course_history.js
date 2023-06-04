addEventListener("DOMContentLoaded", () => {
    $("#holdrecord-tab").click(function (e) {
        const actId = sessionStorage.getItem("accountId");
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
                                                <small>${courseKey.courseStatus}</small>
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

});
