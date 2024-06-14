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
            <div class="register-form-input-item">
              <label for="register-amount">账户 <span>*</span></label>
              <div class="input-box">
                <input type="text" id="register-amount" name="amount" v-model="amount">
              </div>
              <p class="item-readme">这将作为你的账号用于登录</p>
            </div>

            <div class="register-form-input-item">
              <label for="register-password">密码 <span>*</span></label>
              <input type="password" id="register-password" name="password" v-model="password">
            </div>

            <div class="register-form-input-item">
              <label for="register-password-sure">确定密码 <span>*</span></label>
              <input type="password" id="register-password-sure" name="password-sure" v-model="passwordSure">
            </div>

            <div class="register-form-input-item">
              <label for="register-username">用户名 <span>*</span></label>
              <input type="text" id="register-username" name="username" v-model="username">
              <p class="item-readme">这将作为你在本论坛显示的名称。选择任意你喜欢的名称吧！</p>
            </div>

            <div class="register-form-input-item">
              <label for="register-email">邮箱 <span>*</span></label>
              <input type="email" id="register-email" name="email" v-model="email">
            </div>

            <div class="register-form-input-item">
              <label for="register-phoneNumber">手机号 <span>*</span></label>
              <input type="tel" id="register-phoneNumber" name="phoneNumber" v-model="phoneNumber">
            </div>

            <div class="register-form-input-item">
              <label for="register-referrer">推荐人 </label>
              <input type="text" id="register-referrer" name="referrer" v-model="referrer">
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
                <input type="checkbox" id="negotiate" name="negotiate" >
                <label for="negotiate">我同意 <a href="#">用户条款</a> 和 <a href="#">隐私协议</a> </label>
              </div>

              <div class="register-form-check-item">
                <input type="checkbox" id="rules" name="rules" >
                <label for="rules">我自愿遵守本论坛 <a href="#">用户行为规范</a> </label>
              </div>
            </div>


            <div class="register-form-button-item">
              <input type="button" value="注册" @click="test">
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
      amount: '',
      password: '',
      passwordSure: '',
      username: '',
      email: '',
      phoneNumber: '',
      referrer: '',
      problemVerification: ''
    }
  },
  methods:{
    test(){
      console.log(this.amount);
      console.log(this.password);
      console.log(this.passwordSure);
      console.log(this.username);
      console.log(this.email);
      console.log(this.phoneNumber);
      console.log(this.referrer);
      console.log(this.problemVerification);
    }
  }
}
</script>

<style scoped>
.register-page-content-container {
  max-width: 1200px;
  margin: 80px auto 80px;
  height: 900px;

  //background: #7db92e;
}

.register-page-content-header {
  width: 100%;

  //background: #00bd7e;
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

  //background: #cc4242;
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
</style>