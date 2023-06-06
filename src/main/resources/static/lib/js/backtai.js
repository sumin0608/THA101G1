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
document.getElementById("accmanage").href = getContextPath() + "/Account/AccountManage.html"
document.getElementById("admanage").href = getContextPath() + "/Account/AdminManage.html"
document.getElementById("skmanage").href = getContextPath() + "/Account/SkillManage.html"
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

