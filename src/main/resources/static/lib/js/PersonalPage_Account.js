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
const addsk = document.querySelector("#addskill");
const accEditPage = document.querySelector("#accEditPage");//編輯個人頁面按鈕
const accgen = document.querySelector("#accgen");//性別
const pgaccintro = document.querySelector("#pgaccintro");//自我介紹
const sktable = document.querySelector("#skilltable");
const pgaccskillli = document.querySelector("#pgaccskillli");


// =====================================================
applytbc.href = getContextPath() + '/Account/ApplyToBeCoach.html';
accEditPage.href = getContextPath() + "/Account/AccountEdit.html";
addsk.href = getContextPath() + "/Account/AddSkill.html";

// 刷新會員資訊==========================================
const urlParams = new URLSearchParams(window.location.search);
const urlaccId = urlParams.get('accountId');

if (urlaccId == accid) {
    accEditPage.classList.remove("d-none");
    if (acclevel == 2) {
        addsk.classList.remove("d-none");
    } else {
        applytbc.classList.remove("d-none");
    }
}

fetch('PersonalPage/' + urlaccId)
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
                pgnickname.textContent = accountNickname;
                pgcity.textContent = accountAddress.substring(0, 3);
                accgen.textContent = accGenMap[accountGender];
                pgaccintro.textContent = accountIntro;
            } else if (accountLevel == 2) {
                pgaccskillli.classList.remove("d-none");
                sktable.classList.remove("d-none");
                pgnickname.textContent = accountNickname;
                pgcity.textContent = accountAddress.substring(0, 3);
                accgen.textContent = accGenMap[accountGender];
                pgaccintro.textContent = accountIntro;
                let skilltd = ""
                coachSkillList.forEach(skill => {
                    skilltd += `<tr>
                                <td>${sportTypeMap[skill.sportType]}</td>
                                <td>${skill.licenseName}</td>
                                </tr>`

                })
                sktable.innerHTML += skilltd;


            } else {
                alert("查詢異常");
                location.assign(getContextPath() + "/index.html")
            }

        }
    )


// ==============================================================================


// ==========================================
if (accphoto !== "null") {
    pageavatar.src = getcreateObjURL(accphoto);
} else {
    pageavatar.src = nophoto;
}

//     ========================================================

function getContextPath() {
    return window.location.pathname.substring(0, window.location.pathname.indexOf('/', 2));
}
