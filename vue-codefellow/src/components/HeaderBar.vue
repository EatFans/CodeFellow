<template>
  <!-- 头部栏 -->
  <div class="header-bar">

    <!-- 菜单按钮 -->
    <div class="menu-box">
      <button class="header-menu-button" @click="onMenuClick">
        <i class='bx bx-menu' style=''></i>
      </button>

      <!-- 左侧导航栏 -->
      <LeftNav v-show="leftNavVisible && screenWidth > 1500" />
    </div>

    <!-- Logo -->
    <div class="header-logo-img">
      <p>Logo图标正在赶来的路上</p>
    </div>

    <!-- 搜索框 -->
    <div class="search-box" id="search-box" v-show="screenWidth > 1200">
      <i class='bx bx-search-alt' style='color:#999999' ></i>
      <label>
        <input  type="text" id="search-input" placeholder="搜索..." @click="toggleSearchDropContentElement"/>
      </label>
      <!-- 搜索下拉框 -->
      <div v-show="isShowSearchDropdownContent" class="search-dropdown-content" id="search-dropdown-content">

      </div>
    </div>

    <!--  用户操作盒子    -->
    <div class="user-box">
      <!-- 用户未登录 -->
      <div v-if="!isLogin" class="not-login-user-box">
        <button @click="onLoginButtonClick"  class="login-button">
          <i class='bx bx-arrow-from-left'></i>
          <p>登录</p>
        </button>

        <button @click="onRegisterButtonClick" class="register-button">
          <i class='bx bx-user-plus'></i>
          <p>注册</p>
        </button>

      </div>
      <!-- 用户已经登录 -->
      <div v-else class="login-user-box">
        <button class="user-button" @click="toggleUserDropDownMenuDisplay">
          <img :src="userProfile.avatarUrl" alt="">
          <p>{{userProfile.username}}</p>
        </button>
        <!-- 用户资料小浮窗 -->
        <div v-show="userDropDownMenuVisible" class="user-dropdown-menu">
          <UserDropDownMenu />
        </div>

        <button  class="message-button" @click="test()">
          <i class='bx bxs-envelope' ></i>
        </button>
        <!-- 用户消息小浮窗 -->

        <button class="star-button">
          <i class='bx bxs-bookmark-star' ></i>
        </button>

        <button class="post-button">
          <i class='bx bxs-book-add' ></i>
        </button>
      </div>
    </div>

  </div>

  <LoginDialog v-show="dialogVisible" @update:visible="dialogVisible  = $event"/>
</template>

