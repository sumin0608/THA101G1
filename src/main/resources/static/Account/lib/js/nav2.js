// const nva = document.querySelector("#navbar");
//
// nav.innerHTML = "<div class=\" container-fluid px-4 px-lg-0 me-4 \">\n" +
//     "\n" +
//     "            <!-- 商標===================================================================== -->\n" +
//     "            <a class=\"navbar-brand m-0 px-4\" href=\"#!\">\n" +
//     "                <img src=\"./lib/img/IX-nobackground.png\" alt=\"\" width=\"91\" height=\"60\">\n" +
//     "            </a>\n" +
//     "            <!-- Bootstrap 5 的 Navbar Toggler 按鈕，用於在手機和平板等較小螢幕上，點擊按鈕時切換導覽列的展開和收縮狀態。 -->\n" +
//     "            <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\"\n" +
//     "                data-bs-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\"\n" +
//     "                aria-label=\"Toggle navigation\"><span class=\"navbar-toggler-icon\"></span></button>\n" +
//     "\n" +
//     "            <!-- 商標的右邊整條============================================================ -->\n" +
//     "            <div class=\"collapse navbar-collapse \" id=\"navbarSupportedContent\">\n" +
//     "\n" +
//     "                <ul class=\"navbar-nav mb-2 mb-lg-0 w-100\">\n" +
//     "                    <!-- 搜尋欄=============================================================== -->\n" +
//     "                    <!-- <li class=\"nav-item my-auto\">\n" +
//     "                        <form class=\"d-flex\">\n" +
//     "                            <input class=\"form-control\" type=\"search\" placeholder=\"找活動...\" aria-label=\"Search\">\n" +
//     "                            <button class=\"btn border border-2 border-dark\" type=\"submit\">Search</button>\n" +
//     "                        </form>\n" +
//     "                    </li> -->\n" +
//     "\n" +
//     "                    <li class=\"nav-item my-auto\">\n" +
//     "                        <form class=\"d-flex row\">\n" +
//     "                            <div class=\"row\" style=\"width: 400px; max-width: 400px;\">\n" +
//     "                                <div class=\"col-8 pe-0\">\n" +
//     "                                    <input class=\"form-control\" id=\"searchbar\" type=\"search\" placeholder=\"搜尋...\"\n" +
//     "                                        aria-label=\"Search\" role=\"button\">\n" +
//     "                                    </input>\n" +
//     "                                </div>\n" +
//     "                                <div class=\"col-4 ps-0\">\n" +
//     "                                    <button class=\"btn border border-1 border-dark\" type=\"submit\">Search</button>\n" +
//     "                                </div>\n" +
//     "                            </div>\n" +
//     "\n" +
//     "                            <!-- </form> -->\n" +
//     "                            <!-- ================================================================== -->\n" +
//     "                            <!-- <div class=\"collapse\" id=\"collapseExample\"> -->\n" +
//     "                            <div id=\"searchcard\" class=\"d-none\">\n" +
//     "                                <div class=\"searchbarthing w-50 position-fixed\">\n" +
//     "                                    <!-- <form action=\"\" class=\"row mb-0\"> -->\n" +
//     "                                    <div class=\"row mb-0\">\n" +
//     "                                        <div class=\"col-3\">\n" +
//     "                                            <!-- <label for=\"\"></label> -->\n" +
//     "                                            <select class=\"form-select form-select-sm col-3 mb-3\"\n" +
//     "                                                aria-label=\"Default select example\">\n" +
//     "                                                <option selected>頁面 </option>\n" +
//     "                                                <option value=\"1\">商城</option>\n" +
//     "                                                <option value=\"2\">論壇</option>\n" +
//     "                                                <option value=\"3\">活動</option>\n" +
//     "                                            </select>\n" +
//     "                                        </div>\n" +
//     "                                        <div class=\"col-3\">\n" +
//     "                                            <select class=\"form-select form-select-sm\"\n" +
//     "                                                aria-label=\"Default select example\">\n" +
//     "                                                <option selected>運動類型 </option>\n" +
//     "                                                <option value=\"1\">One</option>\n" +
//     "                                                <option value=\"2\">Two</option>\n" +
//     "                                                <option value=\"3\">Three</option>\n" +
//     "                                            </select>\n" +
//     "                                        </div>\n" +
//     "                                        <div class=\"col-3\">\n" +
//     "                                            <select class=\"form-select form-select-sm\"\n" +
//     "                                                aria-label=\"Default select example\">\n" +
//     "                                                <option selected>各自設定 </option>\n" +
//     "                                                <option value=\"1\">One</option>\n" +
//     "                                                <option value=\"2\">Two</option>\n" +
//     "                                                <option value=\"3\">Three</option>\n" +
//     "                                            </select>\n" +
//     "                                        </div>\n" +
//     "                                        <div class=\"col-3\">\n" +
//     "                                            <select class=\"form-select form-select-sm\"\n" +
//     "                                                aria-label=\"Default select example\">\n" +
//     "                                                <option selected>各自設定 </option>\n" +
//     "                                                <option value=\"1\">One</option>\n" +
//     "                                                <option value=\"2\">Two</option>\n" +
//     "                                                <option value=\"3\">Three</option>\n" +
//     "                                            </select>\n" +
//     "                                        </div>\n" +
//     "                                        <div class=\"row\">\n" +
//     "                                            <!-- <div class=\"col-9\"></div> -->\n" +
//     "                                            <div class=\"col-12 \">\n" +
//     "                                                <!-- <button class=\"btn btn-primary\" type=\"submit\"> 查詢\n" +
//     "                                            </button> -->\n" +
//     "                                                <button class=\"btn btn-primary\" type=\"button\"\n" +
//     "                                                    id=\"btn-close-search\">關閉</button>\n" +
//     "                                                <button class=\"btn btn-primary\" type=\"reset\"\n" +
//     "                                                    id=\"btn-close-search\">重置</button>\n" +
//     "                                            </div>\n" +
//     "                                        </div>\n" +
//     "                                    </div>\n" +
//     "                                </div>\n" +
//     "                            </div>\n" +
//     "                    </li>\n" +
//     "\n" +
//     "                    <!-- <div class=\"collapse  d-block\" id=\"collapseExample\">\n" +
//     "                    </div> -->\n" +
//     "\n" +
//     "\n" +
//     "                    <!-- 辦活動============================================================= -->\n" +
//     "                    <li class=\"nav-item fs-5 ms-auto my-auto\">\n" +
//     "                        <a class=\"nav-link active h-100 \" aria-current=\"page\" href=\"#!\">辦活動\n" +
//     "                        </a>\n" +
//     "                    </li>\n" +
//     "                    <!-- 其他主頁  ========================================================== -->\n" +
//     "                    <li class=\"nav-item fs-5 dropdown my-auto\">\n" +
//     "                        <a class=\"nav-link dropdown-toggle navalable\" id=\"navbarDropdown\" href=\"#\" role=\"button\"\n" +
//     "                            data-bs-toggle=\"dropdown\" aria-expanded=\"false\">其他主頁\n" +
//     "                        </a>\n" +
//     "                        <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n" +
//     "                            <li><a class=\"dropdown-item\" href=\"#!\">首頁</a></li>\n" +
//     "                            <li>\n" +
//     "                                <hr class=\"dropdown-divider\" />\n" +
//     "                            </li>\n" +
//     "                            <li><a class=\"dropdown-item\" href=\"#!\">商城</a></li>\n" +
//     "                            <li><a class=\"dropdown-item\" href=\"#!\">論壇</a></li>\n" +
//     "                            <li><a class=\"dropdown-item\" href=\"#!\">活動</a></li>\n" +
//     "                            <li><a class=\"dropdown-item\" href=\"#!\">課程</a></li>\n" +
//     "                        </ul>\n" +
//     "                    </li>\n" +
//     "                    <!-- 鈴鐺============================================================= -->\n" +
//     "                    <!-- 還有一顆填滿的bi-bell-fill -->\n" +
//     "                    <!-- 操控.n-dot來控制有無紅點 -->\n" +
//     "                    <li class=\"nav-item dropdown my-auto\">\n" +
//     "                        <div class=\"n-dot\"></div>\n" +
//     "                        <svg width=\"36\" height=\"36\" fill=\"currentColor\"\n" +
//     "                            class=\"bi bi-bell dropdown-toggle dropdown-toggle\" id=\"navbarDropdown\" role=\"button\"\n" +
//     "                            data-bs-toggle=\"dropdown\" viewBox=\"0 0 16 16\">\n" +
//     "                            <path\n" +
//     "                                d=\"M8 16a2 2 0 0 0 2-2H6a2 2 0 0 0 2 2zM8 1.918l-.797.161A4.002 4.002 0 0 0 4 6c0 .628-.134 2.197-.459 3.742-.16.767-.376 1.566-.663 2.258h10.244c-.287-.692-.502-1.49-.663-2.258C12.134 8.197 12 6.628 12 6a4.002 4.002 0 0 0-3.203-3.92L8 1.917zM14.22 12c.223.447.481.801.78 1H1c.299-.199.557-.553.78-1C2.68 10.2 3 6.88 3 6c0-2.42 1.72-4.44 4.005-4.901a1 1 0 1 1 1.99 0A5.002 5.002 0 0 1 13 6c0 .88.32 4.2 1.22 6z\" />\n" +
//     "                        </svg>\n" +
//     "                        <ul class=\"dropdown-menu dropdown-menu-lg-end\" aria-labelledby=\"navbarDropdown\">\n" +
//     "                            <!-- 一條通知====================================================== -->\n" +
//     "                            <!-- 完成版 600px -->\n" +
//     "                            <div class=\"list-group notifyunread\">\n" +
//     "                                <a href=\"#\" class=\"list-group-item list-group-item-action\" aria-current=\"true\"\n" +
//     "                                    style=\"height: 93px; width:600px;\">\n" +
//     "                                    <div class=\"row h-100\">\n" +
//     "                                        <div class=\"col-2 h-100\">\n" +
//     "                                            <img src=\"https://picsum.photos/150/200/?random=10\" width=\"72px\"\n" +
//     "                                                height=\"72px\" alt=\"\" style=\"object-fit:cover\">\n" +
//     "                                        </div>\n" +
//     "                                        <div class=\"col-10\">\n" +
//     "                                            <div class=\"d-flex w-100 justify-content-between\">\n" +
//     "                                                <p class=\"mb-1\" style=\" overflow: hidden;\">\n" +
//     "                                                    一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十\n" +
//     "                                                </p>\n" +
//     "                                                <small style=\"white-space: nowrap;\">3 days ago</small>\n" +
//     "                                            </div>\n" +
//     "                                        </div>\n" +
//     "                                    </div>\n" +
//     "                                </a>\n" +
//     "                            </div>\n" +
//     "                            <div class=\"list-group notifyunread\">\n" +
//     "                                <a href=\"#\" class=\"list-group-item list-group-item-action\" aria-current=\"true\"\n" +
//     "                                    style=\"height: 93px; width:600px;\">\n" +
//     "                                    <div class=\"row h-100\">\n" +
//     "                                        <div class=\"col-2 h-100\">\n" +
//     "                                            <img src=\"https://picsum.photos/150/200/?random=10\" width=\"72px\"\n" +
//     "                                                height=\"72px\" alt=\"\" style=\"object-fit:cover\">\n" +
//     "                                        </div>\n" +
//     "                                        <div class=\"col-10\">\n" +
//     "                                            <div class=\"d-flex w-100 justify-content-between\">\n" +
//     "                                                <p class=\"mb-1\" style=\" overflow: hidden;\">\n" +
//     "                                                    一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十\n" +
//     "                                                </p>\n" +
//     "                                                <small style=\"white-space: nowrap;\">3 days ago</small>\n" +
//     "                                            </div>\n" +
//     "                                        </div>\n" +
//     "                                    </div>\n" +
//     "                                </a>\n" +
//     "                            </div>\n" +
//     "                        </ul>\n" +
//     "                    </li>\n" +
//     "\n" +
//     "                    <!-- 會員頭像========================================================= -->\n" +
//     "                    <li id=\"useravatar\" class=\"nav-item dropdown mx-2 my-auto d-none\">\n" +
//     "                        <img id=\"avataroutside\"\n" +
//     "                            src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVBVtQ9oUbZtIaiZxiJTBVNkk2c4YbAu1cyZ-dYTsqgQ&s\"\n" +
//     "                            class=\"nav-link dropdown-toggle overflow-hidden rounded-circle p-0\" href=\"#\" role=\"button\"\n" +
//     "                            data-bs-toggle=\"dropdown\" aria-expanded=\"false\" width=\"36\" height=\"36\"\n" +
//     "                            style=\"object-fit: cover;\">\n" +
//     "\n" +
//     "                        <ul class=\"dropdown-menu dropdown-menu-lg-end\" aria-labelledby=\"navbarDropdown\">\n" +
//     "\n" +
//     "                            <li class=\"\">\n" +
//     "                                <img id=\"avatarinside\" class=\"overflow-hidden mx-1 p-2 rounded-circle\"\n" +
//     "                                    src=\"https://picsum.photos/200/200/?random=10\" width=\"150px\" height=\"150px\"\n" +
//     "                                    style=\"object-fit: cover;\">\n" +
//     "                            </li>\n" +
//     "                            <li>\n" +
//     "                                <span id=\"accountNickname\"\n" +
//     "                                    class=\"dropdown-item-text justify-content-center d-flex fs-5\">名字</span>\n" +
//     "                            </li>\n" +
//     "                            <li>\n" +
//     "                                <hr class=\"dropdown-divider\" />\n" +
//     "                            </li>\n" +
//     "                            <li>\n" +
//     "                                <a id=\"\" class=\"dropdown-item\" href=\"Account/AccountEdit.html\">查看個人資料</a>\n" +
//     "                            </li>\n" +
//     "                            <li>\n" +
//     "                                <a class=\"dropdown-item\" href=\"#!\">聊天列表</a>\n" +
//     "                            </li>\n" +
//     "                            <li>\n" +
//     "                                <a class=\"dropdown-item\" href=\"#!\">活動管理</a>\n" +
//     "                            </li>\n" +
//     "                            <li>\n" +
//     "                                <a class=\"dropdown-item\" href=\"#!\">課程管理</a>\n" +
//     "                            </li>\n" +
//     "                            <li>\n" +
//     "                                <a id=\"logout\" class=\"dropdown-item\" href=\"index.html\">登出</a>\n" +
//     "                            </li>\n" +
//     "                        </ul>\n" +
//     "                    </li>\n" +
//     "                    <!-- 登入 註冊=========================================================================== -->\n" +
//     "\n" +
//     "                    <li id=\"loginbtn\" class=\"nav-item dropdown mx-2 my-auto\">\n" +
//     "                        <a href=\"Account/Login.html\" class=\"btn btn-primary btn-lg\" tabindex=\"-1\" role=\"button\"\n" +
//     "                            aria-disabled=\"true\">登入</a>\n" +
//     "                        <a href=\"Account/SignUp.html\" class=\"btn btn-primary btn-lg\" tabindex=\"-1\" role=\"button\"\n" +
//     "                            aria-disabled=\"true\">註冊</a>\n" +
//     "                    </li>\n" +
//     "\n" +
//     "\n" +
//     "                </ul>\n" +
//     "                <!-- 購物車的按鈕============================================================= -->\n" +
//     "                <form class=\"d-flex\">\n" +
//     "                    <button class=\"btn btn-outline-dark d-flex text-nowrap\" type=\"submit\">\n" +
//     "                        <!-- 這個車車改class為bi-cart的話 就會變成空車 -->\n" +
//     "                        <i class=\"bi-cart-fill me-1\"></i>\n" +
//     "                        購物車\n" +
//     "                        <span class=\"badge bg-dark text-white ms-1 rounded-pill my-auto\">0</span>\n" +
//     "                    </button>\n" +
//     "                </form>\n" +
//     "            </div>\n" +
//     "        </div>";
//
// $("#searchbar").focus("click", function () {
//     $("#searchcard").removeClass("d-none");
// });
// $("#btn-close-search").on("click", function () {
//     $("#searchcard").addClass("d-none");
// })
//
// // ======================================================
// window.addEventListener("load", function () {
//
//     const accountId = sessionStorage.getItem(("accountId"));
//     const accountNickname = sessionStorage.getItem("accountNickname");
//     const accountLevel = sessionStorage.getItem("accountLevel");
//     const accountPhoto = sessionStorage.getItem("accountPhoto");
//     const nickname = document.querySelector("#accountNickname");
//     const logout = document.querySelector("#logout");
//     const loginbtn = document.querySelector("#loginbtn");
//     const avataroutside = document.querySelector("#avataroutside");
//     const avatarinside = document.querySelector("#avatarinside");
//     const useravatar = document.querySelector("#useravatar");
//
//     if (accountId) {
//         loginbtn.classList.add("d-none");
//         useravatar.classList.remove("d-none");
//         nickname.textContent = accountNickname;
//         const imageBinaryStr = atob(accountPhoto);
//         let len = imageBinaryStr.length;
//         const uint8Array = new Uint8Array(len);
//         while (len--) {
//             uint8Array[len] = imageBinaryStr.charCodeAt(len);
//         }
//         const blob = new Blob([uint8Array]);
//         avataroutside.src = URL.createObjectURL(blob);
//         avatarinside.src = URL.createObjectURL(blob);
//
//     } else {
//         loginbtn.classList.remove("d-none");
//         useravatar.classList.add("d-none");
//     }
//
//     logout.addEventListener("click", function () {
//         sessionStorage.removeItem("accountId");
//         sessionStorage.removeItem("accountLevel");
//         sessionStorage.removeItem("accountNickname");
//         sessionStorage.removeItem("accountPhoto");
//
//         fetch("Account/Logout");
//         location = "ixercise/index.html";
//     })
// });