<!-- 注册页面主要内容组件 -->
<template>
  <div class="register-page-content-container">
    <div class="register-page-content-header">
      <PageTitle title="注册" />
    </div>

    <div class="register-page-content-body">
      <div v-show="!isRegisterSuccess" class="register-box-container">
        <div class="register-box">
          <form @submit.prevent="register">
            <div class="register-form-input-item" :class="{ 'input-error': error.account }">
              <div class="register-form-input-item-title">
                <label for="register-amount">账户 <span>*</span></label>
                <p v-show="error.account">{{ error.account }}</p>
              </div>
              <div class="input-box">
                <input type="text" id="register-amount" name="amount" v-model="registerData.account">
              </div>
              <p class="item-readme">这将作为你的账号用于登录</p>
            </div>
            <div class="register-form-input-item" :class="{ 'input-error': error.password }">
              <div class="register-form-input-item-title">
                <label for="register-password">密码 <span>*</span></label>
                <p v-show="error.password">{{ error.password }}</p>
              </div>
              <input type="password" id="register-password" name="password" v-model="registerData.password" @input="togglePasswordDetectorBoxDisplay" @blur="togglePasswordDetectorBoxNotDisplay">
            </div>
            <!-- TODO: 密码检测窗口  -->
            <div v-show="passwordDetectorVisible" class="password-detector-box">
              <div class="password-detector-item">
                <p>至少八个字符</p>
              </div>
              <div class="password-detector-item">
                <p>至少有一个字母</p>
              </div>
              <div class="password-detector-item">
                <p>至少有一个大写字母</p>
              </div>
            </div>
            <div class="register-form-input-item" :class="{ 'input-error': error.passwordSure }">
              <div class="register-form-input-item-title">
                <label for="register-password-sure">确定密码 <span>*</span></label>
                <p v-show="error.passwordSure">{{ error.passwordSure }}</p>
              </div>
              <input type="password" id="register-password-sure" name="password-sure" v-model="passwordSure">
            </div>
            <div class="register-form-input-item" :class="{ 'input-error': error.username }">
              <div class="register-form-input-item-title">
                <label for="register-username">用户名 <span>*</span></label>
                <p v-show="error.username">{{ error.username }}</p>
              </div>
              <input type="text" id="register-username" name="username" v-model="registerData.username">
              <p class="item-readme">这将作为你在本论坛显示的名称。选择任意你喜欢的名称吧！</p>
            </div>
            <div class="register-form-input-item" :class="{ 'input-error': error.email }">
              <div class="register-form-input-item-title">
                <label for="register-email">邮箱 <span>*</span></label>
                <p v-show="error.email">{{ error.email }}</p>
              </div>
              <input type="email" id="register-email" name="email" v-model="registerData.email">
            </div>
            <div class="register-form-input-item" :class="{ 'input-error': error.phoneNumber }">
              <div class="register-form-input-item-title">
                <label for="register-phoneNumber">手机号 <span>*</span></label>
                <p v-show="error.phoneNumber">{{ error.phoneNumber }}</p>
              </div>
              <input type="tel" id="register-phoneNumber" name="phoneNumber" v-model="registerData.phoneNumber">
            </div>
            <div class="register-form-input-item">
              <label for="register-referrer">推荐人 </label>
              <input type="text" id="register-referrer" name="referrer" v-model="registerData.recommender">
              <p class="item-readme">你的推荐人的用户名称。（选填）</p>
            </div>
            <div class="register-form-input-item" :class="{ 'input-error': error.problemVerification }">
              <div class="label-box">
                <label for="register-problem-verification">验证：</label>
                <p>请问本论坛英文名叫什么？</p>
              </div>
              <input type="text" id="register-problem-verification" name="problemVerification" v-model="problemVerification">
              <p v-show="error.problemVerification" class="item-readme">答案错误，请输入正确的答案。</p>
            </div>
            <div class="register-form-check-item-box">
              <div class="register-form-check-item">
                <input type="checkbox" id="register-negotiate" name="negotiate" v-model="negotiate">
                <label for="register-negotiate">我同意 <a href="#">用户条款</a> 和 <a href="#">隐私协议</a> </label>
                <p v-show="negotiateErrorMessageeVisible">请同意后进行注册！！！</p>
              </div>
              <div class="register-form-check-item">
                <input type="checkbox" id="rules" name="rules" v-model="rules">
                <label for="rules">我自愿遵守本论坛 <a href="#">用户行为规范</a> </label>
                <p v-show="rulesErrorMessageVisible">请同意后进行注册！！！</p>
              </div>
            </div>
            
            <div class="register-error-message">
              <p v-show="error.register">{{ error.register }}</p>
            </div>

            <div class="register-form-button-item">
              <input type="submit" value="注册" >
            </div>
          </form>
        </div>
      </div>

      <!-- 注册成功后显示的 -->
      <div v-show="isRegisterSuccess" class="register-success-container">
        <div class="register-success-title">
          <h1>注册成功！</h1>
        </div>
        <div class="register-success-content">
          <p>
            用户您好！恭喜您注册成功！我们（NewWorldStudio团队）将发送一封邮件到您的邮箱进行账号验证！请前往邮箱进行完成账号验证激活！验证激活邮件过期时间为半小时，激活验证邮件过期激活验证失败无效，若激活验证邮件过期，请重新注册！
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import PageTitle from "@/components/PageTitle.vue";
import authAPI from "@/api/AuthAPI";

