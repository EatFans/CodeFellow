const searchBox = document.getElementById("search-box");
const searchDropdownContent = document.getElementById("search-dropdown-content");

const userButton = document.getElementById("user-button");

// 为搜索框添加事件监听器
searchBox.addEventListener("click", function(event) {
    // 阻止事件冒泡，避免被外部元素干扰
    event.stopPropagation();


    // 切换悬浮盒子的显示状态
    if (searchDropdownContent.style.display === 'block') {
        searchDropdownContent.style.display = 'none';
    } else {
        searchDropdownContent.style.display = 'block';
    }
});

// 为搜索下拉框添加事件监听器，防止被点击后隐藏
searchDropdownContent.addEventListener("click", function(event) {
    event.stopPropagation(); // 阻止事件冒泡
});


/**
 * 当页面被加载时候
 */
window.onload = function () {
    const element = document.getElementById("not-Login-message");
    if (!hasToken()){
        // 将元素设置为block
        element.style.display = "block";
    } else {
        //TODO: 将“登录”设置不可见，然后设置成用户的头像
        element.style.display = "none";
    }
}

/**
 * 当用户按钮被点击
 */
userButton.addEventListener("click",function (){
    // 检查token是否存在
    if (hasToken()){
        //TODO: 点击就跳转到用户界面

    } else {
        // TODO: 跳转到登录界面
        alert("准备跳转到登录界面");
    }
});

/**
 * 检查Cookie中是否存在token
 * @returns {boolean} 如果存在就返回true，否则就返回false
 */
function hasToken() {
    const token = getCookie("token");
    return !!token;
}

// 函数：从 cookie 中获取指定名称的值
function getCookie(name) {
    const cookies = document.cookie.split("; ");
    for (let cookie of cookies) {
        const [cookieName, cookieValue] = cookie.split("=");
        if (cookieName === name) {
            return cookieValue;
        }
    }
    return null;
}