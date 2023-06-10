const nav = document.querySelector(".navbar");

nav.innerHTML = '<div class=" container-fluid px-4 px-lg-0 me-4 ">\n' +
    '\n' +
    '            <!-- 商標===================================================================== -->\n' +
    '            <a class="navbar-brand m-0 px-4" href="http://localhost:8080/ixercise/index.html">\n' +
    '                <img src="/ixercise/lib/img/IX-nobackground.png" alt="" width="91" height="60">\n' +
    '            </a>\n' +
    '            <!-- Bootstrap 5 的 Navbar Toggler 按鈕，用於在手機和平板等較小螢幕上，點擊按鈕時切換導覽列的展開和收縮狀態。 -->\n' +
    '            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"\n' +
    '                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"\n' +
    '                aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>\n' +
    '\n' +
    '            <!-- 商標的右邊整條============================================================ -->\n' +
    '            <div class="collapse navbar-collapse " id="navbarSupportedContent">\n' +
    '\n' +
    '                <ul class="navbar-nav mb-2 mb-lg-0 w-100">\n' +
    '                    <!-- 搜尋欄=============================================================== -->\n' +
    '                    <!-- <li class="nav-item my-auto">\n' +
    '                        <form class="d-flex">\n' +
    '                            <input class="form-control" type="search" placeholder="找活動..." aria-label="Search">\n' +
    '                            <button class="btn border border-2 border-dark" type="submit">Search</button>\n' +
    '                        </form>\n' +
    '                    </li> -->\n' +
    '\n' +
    '                    <li class="nav-item my-auto">\n' +
    '                        <form class="d-flex row">\n' +
    '                            <div class="row" style="width: 400px; max-width: 400px;">\n' +
    '                                <div class="col-8 pe-0">\n' +
    '                                    <input class="form-control" id="searchbar" type="search" placeholder="搜尋..."\n' +
    '                                        aria-label="Search" role="button">\n' +
    '                                    </input>\n' +
    '                                </div>\n' +
    '                                <div class="col-4 ps-0">\n' +
    '                                    <button id="searchbtn" class="btn border border-1 border-dark" type="submit">Search</button>\n' +
    '                                </div>\n' +
    '                            </div>\n' +
    '\n' +
    '                            <!-- </form> -->\n' +
    '                            <!-- ================================================================== -->\n' +
    '                            <!-- <div class="collapse" id="collapseExample"> -->\n' +
    '                            <div id="searchcard" class="d-none">\n' +
    '                                <div class="searchbarthing w-50 position-fixed">\n' +
    '                                    <!-- <form action="" class="row mb-0"> -->\n' +
    '                                    <div class="row mb-0">\n' +
    '                                        <div class="col-3">\n' +
    '                                            <!-- <label for=""></label> -->\n' +
    '                                            <select class="form-select form-select-sm col-3 mb-3"\n' +
    '                                                aria-label="Default select example">\n' +
    '                                                <option selected>頁面 </option>\n' +
    '                                                <option value="1">商城</option>\n' +
    '                                                <option value="2">論壇</option>\n' +
    '                                                <option value="3">活動</option>\n' +
    '                                            </select>\n' +
    '                                        </div>\n' +
    '<div class="col-3">\n' +
    '<select id="select_sport" class="form-select form-select-sm"\n' +
    'aria-label="Default select example">\n' +
    '<option selected disabled>運動類型</option>\n' +
    '<option value="1">足球</option>\n' +
    '<option value="2">籃球</option>\n' +
    '<option value="3">網球</option>\n' +
    '<option value="4">排球</option>\n' +
    '<option value="5">橄欖球</option>\n' +
    '<option value="6">棒球</option>\n' +
    '<option value="7">曲棍球</option>\n' +
    '<option value="8">高爾夫球</option>\n' +
    '<option value="9">羽毛球</option>\n' +
    '<option value="10">乒乓球</option>\n' +
    '<option value="11">壁球</option>\n' +
    '<option value="12">手球</option>\n' +
    '<option value="13">保齡球</option>\n' +
    '<option value="14">有氧操課</option>\n' +
    '<option value="15">瑜伽課</option>\n' +
    '<option value="16">舞蹈課</option>\n' +
    '<option value="17">腹肌課</option>\n' +
    '<option value="18">動感單車課</option>\n' +
    '<option value="19">跳繩課</option>\n' +
    '<option value="20">重訓課</option>\n' +
    '<option value="21">拳擊課</option>\n' +
    '<option value="22">跳舞操課</option>\n' +
    '<option value="23">瑜伽拉伸課</option>\n' +
    '<option value="24">其他</option>\n' +

    '</select>\n' +
    '</div>\n' +
    ' <div class="col-3">\n' +
    '<select id="select_city" class="form-select form-select-sm" aria-label="Default select example">\n' +
    '<option selected disabled>搜尋城市</option>\n' +
    `<option value="臺北市">臺北市</option>
    <option value="基隆市">基隆市</option>
    <option value="連江縣">連江縣</option>
    <option value="新北市">新北市</option>
    <option value="宜蘭縣">宜蘭縣</option>
    <option value="新竹市">新竹市</option>
    <option value="新竹縣">新竹縣</option>
    <option value="桃園市">桃園市</option>
    <option value="苗栗縣">苗栗縣</option>
    <option value="臺中市">臺中市</option>
    <option value="彰化縣">彰化縣</option>
    <option value="南投縣">南投縣</option>
    <option value="嘉義市">嘉義市</option>
    <option value="嘉義縣">嘉義縣</option>
    <option value="雲林縣">雲林縣</option>
    <option value="臺南市">臺南市</option>
    <option value="高雄市">高雄市</option>
    <option value="澎湖縣">澎湖縣</option>
    <option value="金門縣">金門縣</option>
    <option value="屏東縣">屏東縣</option>
    <option value="台東縣">台東縣</option>
    <option value="花蓮縣">花蓮縣</option>` +
    '</select>\n' +
    '</div>\n' +
    '<div class="col-3">\n' +
    '<select id="select_time" class="form-select form-select-sm" aria-label="Default select example">\n' +
    '<option selected disabled>上課時段</option>\n' +
    '<option value="1">上午(06:00~12:00)</option>\n' +
    '<option value="2">下午(12:00~18:00)</option>\n' +
    '<option value="3">晚上(18:00~24:00)</option>\n' +
    '</select>\n' +
    '</div>\n' +
    '                                        <div class="row">\n' +
    '                                            <!-- <div class="col-9"></div> -->\n' +
    '                                            <div class="col-12 ">\n' +
    '                                                <!-- <button class="btn btn-primary" type="submit"> 查詢\n' +
    '                                            </button> -->\n' +
    '                                                <button class="btn btn-primary" type="button"\n' +
    '                                                    id="btn-close-search">關閉</button>\n' +
    '                                                <button class="btn btn-primary" type="reset"\n' +
    '                                                    id="btn-reset-search">重置</button>\n' +

    '<button class="btn btn-danger" id="btn_selecter_search"\n' +
    'type="submit">搜尋篩選</button>\n' +

    '                                            </div>\n' +
    '                                        </div>\n' +
    '                                    </div>\n' +
    '                                </div>\n' +
    '                            </div>\n' +
    '                    </li>\n' +
    '\n' +
    '                    <!-- <div class="collapse  d-block" id="collapseExample">\n' +
    '                    </div> -->\n' +
    '\n' +
    '\n' +
    '                    <!-- 辦活動============================================================= -->\n' +
    '                    <li id="addcourse" class="nav-item fs-5 ms-auto my-auto d-none">\n' +
    '                        <a class="nav-link active h-100 " aria-current="page" href="/ixercise/jimmy/Course_CreateEventForm.html">開課程\n' +
    '                        </a>\n' +
    '                    </li>\n' +
    '                    <li class="nav-item fs-5 ms-auto my-auto">\n' +
    '                        <a class="nav-link active h-100 " aria-current="page" href="/ixercise/jimmy/Course_CreateEventForm.html">開課程\n' +
    '                        </a>\n' +
    '                    </li>\n' +
    '                    <!-- 其他主頁  ========================================================== -->\n' +
    '                    <li class="nav-item fs-5 dropdown my-auto">\n' +
    '                        <a class="nav-link dropdown-toggle navalable" id="navbarDropdown" href="#" role="button"\n' +
    '                            data-bs-toggle="dropdown" aria-expanded="false">其他主頁\n' +
    '                        </a>\n' +
    '                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">\n' +
    '                            <li><a class="dropdown-item" href="">首頁</a></li>\n' +
    '                            <li>\n' +
    '                                <hr class="dropdown-divider" />\n' +
    '                            </li>\n' +
    '                            <li><a id="shoplink" class="dropdown-item" href="">商城</a></li>\n' +
    // '                            <li><a class="dropdown-item" href="">論壇</a></li>\n' +
    // '                            <li><a class="dropdown-item" href="">活動</a></li>\n' +
    '                            <li><a class="dropdown-item" href="/ixercise/jimmy/Course_homePage.html">課程</a></li>\n' +
    '                        </ul>\n' +
    '                    </li>\n' +
    '                    <!-- 鈴鐺============================================================= -->\n' +
    '                    <!-- 還有一顆填滿的bi-bell-fill -->\n' +
    '                    <!-- 操控.n-dot來控制有無紅點 -->\n' +
    '                    <li class="nav-item dropdown my-auto">\n' +
    '                        <div class=""  id="adddot"></div>\n' +
    '                        <svg id="bellul" width="36" height="36" fill="currentColor"\n' +
    '                            class="bi bi-bell dropdown-toggle dropdown-toggle" id="navbarDropdown" role="button"\n' +
    '                            data-bs-toggle="dropdown" viewBox="0 0 16 16">\n' +
    '                            <path\n' +
    '                                d="M8 16a2 2 0 0 0 2-2H6a2 2 0 0 0 2 2zM8 1.918l-.797.161A4.002 4.002 0 0 0 4 6c0 .628-.134 2.197-.459 3.742-.16.767-.376 1.566-.663 2.258h10.244c-.287-.692-.502-1.49-.663-2.258C12.134 8.197 12 6.628 12 6a4.002 4.002 0 0 0-3.203-3.92L8 1.917zM14.22 12c.223.447.481.801.78 1H1c.299-.199.557-.553.78-1C2.68 10.2 3 6.88 3 6c0-2.42 1.72-4.44 4.005-4.901a1 1 0 1 1 1.99 0A5.002 5.002 0 0 1 13 6c0 .88.32 4.2 1.22 6z" />\n' +
    '                        </svg>\n' +
    '                        <ul class="dropdown-menu dropdown-menu-lg-end"  id="listart" aria-labelledby="navbarDropdown">\n' +
    '                            <!-- 一條通知====================================================== -->\n' +
    '                            <!-- 完成版 600px -->\n' +
    '                            <div class="list-group notifyunread">\n' +
    '                                <a href="#" class="list-group-item list-group-item-action" aria-current="true"\n' +
    '                                    style="height: 93px; width:600px;">\n' +
    '                                    <div class="row h-100">\n' +
    '                                        <div class="col-2 h-100">\n' +
    '                                            <img src="https://picsum.photos/150/200/?random=10" width="72px"\n' +
    '                                                height="72px" alt="" style="object-fit:cover">\n' +
    '                                        </div>\n' +
    '                                        <div class="col-10">\n' +
    '                                            <div class="d-flex w-100 justify-content-between">\n' +
    '                                                <p class="mb-1" style=" overflow: hidden;">\n' +
    '                                                    一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十\n' +
    '                                                </p>\n' +
    '                                                <small style="white-space: nowrap;">3 days ago</small>\n' +
    '                                            </div>\n' +
    '                                        </div>\n' +
    '                                    </div>\n' +
    '                                </a>\n' +
    '                            </div>\n' +
    '                            <div class="list-group notifyunread">\n' +
    '                                <a href="#" class="list-group-item list-group-item-action" aria-current="true"\n' +
    '                                    style="height: 93px; width:600px;">\n' +
    '                                    <div class="row h-100">\n' +
    '                                        <div class="col-2 h-100">\n' +
    '                                            <img src="https://picsum.photos/150/200/?random=10" width="72px"\n' +
    '                                                height="72px" alt="" style="object-fit:cover">\n' +
    '                                        </div>\n' +
    '                                        <div class="col-10">\n' +
    '                                            <div class="d-flex w-100 justify-content-between">\n' +
    '                                                <p class="mb-1" style=" overflow: hidden;">\n' +
    '                                                    一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十\n' +
    '                                                </p>\n' +
    '                                                <small style="white-space: nowrap;">3 days ago</small>\n' +
    '                                            </div>\n' +
    '                                        </div>\n' +
    '                                    </div>\n' +
    '                                </a>\n' +
    '                            </div>\n' +
    '                        </ul>\n' +
    '                    </li>\n' +
    '\n' +
    '                    <!-- 會員頭像========================================================= -->\n' +
    '                    <li id="useravatar" class="nav-item dropdown mx-2 my-auto d-none">\n' +
    '                        <img id="avataroutside"\n' +
    '                            src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVBVtQ9oUbZtIaiZxiJTBVNkk2c4YbAu1cyZ-dYTsqgQ&s"\n' +
    '                            class="nav-link dropdown-toggle overflow-hidden rounded-circle p-0" href="#" role="button"\n' +
    '                            data-bs-toggle="dropdown" aria-expanded="false" width="36" height="36"\n' +
    '                            style="object-fit: cover;">\n' +
    '\n' +
    '                        <ul class="dropdown-menu dropdown-menu-lg-end" aria-labelledby="navbarDropdown">\n' +
    '\n' +
    '                            <li class="">\n' +
    '                                <img id="avatarinside" class="overflow-hidden mx-1 p-2 rounded-circle"\n' +
    '                                    src="https://picsum.photos/200/200/?random=10" width="150px" height="150px"\n' +
    '                                    style="object-fit: cover;">\n' +
    '                            </li>\n' +
    '                            <li>\n' +
    '                                <span id="nicknameinavatar"\n' +
    '                                    class="dropdown-item-text justify-content-center d-flex fs-5">名字</span>\n' +
    '                            </li>\n' +
    '                            <li>\n' +
    '                                <hr class="dropdown-divider" />\n' +
    '                            </li>\n' +
    '                            <li>\n' +
    '                                <a id="personalpage" class="dropdown-item" href="" >查看個人資料</a>\n' +
    '                            </li>\n' +
    '                            <li>\n' +
    '                                <a id="chatlist" class="dropdown-item" href="">聊天列表</a>\n' +
    '                            </li>\n' +
    // '                            <li>\n' +
    // '                                <a class="dropdown-item" href="">活動管理</a>\n' +
    // '                            </li>\n' +
    // '                            <li>\n' +
    '                                <a class="dropdown-item" href="/ixercise/jimmy/Course_backStage(sidebar).html">課程管理</a>\n' +
    '                            </li>\n' +
    '                            <li>\n' +
    '                                <a id="logout" class="dropdown-item" href="">登出</a>\n' +
    '                            </li>\n' +
    '                        </ul>\n' +
    '                    </li>\n' +
    '                    <!-- 登入 註冊=========================================================================== -->\n' +
    '\n' +
    '                    <li id="loginbtn" class="nav-item dropdown mx-2 my-auto">\n' +
    '                        <a id="loginb" href="" class="btn btn-primary btn-lg" tabindex="-1" role="button"\n' +
    '                            aria-disabled="true">登入</a>\n' +
    '                        <a id="signupb" href="" class="btn btn-primary btn-lg" tabindex="-1" role="button"\n' +
    '                            aria-disabled="true">註冊</a>\n' +
    '                    </li>\n' +
    '\n' +
    '\n' +
    '                </ul>\n' +
    '                <!-- 購物車的按鈕============================================================= -->\n' +
    '                <form class="d-flex">\n' +
    '                    <button class="btn btn-outline-dark d-flex text-nowrap" type="submit">\n' +
    '                        <!-- 這個車車改class為bi-cart的話 就會變成空車 -->\n' +
    '                        <i class="bi-cart-fill me-1"></i>\n' +
    '                        購物車\n' +
    '                        <span class="badge bg-dark text-white ms-1 rounded-pill my-auto">0</span>\n' +
    '                    </button>\n' +
    '                </form>\n' +
    '            </div>\n' +
    '        </div>';


