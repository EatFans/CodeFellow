<!-- 用户浮窗菜单 -->
<template>
  <div class="user-drop-down-menu-container">
    <div class="user-info-content">
      <div class="user-info">
        <div class="user-avatar">
          <img :src="userProfile.avatarUrl" alt="User Avatar" class="user-avatar-img">
        </div>
        <div class="user-details">
          <p class="user-name">{{ userProfile.username }}</p>
        </div>
      </div>

    </div>

    <div class="user-action">

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
  }
}
</script>

<style scoped>
.user-drop-down-menu-container {
  width: 100%;
  height: 100%;

  background: #999999;
}

.user-info-content {
  width: 100%;
  height: 100px;
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
  border: 1px solid red;
}

.user-avatar{
  width: 64px;
  height: 64px;
  border: 1px solid black;
}

.user-avatar-img {
  width: 64px;
  height: 64px;
  border-radius: 50%;
}

.user-details {
  width: 100%;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  border: 1px solid deeppink;
}

.user-action {
  width: 100%;
  height: 250px;
  border: 1px solid black;

}

</style>