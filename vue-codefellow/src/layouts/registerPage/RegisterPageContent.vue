<!-- 注册页面主要内容组件 -->
<template>
  <div class="register-page-content-container">
    <div class="register-page-content-header">
      <PageTitle title="注册" />
    </div>

    <div class="register-page-content-body">
      <div class="register-box-container">
        <div class="register-box">
          <form action="">

            <div class="register-form-input-item" :class="{ 'input-error': error.amount }">
              <div class="register-form-input-item-title">
                <label for="register-amount">账户 <span>*</span></label>
                <p v-show="error.amount">{{ error.amount }}</p>
              </div>
              <div class="input-box">
                <input type="text" id="register-amount" name="amount" v-model="registerData.amount">
              </div>
              <p class="item-readme">这将作为你的账号用于登录</p>
            </div>

            <div class="register-form-input-item" :class="{ 'input-error': error.password }">
              <div class="register-form-input-item-title" >
                <label for="register-password">密码 <span>*</span></label>
                <p v-show="error.password">{{ error.password }}</p>
              </div>
              <input type="password" id="register-password" name="password" v-model="registerData.password" v-on:input="togglePasswordDetectorBoxDisplay" @blur="togglePasswordDetectorBoxNotDisplay">

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

            <div class="register-form-input-item" :class="{'input-error' : error.passwordSure}">
              <div class="register-form-input-item-title">
                <label for="register-password-sure">确定密码 <span>*</span></label>
                <p v-show="error.passwordSure">{{ error.passwordSure }}</p>
              </div>
              <input type="password" id="register-password-sure" name="password-sure" v-model="passwordSure">
            </div>

            <div class="register-form-input-item" :class="{'input-error' : error.username}">
              <div class="register-form-input-item-title">
                <label for="register-username">用户名 <span>*</span></label>
                <p v-show="error.passwordSure">{{ error.username }}</p>
              </div>
              <input type="text" id="register-username" name="username" v-model="registerData.username">
              <p class="item-readme">这将作为你在本论坛显示的名称。选择任意你喜欢的名称吧！</p>
            </div>

            <div class="register-form-input-item" :class="{'input-error' : error.email}">
              <div class="register-form-input-item-title">
                <label for="register-email">邮箱 <span>*</span></label>
                <p v-show="error.email">{{ error.email }}</p>
              </div>
              <input type="email" id="register-email" name="email" v-model="registerData.email">
            </div>

            <div class="register-form-input-item" :class="{'input-error' : error.phoneNumber}">
              <div class="register-form-input-item-title">
                <label for="register-phoneNumber">手机号 <span>*</span></label>
                <p v-show="error.phoneNumber">{{ error.phoneNumber }}</p>
              </div>
              <input type="tel" id="register-phoneNumber" name="phoneNumber" v-model="registerData.phoneNumber">
            </div>

            <div class="register-form-input-item">
              <label for="register-referrer">推荐人 </label>
              <input type="text" id="register-referrer" name="referrer" v-model="registerData.referrer">
              <p class="item-readme">你的推荐人的用户名称。（选填）</p>
            </div>

            <div class="register-form-input-item">
              <div class="label-box">
                <label for="register-problem-verification">验证：</label>
                <p>请问本论坛英文名叫什么？</p>
              </div>
              <input type="text" id="register-problem-verification" name="problemVerification" v-model="problemVerification">
            </div>

            <div class="register-form-check-item-box">
              <div class="register-form-check-item">
                <input type="checkbox" id="negotiate" name="negotiate" v-model="negotiate">
                <label for="negotiate">我同意 <a href="#">用户条款</a> 和 <a href="#">隐私协议</a> </label>
              </div>

              <div class="register-form-check-item">
                <input type="checkbox" id="rules" name="rules" v-model="rules">
                <label for="rules">我自愿遵守本论坛 <a href="#">用户行为规范</a> </label>
              </div>
            </div>
            

            <div class="register-form-button-item">
              <input type="button" value="注册" @click="register">
            </div>
          </form>
        </div>

      </div>
    </div>

  </div>
</template>

<script>
import PageTitle from "@/components/PageTitle.vue";
import NoticesContainer from "@/components/NoticesContainer.vue";
import Label from "@/components/Label.vue";

export default {
  name: 'RegisterPageContent',
  components: {
    Label,
    PageTitle,
    NoticesContainer
  },
  data(){
    return {
      // 注册数据
      registerData: {
        amount: '',
        password: '',
        username: '',
        email: '',
        phoneNumber: '',
        recommender: '',
      },

      passwordSure: '', // 密码二次确定
      problemVerification: '', // 问题验证
      negotiate: '',  
      rules: '',

      // 密码检测窗口标识
      passwordDetectorVisible: false,

      error: {
        amount: '',
        password: '',
        passwordSure: '',
        username: '',
        email: '',
        phoneNumber: '',
      }
    }
  },
  methods:{
    // 注册函数
    register(){
      // 检查输入的账号是不是为空
      if (!this.registerData.amount){
        this.error.amount = '账号这里不能为空！！！';
      } else {
        this.error.amount = '';
      }
      // 检查输入的密码是不是为空
      if (!this.registerData.password){
        this.error.password = '密码这里不能为空！！！';
      } else {
        this.error.password = '';
      }
      // 检查输入的二次确定密码是不是为空
      if (!this.passwordSure){
        this.error.passwordSure = '二次确定密码这里不能为空！！！';
      } else {
        this.error.passwordSure = '';
      }
      // 检查输入的用户名是不是为空
      if (!this.registerData.username){
        this.error.username = '用户名这里不能为空！！！';
      } else {
        this.error.username = '';
      }
      // 检查输入的邮箱是不是为空
      if (!this.registerData.email){
        this.error.email = '邮箱这里不能为空！！！';
      } else {
        this.error.email = '';
      }
      // 检查输入的手机号是不是为空
      if (!this.registerData.phoneNumber){
        this.error.phoneNumber = '手机号这里不能为空！！！';
      } else {
        this.error.phoneNumber = ''
      }
    },
    togglePasswordDetectorBoxDisplay(){
      this.passwordDetectorVisible = true;
    },
    togglePasswordDetectorBoxNotDisplay(){
      this.passwordDetectorVisible = false;
    }

  }
}
</script>

<style scoped>

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

  /* background: #cc4242; */
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