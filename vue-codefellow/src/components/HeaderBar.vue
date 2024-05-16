<template>
  <!-- 头部栏 -->
  <div class="header-bar">

    <!-- 菜单按钮 -->
    <div class="header-menu-button" @click="onMenuClick">
      <i class='bx bx-menu' style='color:#b7b8bd'></i>
    </div>

    <!-- Logo -->
    <div class="header-logo-img">
      <p>Logo图标正在赶来的路上</p>
    </div>

    <!-- 搜索框 -->
    <div class="search-box" id="search-box" >
      <i class='bx bx-search-alt' style='color:#999999' ></i>
      <label>
        <input  type="text" id="search-input" placeholder="搜索..." @click="toggleElement"/>
      </label>
      <!-- 搜索下拉框 -->
      <div v-show="showSearchDropdownContent" class="search-dropdown-content" id="search-dropdown-content">

      </div>
    </div>

  </div>
</template>

<script>
import '@/assets/theme.css'

export default {
  data() {
    return {
      showSearchDropdownContent: false, // 控制搜索下拉框是否显示的变量
      isLogin: false  // 是否登录
    }
  },

  mounted() {
    const loginToken = this.getCookie("token");
    if (loginToken){
      this.isLogin = true;
    }
  },
  methods: {
    /**
     * 当头部菜单被点击
     */
    onMenuClick(){
      //TODO: 测试
      if (this.isLogin){
        console.log("用户已经登录");
      } else {
        console.log("用户未登录");
      }
    },

    toggleElement() {
      this.showSearchDropdownContent = !this.showSearchDropdownContent; // 切换元素显示状态

    },
    getCookie(keyName){
      const value = `; ${document.cookie}`;
      const parts = value.split(`; ${name}=`);
      if (parts.length === 2) return parts[1].split(';').shift();
    }


  }
}

</script>


<style scoped>
.header-bar{
  position: fixed;
  top:0;
  display: flex;
  align-items: center; /* 垂直居中对齐 */
  height: 60px;
  width: 100%;
  z-index: 2;

  background: var(--ui-color);

}

.header-menu-button {
  position: relative;
  width: 30px;
  height: 30px;
  border: none;
  margin-left: 20px;
  font-size: 30px;

  background: transparent;
}

.header-menu-button i {
  position: absolute; /* 绝对定位 */
  top: 0;
  left: 0;
}

.header-logo-img {
  width: 200px;
  height: 50px;
  background-color: transparent;
  margin-left: 20px;
}

/* 搜索框 */
.search-box {
  margin-left: 20px;
  height: 40px;
  width: 600px;
  /* 设置搜索框透明度 */
  background-color:rgba(255,255,255,0.1);
  border-radius: 10px;
  border: none;
  position: relative;

  display: flex;
  align-items: center;
}

/* 搜索悬浮盒子 */
.search-dropdown-content {
  position: absolute;
  top: 100%;
  left: 50%;
  transform: translateX(-50%);

  width: 575px;
  height: 150px;

  background-color: var(--ui-color);
  border-width: 0;
  border-style: solid;
  border-right-color: #3a424f;
  border-top-color: #3a424f;
  border-bottom-color: #3a424f;
  border-left-color: #3a424f;
  border-radius: 8px;
  box-shadow: 0 4px 15px 0 rgba(0,0,0,0.2);
  padding: 10px;

  animation: slideInFromBottom 0.5s ease;
}

/* 搜索图标 */
.search-box i {
  margin-left: 5px;
  font-size: 27px;
}

/* 搜索输入框 */
.search-box input {
  height: 38px;
  width: 555px;
  font-size: 14px;
  margin-left: 5px;
  color: var(--header-input-text-color);
  background-color: transparent;
  border: none; /* 移除边框 */
  outline: none; /* 移除输入框聚焦时的外边框 */
}

/* 搜索框点击变透明 */
.search-box:focus-within {
  background-color: var(--header-input-background-color);

}

.search-box input::placeholder {
  color: #fff;
}

</style>