// 按鈕事件=================================================================================
const searchbar = document.querySelector("#searchbar");
const btnCloseSearch = document.querySelector("#btn-close-search");
const searchcard = document.querySelector("#searchcard");
searchbar.addEventListener("click", function () {
    searchcard.classList.remove("d-none");
})
btnCloseSearch.addEventListener("click", function () {
    searchcard.classList.add("d-none");
})
// ==========================================================================================

const personalpage = document.querySelector("#personalpage")

const accid = localStorage.getItem("accountId");
const accnickname = localStorage.getItem("accountNickname");
const acclevel = localStorage.getItem("accountLevel");
const accphoto = localStorage.getItem("accountPhoto");
const avatarnickname = document.querySelector("#nicknameinavatar");
const logout = document.querySelector("#logout");
const loginbtn = document.querySelector("#loginbtn");
const avataroutside = document.querySelector("#avataroutside");
const avatarinside = document.querySelector("#avatarinside");
const useravatar = document.querySelector("#useravatar");
const nophoto = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVBVtQ9oUbZtIaiZxiJTBVNkk2c4YbAu1cyZ-dYTsqgQ&s"
const shoplink = document.querySelector("#shoplink");
const addcourse = document.querySelector("#addcourse");

if (accid) {
    loginbtn.classList.add("d-none");
    useravatar.classList.remove("d-none");
    avatarnickname.textContent = accnickname;
    // const accidforpg = "/" + accid;
    // console.log(accidforpg);
    personalpage.href = getContextPath() + "/Account/PersonalPage.html" + "?accountId=" + accid;
    // personalpage.href = `${getContextPath()}Account/PersonalPage.html${accidforpg}`

    // console.log(typeof accphoto);
    if (accphoto && accphoto.length > 0) {

        avataroutside.src = getcreateObjURL(accphoto);
        avatarinside.src = getcreateObjURL(accphoto);
        // const imageBinaryStr = atob(accphoto);
        // let len = imageBinaryStr.length;
        // const uint8Array = new Uint8Array(len);
        // while (len--) {
        //     uint8Array[len] = imageBinaryStr.charCodeAt(len);
        // }
        // const blob = new Blob([uint8Array]);
        // avataroutside.src = URL.createObjectURL(blob);
        // avatarinside.src = URL.createObjectURL(blob);
        // avataroutside.src = "123";
        // avatarinside.src = "123";
    } else {
        // const nophoto = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVBVtQ9oUbZtIaiZxiJTBVNkk2c4YbAu1cyZ-dYTsqgQ&s"
        avataroutside.src = nophoto;
        avatarinside.src = nophoto;


    }

    // if(accountPhoto !== null){
    //     console.log(accountPhoto);
    //     console.log("進IF")
    // const imageBinaryStr = atob(accountPhoto);
    // let len = imageBinaryStr.length;
    // const uint8Array = new Uint8Array(len);
    // while (len--) {
    //     uint8Array[len] = imageBinaryStr.charCodeAt(len);
    // }
    // const blob = new Blob([uint8Array]);
    // avataroutside.src = URL.createObjectURL(blob);
    // avatarinside.src = URL.createObjectURL(blob);
    // } else{
    //     const nophoto = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVBVtQ9oUbZtIaiZxiJTBVNkk2c4YbAu1cyZ-dYTsqgQ&s"
    //     avataroutside.src = nophoto;
    //     avatarinside.src = nophoto;
    // }
} else {
    loginbtn.classList.remove("d-none");
    useravatar.classList.add("d-none");
}

