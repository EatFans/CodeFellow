<!-- 登录注册弹窗组件 -->
<template>
  <div v-show="visible" class="auth-dialog-overlay-container">
    <div class="auth-dialog-overlay-content" >
      <div class="auth-dialog-overlay-header">
        <h3 class="title-value">{{ getTitleValue() }}</h3>
        <button class="close-button" @click="closeDialog">
          <i class='bx bx-x'></i>
        </button>
      </div>

      <div class="auth-dialog-overlay-body">
        <div class="login-box-container">
          <div class="other-sign-in-box">
            <p>其他登录</p>
            <button class="github-login" @click="">
              <i class='bx bxl-github' ></i>
              <p>GitHub</p>
            </button>
            <button class="qq-login" @click="">

              <p>QQ</p>
            </button>
          </div>

          <!-- 登录盒子 -->
          <div class="sign-in-box">
            <form >
              <div class="form-group">
                <label for="username">用户名 <span>* </span></label>
                <input type="text" id="username" v-model="signInUserName" />
              </div>
              <div class="form-group">
                <label for="password">密码 <span>* </span></label>
                <input type="password" id="password" v-model="signInPassword" />
              </div>
            </form>
          </div>

          <!-- 注册盒子 -->
          <div class="register-box">

          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Label from "@/components/Label.vue";

export default {
  name: 'AuthDialog',
  components: {Label},
  props: {
    visible: {
      type: Boolean,
      default: false
    },
    // 弹窗类型
    authType: {
      type: String,
      required: true,
      validator(value) {
        return ['login', 'register',''].includes(value);
      }
    }
  },
  data(){
    return {
      signInUserName: '',
      signInPassword: '',
    }
  },
  methods: {
    // 触发关闭弹窗的操作
    closeDialog() {
      this.$emit('update:visible', false);
      this.titleValue = '';
    },

    // 获取弹窗标题
    getTitleValue(){
      let titleValue;

      switch (this.authType.toLowerCase()){
        case 'login':
          titleValue = '登录'
          break;
        case 'register':
          titleValue = '注册';
          break;
        default:
          titleValue = '';
          break;

      }

      return titleValue;
    }
  },


}
</script>

<style scoped>
.auth-dialog-overlay-container {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5); /* rgba(红, 绿, 蓝, 透明度) */
  z-index: 1000;
  display: flex;
  justify-content: center; /* 水平居中 */
  align-items: center; /* 垂直居中 */
}

.auth-dialog-overlay-content {
  width: 700px;
  background: #fff;
  border-radius: 0.7rem;
  box-shadow: 0 0.9rem 1.7rem rgba(0, 0, 0, 0.25), 0 0.7rem 0.7rem rgba(0, 0, 0, 0.22);
}

.auth-dialog-overlay-header {
  width: 100%;
  height: 40px;
  //border: 1px solid #2174f1;
  border-radius: 0.7rem 0.7rem 0 0;
  display: flex;
  flex-direction: row;
  justify-content: space-between; /* 将元素分散对齐 */
  align-items: center; /* 垂直居中对齐 */
}

.title-value {
  margin-left: 10px;
  font-size: 13px;
  font-weight: bold; /* 调整为较细的字体 */
  color: #1c1010; /* 较柔和的文本颜色 */
  font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
}

.close-button {
  margin-top: 5px;
  margin-right: 10px;
  font-size: 1.4em;
  border: none;
}

.close-button:hover {
  color: #b7b8bd;
}

.auth-dialog-overlay-body {
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;

  border: 2px solid #1c1010;
}

.login-box-container {
  width: 480px;
  height: 100%;


}

.other-sign-in-box {
  width: 100%;
  height: 60px;

  display: flex;
  flex-direction: row;
  align-items: center;

  border: 1px solid #1c1010;
}

.other-sign-in-box p {
  margin-right: 10px;
  font-size: 14px;
}

.github-login {
  height: 35px;
  width: auto;
  border-radius: 8px;
  background: #666666;
  border: none;
  display: flex;
  flex-direction: row;
  align-items: center;

}

.qq-login {
  height: 35px;
  width: auto;
  margin-left: 10px;
  border-radius: 8px;
  background: #2aa2de;
  border: none;
  display: flex;
  flex-direction: row;
  align-items: center;
}

.github-login i , .qq-login i{
  margin-left: 10px;
  margin-right: 5px;
  font-size: 1.5em;
}

.github-login p, .qq-login p {
  margin-right: 10px;
  color: #fff;
}

.sign-in-box {
  width: 100%;
  height: 400px;
  border: 1px solid #384764;
}

.form-group label span{
  color: red;
}

.login-dialog-content {

}


</style>