export default {
  name: 'RegisterPageContent',
  components: {
    PageTitle,
  },
  data() {
    return {
      registerData: {
        account: '',
        password: '',
        username: '',
        email: '',
        phoneNumber: '',
        recommender: '', 
      },
      passwordSure: '',
      problemVerification: '',
      negotiate: false,
      rules: false,   
      passwordDetectorVisible: false,  // 密码检查器是否显示
      isRegisterSuccess: false, // 是否注册成功
      negotiateErrorMessageeVisible: false,  // 条款错误文案是否显示
      rulesErrorMessageVisible: false,    // 规则错误文案是否显示
      // 错误数据对象
      error: {
        account: '',
        password: '',
        passwordSure: '',
        username: '',
        email: '',
        phoneNumber: '',
        problemVerification: false,
        register: ''
      },
      // 请求响应数据对象
      response: {
        stauts: '',
        message: '',
        data: ''
      }
    };
  },
  methods: {
    async register() {
      let flag = true;
      // 检查输入的账号是否为空
      if (!this.registerData.account) {
        this.error.account = '账号不能为空！';
        flag = false;
      } else {
        this.error.amount = '';
      }
      // 检查输入的密码是否为空
      if (!this.registerData.password) {
        this.error.password = '密码不能为空！';
        flag = false;
      } else {
        this.error.password = '';
      }
      // 检查输入的二次确定密码是否为空
      if (!this.passwordSure) {
        this.error.passwordSure = '请确认密码！';
        flag = false;
      } else {
        this.error.passwordSure = '';
      }
      // 检查输入的第一遍密码是否跟第二遍确定密码相同
      if (this.registerData.password != this.passwordSure){
        this.error.passwordSure = '确定密码与第一遍密码不相同！'
        flag = false;
      } else {
        this.error.passwordSure = '';
      }

      // 检查输入的用户名是否为空
      if (!this.registerData.username) {
        this.error.username = '用户名不能为空！';
        flag = false;
      } else {
        this.error.username = '';
      }
      // 检查输入的邮箱是否为空
      if (!this.registerData.email) {
        this.error.email = '邮箱不能为空！';
        flag = false;
      } else {
        this.error.email = '';
      }
      // 检查输入的手机号是否为空
      if (!this.registerData.phoneNumber) {
        this.error.phoneNumber = '手机号不能为空！';
        flag = false;
      } else {
        this.error.phoneNumber = '';
      }
      // 检查输入的问题答案是否正确
      if (this.problemVerification.toLowerCase() !== 'codefellow') {
        this.error.problemVerification = true;
        flag = false;
      } else {
        this.error.problemVerification = false;
      }
      // 检查用户是否同意条款
      if (!this.negotiate){
        this.negotiateErrorMessageeVisible = true;
        flag = false;
      } else {
        this.negotiateErrorMessageeVisible = false;
      }
      // 检查用户是否遵守规则
      if (!this.rules){
        this.rulesErrorMessageVisible = true;
        flag = false;
      } else {
        this.rulesErrorMessageVisible = false;
      }
      if (flag) {
        try {
          const response = await authAPI.register(this.registerData);
          // 检查响应体数据，判断是否注册成功
          const status = response.data.status;
          const message = response.data.message;
          const data = response.data.data;
          if (data != null){
            this.error = data;
          }
          if (status == "success"){
            setTimeout(() => {
            this.isRegisterSuccess = true;
            }, 1500);
          } else {
            console.log(message);
          }

          
        } catch (error) {
          console.error('注册请求失败：', error);
        }
      }
    },
   

    togglePasswordDetectorBoxDisplay() {
      this.passwordDetectorVisible = true;
    },
    togglePasswordDetectorBoxNotDisplay() {
      this.passwordDetectorVisible = false;
    }
  }
};
</script>

