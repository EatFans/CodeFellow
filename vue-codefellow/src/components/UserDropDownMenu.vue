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

    </div>

    <!-- 用户操作主要内容 -->
    <div class="user-action-content">
      <div class="account-details"></div>
      <div class="account-details"></div>
      <div class="account-details"></div>
      <div class="account-details"></div>
      <div class="account-details"></div>
      <div class="account-details"></div>
      <div class="account-details"></div>
    </div>

    <!-- 退出登录 -->
    <div class="user-exit-login">
      <button @click="test">退出登录</button>
    </div>
  </div>
</template>

<script>
import {mapState} from "vuex";

export default {
  name: 'UserDropDownMenu',
  computed: {
    ...mapState('user',{
      userProfile: state => state.userProfile
    })
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
  border: 1px solid black;
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
  border: 1px solid deeppink;
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
  border: 1px solid red;
}

.user-officialCertification {
  font-size: 13px;
  color: #384764;
  margin-top:5px;
  margin-bottom: 5px;
}

.user-action-content {
  width: 100%;
  height: 250px;
  display: flex;
  margin-top: 5px;
  flex-wrap: wrap;
  border: 1px solid black;

}

.account-details {
  width: 140px;
  height: 30px;
  border: 1px solid black;
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