logout.addEventListener("click", function () {
    sessionStorage.removeItem("accountId");
    sessionStorage.removeItem("accountLevel");
    sessionStorage.removeItem("accountNickname");
    sessionStorage.removeItem("accountPhoto");

    localStorage.removeItem("accountId");
    localStorage.removeItem("accountLevel");
    localStorage.removeItem("accountNickname");
    localStorage.removeItem("accountPhoto");

    fetch("Account/Logout");
    location = getContextPath() + "/index.html";
})


// ================================================================
// 設定連結
const ixicon = document.querySelector(".navbar-brand");
const loginb = document.querySelector("#loginb");
const signupb = document.querySelector("#signupb");
const chatlist = document.querySelector("#chatlist");
chatlist.href = getContextPath() + "/hao/customerservice.html";
shoplink.href = getContextPath() + "/shop.jsp";


ixicon.href = getContextPath() + "/index.html";
// personalpage.href = getContextPath() + "/Account/PersonalPage.html" + "?accountId=" + accid;
logout.href = getContextPath() + "/index.html";
loginb.href = getContextPath() + "/Account/Login.html";
signupb.href = getContextPath() + "/Account/SignUp.html";

function getcreateObjURL(base64photo) {
    if (base64photo == null || base64photo == "null") {
        return nophoto;
    }
    const imageBinaryStr = atob(base64photo);
    let len = imageBinaryStr.length;
    const uint8Array = new Uint8Array(len);
    while (len--) {
        uint8Array[len] = imageBinaryStr.charCodeAt(len);
    }
    const blob = new Blob([uint8Array]);
    return URL.createObjectURL(blob);
}

function getContextPath() {
    return window.location.pathname.substring(0, window.location.pathname.indexOf('/', 2));
}

fetch('checkfornav/' + accid)
    .then(resp => resp.json())
    .then(body => {
        const {successful, message} = body;
        if (successful) {
            addcourse.classList.remove("d-none");
            console.log(message);
        }

    })

// });