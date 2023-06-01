// const accountId = sessionStorage.getItem("accountId");
// const accountNickname = sessionStorage.getItem("accountNickname");
// const accountLevel = sessionStorage.getItem("accountLevel");
// const accountPhoto = sessionStorage.getItem("accountPhoto");
const pageavatar = document.querySelector("#pageavatar");
// const nickname = document.querySelector("#accountNickname");
// const logout = document.querySelector("#logout");
// const loginbtn = document.querySelector("#loginbtn");
// const avataroutside = document.querySelector("#avataroutside");
// const avatarinside = document.querySelector("#avatarinside");
// const useravatar = document.querySelector("#useravatar");
const pgnickname = document.querySelector("#pgnickname");
pgnickname.textContent = accountNickname;

if (accphoto !== "null") {
    const imageBinaryStr = atob(accphoto);
    let len = imageBinaryStr.length;
    const uint8Array = new Uint8Array(len);
    while (len--) {
        uint8Array[len] = imageBinaryStr.charCodeAt(len);
    }
    const blob = new Blob([uint8Array]);
    pageavatar.src = URL.createObjectURL(blob);
    // avatarinside.src = URL.createObjectURL(blob);
} else {
    const nophoto = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVBVtQ9oUbZtIaiZxiJTBVNkk2c4YbAu1cyZ-dYTsqgQ&s"
    pageavatar.src = nophoto;
    // avatarinside.src = nophoto;
}

//     ========================================================
const accEditPage = document.querySelector("#accEditPage");
window.addEventListener("load",function(){
    accEditPage.href = getContextPath()+"/Account/AccountEdit.html";

})


function getContextPath() {
    return window.location.pathname.substring(0, window.location.pathname.indexOf('/', 2));
}
