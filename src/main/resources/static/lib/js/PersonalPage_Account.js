// const accountId = sessionStorage.getItem("accountId");
// const accountNickname = sessionStorage.getItem("accountNickname");
// const accountLevel = sessionStorage.getItem("accountLevel");
// const accountPhoto = sessionStorage.getItem("accountPhoto");
// const nickname = document.querySelector("#accountNickname");
// const logout = document.querySelector("#logout");
// const loginbtn = document.querySelector("#loginbtn");
// const avataroutside = document.querySelector("#avataroutside");
// const avatarinside = document.querySelector("#avatarinside");
// const useravatar = document.querySelector("#useravatar");
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
    24: '瑜伽拉伸課'
};
const accGenMap = {
    0: '不公開',
    1: '男',
    2: '女'
};
// 改變pg內容的變數
const pageavatar = document.querySelector("#pageavatar");
const pgcity = document.querySelector("#pgcity");
const pgnickname = document.querySelector("#pgnickname");
const applytbc = document.querySelector("#applytobecoach");//申請成為教練按鈕
const accEditPage = document.querySelector("#accEditPage");//編輯個人頁面按鈕
const accgen = document.querySelector("#accgen");//性別
const pgaccintro = document.querySelector("#pgaccintro");//自我介紹
const sktable = document.querySelector("#skilltable");


// =====================================================
applytbc.href = getContextPath() + '/Account/ApplyToBeCoach.html'
accEditPage.href = getContextPath() + "/Account/AccountEdit.html";
// pgnickname.textContent = accnickname;
// 刷新會員資訊==========================================
const urlParams = new URLSearchParams(window.location.search);
const accountId = urlParams.get('accountId');

console.log(accountId); // 输出accountId的值

fetch('PersonalPage/' + accountId)
    .then(resp => resp.json())
    .then(body => {
            const {
                successful
                , message
                , accountId
                , accountLevel
                , accountState
                , accountAddress
                , accountGender
                , accountIntro
                , accountNickname
                , coachSkillList
            } = body;
            console.log(typeof accountLevel + accountLevel);

            if (accountLevel === 1) {
                console.log(body);
            } else if (accountLevel == 2) {
                pgnickname.textContent = accountNickname;
                pgcity.textContent = accountAddress.substring(0, 3);
                accgen.textContent = accGenMap[accountGender];
                pgaccintro.textContent = accountIntro;
                let skilltd = ""
                coachSkillList.forEach(skill => {
                    skilltd += `<tr>
                                    <td>${skill.licenseName}</td>
                                    <td>${sportTypeMap[skill.sportType]}</td>
                                    </tr>`

                })
                sktable.innerHTML += skilltd;


            }else{
                alert("查詢異常");
                location.assign(getContextPath() + "/index.html")
            }

        }
    )


// ==============================================================================


// ==========================================
if (accphoto !== "null") {

    pageavatar.src = getcreateObjURL(accphoto);
    // const imageBinaryStr = atob(accphoto);
    // let len = imageBinaryStr.length;
    // const uint8Array = new Uint8Array(len);
    // while (len--) {
    //     uint8Array[len] = imageBinaryStr.charCodeAt(len);
    // }
    // const blob = new Blob([uint8Array]);
    // pageavatar.src = URL.createObjectURL(blob);
    // avatarinside.src = URL.createObjectURL(blob);
} else {
    // const nophoto = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVBVtQ9oUbZtIaiZxiJTBVNkk2c4YbAu1cyZ-dYTsqgQ&s"
    pageavatar.src = nophoto;
    // avatarinside.src = nophoto;
}

//     ========================================================


// function getcreateObjURL (base64photo){
//     const imageBinaryStr = atob(base64photo);
//     let len = imageBinaryStr.length;
//     const uint8Array = new Uint8Array(len);
//     while (len--) {
//         uint8Array[len] = imageBinaryStr.charCodeAt(len);
//     }
//     const blob = new Blob([uint8Array]);
//     return URL.createObjectURL(blob);
// }


function getContextPath() {
    return window.location.pathname.substring(0, window.location.pathname.indexOf('/', 2));
}

// ===================================

// 获取URL中的参数


// ====================================
// function getAccountIdFromURL() {
//     var url = window.location.href;
//     var index = url.lastIndexOf("/");
//     var accountId = url.substring(index + 1);
//     return accountId;
// }
//
// // 发起 AJAX 请求获取会员信息
// function fetchAccountInfo(accountId) {
//     $.ajax({
//         url: "/PersonalPage.html/" + accountId,
//         method: "GET",
//         success: function(response) {
//             // 更新页面的相关部分
//             updatePageContent(response);
//         },
//         error: function(xhr, status, error) {
//             // 处理请求错误
//             console.log("Error fetching account info: " + error);
//         }
//     });
// }
//
// // 更新页面内容
// function updatePageContent(accountInfo) {
//     console.log(accountInfo);
// }
//
// // 页面加载完成后执行的操作
// $(document).ready(function() {
//     var accountId = getAccountIdFromURL();
//     fetchAccountInfo(accountId);
// });