<style scoped>
.register-error-message {
  margin-top: 5px;
}

.register-error-message p {
  font-size: 12px;
  display: flex;
  justify-content: center;
  color: red;
}

.register-success-content {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}

.register-success-title {
  margin-top: 40px;
  display: flex;
  justify-content: center;
}

.register-success-container {
  width: 500px;
  height: 800px;
  display: flex;
  flex-direction: column;
  /* border: 1px solid black; */
}

.register-form-input-item-title p{
  font-size: 12px;
  margin-left: 10px;
  margin-top: 1px;
  color: red;
}

.register-form-input-item-title {
  display: flex;
  flex-direction: row;
}

.password-detector-box{
  display: flex;
  flex-direction: column;
}

.password-detector-item p{
  font-size: 14px;
}

.register-page-content-container {
  max-width: 1200px;
  margin: 80px auto 80px;
  height: 900px;

  /* //background: #7db92e; */
}

.register-page-content-header {
  width: 100%;

  /* //background: #00bd7e; */
}

.register-page-content-body {
  width: 100%;
  height: 100%;
  margin-top: 20px;
  display: flex;
  justify-content: center;
  border-radius: 0.7rem;
  box-shadow: 0 0.9rem 1.7rem rgba(0, 0, 0, 0.25), 0 0.7rem 0.7rem rgba(0, 0, 0, 0.22);
}

.register-box-container {
  width: 800px;
  height: 800px;

  margin-top: 30px;
  display: flex;
  justify-content: center;
  align-items: center;

  /* border: 1px solid black; */
}


.register-form-input-item {
  width: 350px;
  display: flex;
  flex-direction: column;
  margin-top: 10px;
}

.item-readme {
  font-size: 12px;
  color: #444343;
  margin-left: 3px;
}

.register-form-input-item label {
  font-size: 14px;
  margin-left: 3px;
}

.register-form-input-item label span {
  color: red;
}

.register-form-input-item input {
  width: 100%;
  height: 20px;
  border-radius: 4px;
  border: 1px solid #b0aaaa;
  padding: 5px;
  margin-top: 5px;
  font-size: 15px;
}

.input-error input {
  outline: 1px solid red;
}

.register-form-input-item input:focus {
  outline: 1px solid #2174f1;
}

.label-box {
  display: flex;
  flex-direction: row;
}

.label-box p {
  font-size: 14px;
  margin-left: 5px;
  color: #2174f1;
}

.register-form-button-item {
  width: 364px;
  height: 30px;
  margin-top: 10px;
}

.register-form-button-item input {
  width: 100%;
  height: 100%;
  border: none;
  border-radius: 4px;
  background: #7db92e;
  color: #fff;

}

.register-form-button-item input:hover {
  background: #a9da6a;
  color: #fff;

}

.register-form-check-item-box {
  margin-top:10px
}

.register-form-check-item {
  width: 350px;
  display: flex;
  flex-direction: row;
}

.register-form-check-item label {
  margin-left: 3px;
  font-size: 12px;
}

.register-form-check-item label a {
  text-decoration: none;
}

.register-form-check-item p {
  font-size: 12px;
  margin-left: 20px;
  color: red;
}

.password-detector-box {
  width: 250px;
  height: 200px;
  background: #fff;
  margin-top: 3px;
  margin-left: 110px;
  z-index: 1;
  position: absolute;
  border-radius: 0.7rem;
  box-shadow: 0 0.9rem 1.7rem rgba(0, 0, 0, 0.25), 0 0.7rem 0.7rem rgba(0, 0, 0, 0.22);
  /*border: 1px solid black; */

}

</style>