
// 搜索框点击展开搜索下悬浮盒子
document.addEventListener("click",function (){
    const searchBox = document.getElementById("search-box");
    const searchDropdownContent = document.getElementById("search-dropdown-content");

    // 如果点击的目标是 inputField 或 floatingBox 的后代元素，则显示盒子
    if (event.target === searchBox || searchBox.contains(event.target) || event.target === searchDropdownContent || searchDropdownContent.contains(event.target)) {
        searchDropdownContent.style.display = 'block'; // 显示悬浮盒子
    } else {
        searchDropdownContent.style.display = 'none'; // 隐藏悬浮盒子
    }
});


function changeColor(element) {
    element.style.backgroundColor = '#313742FF'; // 鼠标悬停时的背景颜色
}

function resetColor(element) {
    element.style.backgroundColor = 'transparent'; // 默认背景颜色
}