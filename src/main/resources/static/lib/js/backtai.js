/*!
    * Start Bootstrap - SB Admin v7.0.7 (https://startbootstrap.com/template/sb-admin)
    * Copyright 2013-2023 Start Bootstrap
    * Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-sb-admin/blob/master/LICENSE)
    */
// 
// Scripts
// 

window.addEventListener('DOMContentLoaded', event => {

    // Toggle the side navigation
    const sidebarToggle = document.body.querySelector('#sidebarToggle');
    if (sidebarToggle) {
        // Uncomment Below to persist sidebar toggle between refreshes
        // if (localStorage.getItem('sb|sidebar-toggle') === 'true') {
        //     document.body.classList.toggle('sb-sidenav-toggled');
        // }
        sidebarToggle.addEventListener('click', event => {
            event.preventDefault();
            document.body.classList.toggle('sb-sidenav-toggled');
            localStorage.setItem('sb|sidebar-toggle', document.body.classList.contains('sb-sidenav-toggled'));
        });
    }

});
// 用來轉換base64的圖片變成一個暫存連結
const nophoto = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVBVtQ9oUbZtIaiZxiJTBVNkk2c4YbAu1cyZ-dYTsqgQ&s"

function getcreateObjURL (base64photo){
    if(base64photo == null || base64photo == "null"){
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
// sidebar連結處理================================================================
// document.getElementById("accmanage").href = getContextPath() + "/Account/AccountManage.html"
// document.getElementById("admanage").href = getContextPath() + "/Account/AdminManage.html"
// document.getElementById("skmanage").href = getContextPath() + "/Account/SkillManage.html"
// ================================================================================
const sportTypeMap = {
    1: '足球',
    2: '籃球',
    3: '網球',
    4: '排球',
    5: '橄欖球',
    6: '棒球',
    7: '曲棍球',
    8: '高爾夫球',
    9: '羽毛球',
    10: '乒乓球',
    11: '壁球',
    12: '手球',
    13: '保齡球',
    14: '有氧操課',
    15: '重訓課',
    16: '瑜伽課',
    17: '舞蹈課',
    18: '腹肌課',
    19: '動感單車課',
    20: '跳繩課',
    21: '拳擊課',
    22: '跳舞操課',
    23: '瑜伽拉伸課',
    24: '其他'
};

// 處裡整條sidebar
// const sib = document.getElementById("backsidebar");

console.log(sib);
sib.innerHTML = `<div class="nav justify-content-center ">
                    <!-- <div class="sb-sidenav-menu-heading ">Core</div> -->
                    <a class="nav-link " href="${getContextPath()}/BackstageIndex.html">
                        <div class="sb-nav-link-icon">
                            <i class="bi bi-house-fill"></i>
                        </div>
                        後臺中心
                    </a>
                    <!-- <div class="sb-sidenav-menu-heading">Interface</div> -->
                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
                       data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                        <div class="sb-nav-link-icon">
                            <i class="bi bi-flag-fill"></i>
                        </div>
                        檢舉
                        <div class="sb-sidenav-collapse-arrow">
                            <i class="fas fa-angle-down"></i>
                        </div>
                    </a>
                    <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne"
                         data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav">

                            <a class="nav-link" id="changecount"  href="${getContextPath()}/hao/report.html">檢舉會員<span class="msg-counter reportspan"></span></a>

                        </nav>
                    </div>


                    <!--                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"-->
                    <!--                       data-bs-target="#collapseLayoutss" aria-expanded="false" aria-controls="collapseLayouts">-->
                    <!--                        <div class="sb-nav-link-icon">-->
                    <!--                            <i class="bi bi-chat-left-dots-fill"></i>-->
                    <!--                        </div>-->
                    <!--                        文章-->
                    <!--                        <div class="sb-sidenav-collapse-arrow">-->
                    <!--                            <i class="fas fa-angle-down"></i>-->
                    <!--                        </div>-->
                    <!--                    </a>-->
                    <!--                    <div class="collapse" id="collapseLayoutss" aria-labelledby="headingOne"-->
                    <!--                         data-bs-parent="#sidenavAccordion">-->
                    <!--                        <nav class="sb-sidenav-menu-nested nav">-->
                    <!--                            <a class="nav-link" href="">文章管理</a>-->

                    <!--                        </nav>-->
                    <!--                    </div>-->


                    <!--                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"-->
                    <!--                       data-bs-target="#collapseLayoutsss" aria-expanded="false" aria-controls="collapseLayouts">-->
                    <!--                        <div class="sb-nav-link-icon">-->
                    <!--                            <i class="bi bi-calendar-event-fill"></i>-->
                    <!--                        </div>-->
                    <!--                        活動-->
                    <!--                        <div class="sb-sidenav-collapse-arrow">-->
                    <!--                            <i class="fas fa-angle-down"></i>-->
                    <!--                        </div>-->
                    <!--                    </a>-->
                    <!--                    <div class="collapse" id="collapseLayoutsss" aria-labelledby="headingOne"-->
                    <!--                         data-bs-parent="#sidenavAccordion">-->
                    <!--                        <nav class="sb-sidenav-menu-nested nav">-->
                    <!--                            <a class="nav-link" href="">活動管理</a>-->

                    <!--                        </nav>-->
                    <!--                    </div>-->


                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
                       data-bs-target="#collapseLayoutssss" aria-expanded="false" aria-controls="collapseLayouts">
                        <div class="sb-nav-link-icon">
                            <i class="bi bi-cart-fill"></i>
                        </div>
                        商城
                        <div class="sb-sidenav-collapse-arrow">
                            <i class="fas fa-angle-down"></i>
                        </div>
                    </a>
                    <div class="collapse" id="collapseLayoutssss" aria-labelledby="headingOne"
                         data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav">
                            <a class="nav-link" href="${getContextPath()}/Kevin/ProductManage.html">商品管理</a>
                            <!-- <a class="nav-link" href="">訂單管理</a>
                            <a class="nav-link" href="">退貨管理</a> -->


                        </nav>
                    </div>

                    <!-- <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
                       data-bs-target="#collapseLayoutsssss" aria-expanded="false" aria-controls="collapseLayouts">
                        <div class="sb-nav-link-icon">
                            <i class="bi bi-book-fill"></i>
                        </div>
                        課程
                        <div class="sb-sidenav-collapse-arrow">
                            <i class="fas fa-angle-down"></i>
                        </div>
                    </a>
                    <div class="collapse" id="collapseLayoutsssss" aria-labelledby="headingOne"
                         data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav">
                            <a class="nav-link" href="">課程管理</a>
                             <a class="nav-link" href="">審核退費</a> -->
                    <!--
                                            </nav>
                                        </div>  -->


                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayoutssssssa" aria-expanded="false" aria-controls="collapseLayouts">
                        <div class="sb-nav-link-icon"><i class="bi bi-broadcast-pin"></i></div>
                        後臺廣播
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                    </a>
                    <div class="collapse" id="collapseLayoutssssssa" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav">
                            <a class="nav-link" href="${getContextPath()}/hao/backpodcast.html">後臺推播</a>
                            <a class="nav-link" href="${getContextPath()}/hao/newbackcun.html">後臺聊天室</a>

                        </nav>
                    </div>


                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
                       data-bs-target="#collapseLayoutssssss" aria-expanded="false"
                       aria-controls="collapseLayouts">
                        <div class="sb-nav-link-icon">
                            <i class="bi bi-person-fill"></i>
                        </div>
                        帳號
                        <div class="sb-sidenav-collapse-arrow">
                            <i class="fas fa-angle-down"></i>
                        </div>
                    </a>

                    <div class="collapse" id="collapseLayoutssssss" aria-labelledby="headingOne"
                         data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav">
                            <a id="AccountManage" class="nav-link" href="${getContextPath()}/Account/AccountManage.html">會員管理
<!--                                <span class="msg-counter accountspan">7</span>-->
                            </a>
                            <a id="AdminManage" class="nav-link" href="${getContextPath()}/Account/AdminManage.html">管理員管理
<!--                                <span class="msg-counter adminspan">7</span>-->
                            </a>
                            <a id="CoachManage" class="nav-link" href="${getContextPath()}/Account/SkillManage.html">審核教練資格
<!--                                <span class="msg-counter coachapplyspan" style="right:45px;">7</span>-->
                            </a>
                        </nav>
                    </div>

                </div>`;