<script>
import '@/assets/theme.css'
import LeftNav from "@/components/LeftNav.vue"
import LoginDialog from "@/components/LoginDialog.vue";
import { mapState } from 'vuex';
import UserDropDownMenu from "@/components/UserDropDownMenu.vue";
export default {
  components:{
    UserDropDownMenu,
    LoginDialog,
    LeftNav
  },
  data() {
    return {
      isShowSearchDropdownContent: false, // 控制搜索下拉框是否显示的变量
      // isShowLeftNav: true,  // 是否显示左侧导航栏
      screenWidth: window.innerWidth, // 初始屏幕宽度

      dialogVisible: false, // 是否显示验证弹窗

      userDropDownMenuVisible: false  // 用户浮窗菜单显示标识

    }
  },
  computed: {
    ...mapState('user', {
      userProfile: state => state.userProfile,
      isLogin: state => state.isLogin,
      token: state => state.token
    }),
    ...mapState('settings',{
      leftNavVisible: state => state.leftNavVisible,
    })
  },
  created() {
    // 监听窗口大小变化
    window.addEventListener('resize', this.updateScreenWidth);

  },
  destroyed() {
    // 移除窗口大小变化监听器
    window.removeEventListener('resize', this.updateScreenWidth);
  },
  methods: {
    test(){
      localStorage.removeItem('token');
      console.log('已经移除存在localStorage中的token')
      setTimeout(() => {
        console.log('刷新页面中...');
        this.$router.go(0);
      }, 2000);
    },
    updateScreenWidth() {
      this.screenWidth = window.innerWidth;
    },
    /**
     * 当头部登录按钮被点击
     */
    onLoginButtonClick(){
      this.dialogVisible = !this.dialogVisible;
    },
    /**
     * 当头部注册按钮被点击
     */
    onRegisterButtonClick(){
      location.href = "/register";
    },
    /**
     * 当头部菜单被点击
     */
    onMenuClick(){
      this.$store.commit('settings/SET_LEFT_NAV_VISIBLE',!this.leftNavVisible);
    },
    /**
     * 切换搜索下拉框容器元素显示状态
     */
    toggleSearchDropContentElement() {
      this.isShowSearchDropdownContent = !this.isShowSearchDropdownContent; // 切换元素显示状态

    },
    /**
     * 切换用户浮窗菜单显示
     */
    toggleUserDropDownMenuDisplay(){
      this.userDropDownMenuVisible = !this.userDropDownMenuVisible;
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

  color:#b7b8bd;
  background: transparent;
}

.header-menu-button:hover {
  color: #fff;
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

.user-box {
  height: 30px;
  width: 200px;
  display: flex;
  margin-left: auto;
  margin-right: 30px;
  position: relative;

}

.not-login-user-box {
  display: flex;
  align-items: center;
  justify-content: center;
  position: absolute; /* 绝对定位 */
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  font-size: 14px;

}

.register-button {
  margin-left: auto;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 5px 10px;
  background-color: transparent;
  color: #bcd5f9;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  text-decoration: none;
}

.login-button {
  margin-left: 70px;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 5px 10px;
  background-color: transparent;
  color: #bcd5f9;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  text-decoration: none;
}

.not-login-user-box button i {
  font-size: 1.5em;
}

.not-login-user-box p {
  font-size: 12px;
}

.login-button:hover,
.register-button:hover {
  color: #fff;
}


.login-user-box {
  display: flex;
  align-items: center;
  position: absolute; /* 绝对定位 */
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  font-size: 14px;

  justify-content: flex-start;

  /* //background: #00bd7e; */
}

.user-button {
  margin-left: 0;
  min-width: 40px;
  display: flex;
  align-items: center;
  justify-content: center;
  background-color: transparent;
  color: #bcd5f9;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  text-decoration: none;

}

.user-button img {
  border-radius: 5px;
  width: 25px;
  height: 25px;
  margin-right: 2px;
}

.user-button p {
  margin-top: 5px;
  margin-left: 8px;
  font-size: 12px;
}


.user-button {
  flex: 0 0 auto; /* 不要伸缩，固定宽度 */
  width: 80px; /* 缩小 user-button 宽度 */
  margin-right: 15px; /* user-button 和 message-button 之间间隔增大 */
}

.message-button,
.star-button,
.post-button {
  flex: 0 0 auto; /* 不要伸缩，固定宽度 */
  width: calc((200px - 80px - 15px - 2 * 10px) / 3); /* 计算剩余按钮的宽度 */
  margin-right: 10px; /* 设置按钮之间的间隔 */
  margin-top: 6px;
  border: none;
  background: transparent;
  color: #bcd5f9;
}

/* 最后一个按钮去掉右侧间距 */
.post-button {
  margin-right: 0;
}


.message-button i,
.star-button i,
.post-button i {
  font-size: 1.4em;
}

.user-button:hover,
.message-button:hover,
.star-button:hover,
.post-button:hover {
  color: #fff;
}

/* 用户资料小浮窗样式 */
.user-dropdown-menu {
  position: absolute;
  top: 34px; /* 设置为user-button底部 */
  right: 50px;
  width: 240px;
  height: auto;
  background: #fff;
  border-radius: 8px;
  box-shadow: 0 0.9rem 1.7rem rgba(0, 0, 0, 0.25), 0 0.7rem 0.7rem rgba(0, 0, 0, 0.22);
  padding: 10px;
  z-index: 10;
  animation: slideInFromTop 0.5s ease; /* 添加动画 */
}

/* 出场动画效果 */
@keyframes slideInFromTop {
  0% {
    transform: translateY(-10px);
    opacity: 0;
  }
  100% {
    transform: translateY(0);
    opacity: 1;
  }
}

</style>