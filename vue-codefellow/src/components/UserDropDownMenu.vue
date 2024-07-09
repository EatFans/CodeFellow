<!-- 用户浮窗菜单 -->
<template>
  <div class="user-drop-down-menu-container">
    <!-- 用户信息主要内容 -->
    <div class="user-info-content">
      <!-- 用户信息 -->
      <div class="user-info">
        <!-- 用户头像 -->
        <div class="user-avatar">
          <img :src="userProfile.avatarUrl" alt="User Avatar" class="user-avatar-img">
        </div>
        <!-- 用户名称 -->
        <div class="user-details">
          <p class="user-level">【lv：{{userProfile.level}}】</p>
          <p class="user-name">{{ userProfile.username }}</p>
<!--          <p class="user-officialCertification" v-show="userProfile.officialCertification"> [{{userProfile.officialCertification}}]</p>-->
        </div>
      </div>

    </div>

    <div class="social-stats-container">
      <!-- 粉丝量 -->
      <div class="fan-count-item">
        <a href="#" class="fan-count-item-content">
          <h1>3w</h1>
          <p>粉丝</p>
        </a>
      </div>
      <!-- 点赞量 -->
      <div class="like-count-item">
        <a href="#" class="like-count-item-content">
          <h1>999w</h1>
          <p>点赞</p>
        </a>
      </div>
      <!-- 关注量 -->
      <div class="follow-count-item">
        <a href="#" class="follow-count-item-content">
          <h1>999</h1>
          <p>关注</p>
        </a>
      </div>
    </div>

    <!-- 用户操作主要内容 -->
    <div class="user-action-content">
      <div class="user-action-item" v-for="(item,index) in userActionItems" :key="index">
        <i :class="item.icon"></i>
        <a :href="item.link">{{item.text}}</a>
      </div>
    </div>

    <!-- 退出登录 -->
    <div class="user-exit-login">
      <button @click="test">退出登录</button>
    </div>
  </div>
</template>

<script>
import {mapState} from "vuex";
import App from "@/App.vue";

export default {
  name: 'UserDropDownMenu',
  components: {App},
  computed: {
    ...mapState('user',{
      userProfile: state => state.userProfile
    })
  },
  data(){
    return {
      userActionItems: [
        {icon: 'bx bxs-user', text: '个人中心', link: ''},
        {icon: 'bx bxs-file', text: '帖子管理', link: ''},
        {icon: 'bx bxs-book-alt', text: '我的学习', link: ''},
        {icon: 'bx bxs-diamond', text: '会员中心', link: ''},
        {icon: 'bx bxs-wallet', text: '钱包', link: ''},
        {icon: 'bx bxs-hide', text: '隐私设置', link: ''},
        {icon: 'bx bxs-shield', text: '账号与密码', link: ''},
      ]
    }
  },
  methods: {
    test(){
      localStorage.removeItem('token');
      console.log('已经移除存在localStorage中的token')
      console.log('刷新页面中...');
      this.$router.go(0);
    },
  }
}
</script>

<style scoped>
.user-drop-down-menu-container {
  width: 100%;
  height: 100%;

  //background: #999999;
}

.user-info-content {
  width: 100%;
  height: auto;
  display: flex;
  flex-direction: column;
  align-items: center;
  //border: 1px solid black;
}

.user-info {
  width: 200px;
  height: 100%;
  display: flex;
  align-items: center;
  flex-direction: column;
  //border: 1px solid red;
}

.user-avatar{
  width: 48px;
  height: 48px;
  //border: 1px solid black;
}

.user-avatar-img {
  width: 48px;
  height: 48px;
  border-radius: 50%;
}

.user-details {
  width: 100%;
  height: 100%;
  display: flex;
  //flex-direction: column;
  align-items: center;
  justify-content: center;
  //border: 1px solid deeppink;
}

.user-name {
  font-size: 13px;
  color: #384764;
  margin-bottom: 5px;
}

.user-level {
  font-size: 13px;
  color: #2174f1;
  margin-bottom: 5px;
}

.social-stats-container {
  width: 100%;
  height: 60px;
  display: flex;
  //border: 1px solid red;
}

.fan-count-item ,.like-count-item ,.follow-count-item {
  flex: 1;
  display: flex;
  justify-content: center;
  align-items: center;

  //border: 1px solid black;

}

.fan-count-item-content , .like-count-item-content, .follow-count-item-content{
  width: 90%;
  height: 90%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  text-decoration: none;

  //background: #7db92e;
}

.fan-count-item-content p, .like-count-item-content p, .follow-count-item-content p{
  color: #999999;
  font-size: 13px;
}

.fan-count-item-content h1, .like-count-item-content h1, .follow-count-item-content h1{
  color: black;
  font-size: 18px;
}

.user-officialCertification {
  font-size: 13px;
  color: #384764;
  margin-top:5px;
  margin-bottom: 5px;
}

.user-action-content {
  width: 100%;
  height: auto;
  display: flex;
  flex-wrap: wrap;
  //border: 1px solid black;

}

.user-action-item {
  width: 100%;
  height: 30px;
  margin-top: 5px;
  margin-bottom: 10px;
  display: flex;
  align-items: center;

  //border: 1px solid black;
}

.user-action-item i {
  margin-left: 10px;
  color: #999999;
  font-size: 20px;
}

.user-action-item a {
  text-decoration: none;
  margin-left: 5px;
  font-size: 14px;
  color: #384764;
}


.user-exit-login {
  width: 100%;
  height: 35px;
  //border: 1px solid black;
}

.user-exit-login button {
  width: 100%;
  height: 100%;
  font-size: 13px;
  color: #384764;
  border: none;
  border-radius: 8px;
}

.user-exit-login button:hover {
  color: red;
}


</style>