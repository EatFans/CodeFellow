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
            <form @submit.prevent="login">
              <div class="login-form-input-item" :class="{'input-error' : error.account}">
                <div class="login-form-input-item-title">
                  <label for="login-amount">账户 <span>*</span></label>
                  <p v-show="error.account">{{ error.account }}</p>
                </div>
                <input type="text" id="login-amount" name="amount" v-model="loginData.account">
              </div>
              <div class="login-form-input-item" :class="{'input-error' : error.password}">
                <div class="login-form-input-item-title">
                  <label for="login-password">密码 <span>*</span></label>
                  <p v-show="error.password">{{ error.password }}</p>
                </div>
                <input type="password" id="login-password" name="password" v-model="loginData.password">
              </div>
              <div class="login-form-item">
                <div class="login-negotiate">
                  <input type="checkbox" id="login-negotiate" name="negotiate" v-model="negotiate" />
                  <label for="login-negotiate">我同意 <a href="#">用户条款</a> 和 <a href="#">隐私协议</a> </label>
                  <p v-show="error.negotiateErrorVisible">请同意！！！</p>
                </div>
              </div>
              <div class="login-form-item">
                <div class="login-remember">
                  <input type="checkbox" id="remember" name="remember" v-model="loginData.rememberMe" />
                  <label for="remember">自动登录</label>
                </div>
                <div class="login-help">
                  <a href="/register" >立即注册</a>
                  <a href="/forget-password">忘记密码</a>
                </div>
              </div>

              <div class="login-error-message">
                <p v-show="error.login">{{error.login}}</p> 
              </div>

              <div class="login-button-item">
                <input type="submit" value="登录">
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
import authAPI from "@/api/AuthAPI";
import Label from "@/components/Label.vue";

export default {
  name: 'LoginDialog',
  components: {Label},
  props: {
    visible: {
      type: Boolean,
      default: false
    },
  },
  data(){
    return {
      // 登录数据
      loginData: {
        account: '',
        password: '',
        rememberMe: true
      },
      // 
      negotiate: false,

      // 登录错误数据
      error: {
        account: '',
        password: '',
        negotiateErrorVisible: false,
        login: ''
      }
    }
  },
  methods: {
    async login(){
      let flag = true;
      // 检查输入的账号是不是为空
      if (!this.loginData.account){
        this.error.account = '账号不能为空！';
        flag = false;
      } else {
        this.error.account = '';
      }
      // 检查输入的密码是不是为空
      if (!this.loginData.password){
        this.error.password = '密码不能为空！';
        flag = false;
      } else {
        this.error.password = '';
      }
      // 检查用户是否同意
      if (!this.negotiate){
        this.error.negotiateErrorVisible = true;
        flag = false;
      } else {
        this.error.negotiateErrorVisible = false;
      }
      // 发送登录请求
      if (flag){
        try {
          // 解析登录请求响应结果
          const response = await authAPI.login(this.loginData);
          const status = response.data.status;
          const message = response.data.message;
          const data = response.data.data;

          // console.log(status);
          // console.log(message);
          console.log(data);

          // 如果登录失败响应状态为error
          if (status == 'error'){
            if (data != null){
              this.error = data;
            }
          }
          // 如果登录成功响应状态为success
          if (status == 'success'){
            if (data != null){
              const token = data.token;

              // 测试日志输出
              console.log('登录成功！'+token);

              localStorage.setItem('token',token);

              setTimeout(() => {
                // 关闭弹窗
                this.closeDialog();
                this.$router.go(0); // 刷新当前路由页面
              }, 500);
            }
            
          }
        } catch (error) {
          console.error('登录请求失败：', error);
        }
      }
    },
    // 触发关闭弹窗的操作
    closeDialog() {
      this.$emit('update:visible', false);
      this.titleValue = '';
    },

  },


}
</script>

<style scoped>
.input-error input {
  outline: 1px solid red;
}

.login-error-message {
  margin-top: 5px;
}

.login-error-message p {
  font-size: 12px;
  display: flex;
  justify-content: center;
  color: red;
}

.login-negotiate p {
  font-size: 12px;
  margin-left: 10px;
  color: red;
}

.login-form-input-item-title p {
  font-size: 12px;
  margin-left: 10px;
  margin-top: 1px;
  color: red;
}

.login-form-input-item-title {
  display: flex;
  flex-direction: row;
}

.login-dialog-overlay-container {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.4); /* rgba(红, 绿, 蓝, 透明度) */
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
  /* border: 1px solid #2174f1; */
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

  /* border: 2px solid #1c1010; */
}

.login-box {
  width: 320px;
  height: 235px;
  display: flex;
  justify-content: center;

  /* border: 1px solid #7db92e;  */

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
  /* border: 1px solid red; */
}

.login-remember {
  display: flex;
  align-items: center;
}

.login-remember label {
  margin-left: 3px;
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

.login-negotiate {
  display: flex;
  flex-direction: row;
}

.login-negotiate label {
  margin-left: 3px;
  font-size: 12px;
}

.login-negotiate label a {
  text-decoration: none;
}

.login-button-item {
  margin-top: 2px;
}

.login-button-item input {
  width: 264px;
  height: 30px;
  border-radius: 4px;
  border:none;
  background: #7db92e;
  color: #fff;
}

.login-button-item input:hover {
  background: #a9da6a;
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