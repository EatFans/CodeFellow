<!-- 登录弹窗组件 -->
<template>
  <div v-show="visible" class="login-dialog-overlay-container">
    <div class="login-dialog-overlay-content" >

      <!-- 登录内容 -->
      <div class="login-dialog-overlay-body">
        <div class="login-dialog-overlay-header">
          <h3 class="title-value">登录</h3>
          <button class="close-button" @click="closeDialog">
            <i class='bx bx-x'></i>
          </button>
        </div>

        <div class="login-dialog-overlay-body-content">
          <div class="login-box">
            <form action="#">
              <div class="login-form-input-item">
                <label for="login-amount">账户 <span>*</span></label>
                <input type="text" id="login-amount" name="amount" :value="amount">
              </div>
              <div class="login-form-input-item">
                <label for="login-password">密码 <span>*</span></label>
                <input type="password" id="login-password" name="password" :value="password">
              </div>
              <div class="login-form-item">
                <div class="login-remember">
                  <input type="checkbox" id="remember" name="remember" checked>
                  <label for="remember">自动登录</label>
                </div>
                <div class="login-help">
                  <a href="#" >立即注册</a>
                  <a href="#">忘记密码</a>
                </div>
              </div>
              <div class="login-button-item">
                <input type="button" value="登录">
              </div>
            </form>
          </div>

          <!-- 其他登录 -->
          <div class="other-login-box">
            <div class="other-login-box-boundary-item"></div>

            <div class="other-login-box-content">
              <p>其他登录</p>
            </div>
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
  },
  data(){
    return {
      amount: '',
      password: '',
    }
  },
  methods: {
    // 触发关闭弹窗的操作
    closeDialog() {
      this.$emit('update:visible', false);
      this.titleValue = '';
    },

  },


}
</script>

<style scoped>
.login-dialog-overlay-container {
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

.login-dialog-overlay-content {
  width: 400px;
  background: #fff;
  border-radius: 0.7rem;
  box-shadow: 0 0.9rem 1.7rem rgba(0, 0, 0, 0.25), 0 0.7rem 0.7rem rgba(0, 0, 0, 0.22);
}

.login-dialog-overlay-header{
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

.login-dialog-overlay-body-content {
  width: 100%;
  height: auto;
  display: flex;
  flex-direction: column;
  align-items: center;

  //border: 2px solid #1c1010;
}

.login-box {
  width: 320px;
  height: 200px;
  display: flex;
  justify-content: center;

  //border: 1px solid #7db92e;

}

.login-form-input-item {
  width: 254px;
  display: flex;
  flex-direction: column;
  margin-top: 5px;
}

.login-form-input-item label {
  font-size: 14px;
  margin-left: 3px;
}

.login-form-input-item label span {
  color: red;
}

.login-form-input-item input {
  width: 100%;
  height: 20px;
  border-radius: 4px;
  border: 1px solid #b0aaaa;
  padding: 5px;
  margin-top: 5px;
}

.login-form-input-item input:focus {
  outline: 1px solid #2174f1;
}

.login-form-item {
  width: 100%;
  margin-top: 10px;

  display: flex;
  flex-direction: row;
  //border: 1px solid red;
}

.login-remember {
  display: flex;
  align-items: center;
}

.login-remember label {
  font-size: 12px;
}

.login-help {
  display: flex;
  align-items: center;
  margin-left: auto;
}

.login-help a {
  margin-left: 5px;
  font-size: 12px ;
}

.login-help a:hover {
  color: gold;
}

.login-button-item {
  margin-top: 5px;
}

.login-button-item input {
  width: 264px;
  height: 30px;
  border-radius: 4px;
  border:none;
  background: #7db92e;
  color: #fff;
}

.other-login-box {
  width: 100%;
  height: 90px;

  display: flex;
  flex-direction: column;

}

.other-login-box-boundary-item {
  bottom: 0;
  left: 0;
  width: 100%;
  height: 1px;
  background: var(--ui-color);
  border-radius: 4px;
}

.other-login-box-content {
  margin-top: 20px;

  height: 40px;
  display: flex;
  align-items: center;
  justify-content: center;
}

.other-login-box-content p {
  font-size: 12px;
}

</style>