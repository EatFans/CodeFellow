<template>
  <div class="main-container">
    <!-- 动态粒子特效 -->
    <div class="bubbles">
      <span style="--i:11;"></span>
      <span style="--i:12;"></span>
      <span style="--i:24;"></span>
      <span style="--i:10;"></span>
      <span style="--i:14;"></span>
      <span style="--i:23;"></span>
      <span style="--i:18;"></span>
      <span style="--i:16;"></span>
      <span style="--i:19;"></span>
      <span style="--i:20;"></span>
      <span style="--i:22;"></span>
      <span style="--i:25;"></span>
      <span style="--i:18;"></span>
      <span style="--i:21;"></span>
      <span style="--i:15;"></span>
      <span style="--i:13;"></span>
      <span style="--i:26;"></span>
      <span style="--i:17;"></span>
      <span style="--i:13;"></span>
      <span style="--i:28;"></span>
      <span style="--i:11;"></span>
      <span style="--i:12;"></span>
      <span style="--i:24;"></span>
      <span style="--i:10;"></span>
      <span style="--i:14;"></span>
      <span style="--i:23;"></span>
      <span style="--i:18;"></span>
      <span style="--i:16;"></span>
      <span style="--i:19;"></span>
      <span style="--i:20;"></span>
      <span style="--i:22;"></span>
      <span style="--i:25;"></span>
      <span style="--i:18;"></span>
      <span style="--i:21;"></span>
      <span style="--i:15;"></span>
      <span style="--i:13;"></span>
      <span style="--i:26;"></span>
      <span style="--i:17;"></span>
      <span style="--i:13;"></span>
      <span style="--i:28;"></span>
      <span style="--i:11;"></span>
      <span style="--i:12;"></span>
      <span style="--i:24;"></span>
      <span style="--i:10;"></span>
      <span style="--i:14;"></span>
      <span style="--i:23;"></span>
      <span style="--i:18;"></span>
      <span style="--i:16;"></span>
      <span style="--i:19;"></span>
      <span style="--i:20;"></span>
      <span style="--i:22;"></span>
      <span style="--i:25;"></span>
      <span style="--i:18;"></span>
      <span style="--i:21;"></span>
      <span style="--i:15;"></span>
      <span style="--i:13;"></span>
      <span style="--i:26;"></span>
      <span style="--i:17;"></span>
      <span style="--i:13;"></span>
      <span style="--i:28;"></span>
    </div>
    <div class="main-content">
      <div class="container" :class="{ 'right-panel-active': isRightPanelActive }">
        <!-- 登录 -->
        <div class="container__form container--signup">
          <form @submit.prevent="handleSignUp" class="form" id="form1">
            <h2 class="form__title">管理控制台账户申请</h2>
            <label>
              <input type="text" placeholder="账户" class="input" v-model="signUpUser" />
              <input type="email" placeholder="邮箱" class="input" v-model="signUpEmail" />
              <input type="password" placeholder="密码" class="input" v-model="signUpPassword" />
              <input type="text" placeholder="授权码" class="input" v-model="signUpToken" />
            </label>
            <a href="https://eatfans.github.io" class="getToken">获取授权码</a>
            <button type="submit" class="btn">注册</button>
          </form>
        </div>

        <!--  -->
        <div class="container__form container--signin">
          <form @submit.prevent="handleSignIn" class="form" id="form2">
            <h2 class="form__title">管理控制台登录</h2>
            <label>
              <input type="text" placeholder="账户" class="input" v-model="signInUser" />
              <input type="email" placeholder="邮箱" class="input" v-model="signInEmail"/>
              <input type="password" placeholder="密码" class="input" v-model="signInPassword" />
            </label>
            <a href="#" class="link">忘了密码?</a>
            <button type="submit" class="btn">登录</button>
          </form>
        </div>

        <!-- 覆盖 -->
        <div class="container__overlay">
          <div class="overlay">
            <div class="overlay__panel overlay--left">
              <button class="btn" @click="togglePanel(false)">登录</button>
            </div>
            <div class="overlay__panel overlay--right">
              <button class="btn" @click="togglePanel(true)">账户申请</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      isRightPanelActive: false,
      signInUser: '',
      signInEmail: '',
      signInPassword: '',
      signUpUser: '',
      signUpEmail: '',
      signUpPassword: '',
      signUpToken: ''
    };
  },
  methods: {
    togglePanel(isSignUp) {
      this.isRightPanelActive = isSignUp;
    },
    handleSignIn() {
      // 处理登录逻辑
      console.log('登录', this.signInUser, this.signInEmail,this.signInPassword);
    },
    handleSignUp() {
      // 处理注册逻辑
      console.log('注册', this.signUpUser, this.signUpEmail, this.signUpPassword, this.signUpToken);
    }
  }
};
</script>

<style scoped>
.main-container {
  background-color: #0c192c;
}

.main-content {
  align-items: center;
  background-attachment: fixed;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  display: grid;
  height: 100vh;
  place-items: center;
}

.form__title {
  font-weight: 300;
  margin: 0;
  margin-bottom: 1.25rem;
}

.link {
  color: #333;
  font-size: 0.9rem;
  margin: 1.5rem 0;
  text-decoration: none;
}

.container {
  background-color: #e9e9e9;
  border-radius: 0.7rem;
  box-shadow: 0 0.9rem 1.7rem rgba(0, 0, 0, 0.25), 0 0.7rem 0.7rem rgba(0, 0, 0, 0.22);
  height: 420px;
  max-width: 758px;
  overflow: hidden;
  position: relative;
  width: 100%;
}

.container__form {
  height: 100%;
  position: absolute;
  top: 0;
  transition: all 0.6s ease-in-out;
}

.container--signin {
  left: 0;
  width: 50%;
  z-index: 2;
}

.container.right-panel-active .container--signin {
  transform: translateX(100%);
}

.container--signup {
  left: 0;
  opacity: 0;
  width: 50%;
  z-index: 1;
}

.container.right-panel-active .container--signup {
  animation: show 0.6s;
  opacity: 1;
  transform: translateX(100%);
  z-index: 5;
}

.container__overlay {
  height: 100%;
  left: 50%;
  overflow: hidden;
  position: absolute;
  top: 0;
  transition: transform 0.6s ease-in-out;
  width: 50%;
  z-index: 100;
}

.container.right-panel-active .container__overlay {
  transform: translateX(-100%);
}

.overlay {
  background-color: #008997;
  background: url("https://cdn.pixabay.com/photo/2018/08/14/13/23/ocean-3605547_1280.jpg");
  background-attachment: fixed;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  height: 100%;
  left: -100%;
  position: relative;
  transform: translateX(0);
  transition: transform 0.6s ease-in-out;
  width: 200%;
}

.container.right-panel-active .overlay {
  transform: translateX(50%);
}

.overlay__panel {
  align-items: center;
  display: flex;
  flex-direction: column;
  height: 100%;
  justify-content: center;
  position: absolute;
  text-align: center;
  top: 0;
  transform: translateX(0);
  transition: transform 0.6s ease-in-out;
  width: 50%;
}

.overlay--left {
  transform: translateX(-20%);
}

.container.right-panel-active .overlay--left {
  transform: translateX(0);
}

.overlay--right {
  right: 0;
  transform: translateX(0);
}

.container.right-panel-active .overlay--right {
  transform: translateX(20%);
}

.btn {
  background-color: #0367a6;
  background-image: linear-gradient(90deg, #0367a6 0%, #008997 74%);
  border-radius: 20px;
  border: 1px solid #0367a6;
  color: #e9e9e9;
  cursor: pointer;
  font-size: 0.8rem;
  font-weight: bold;
  letter-spacing: 0.1rem;
  padding: 0.9rem 4rem;
  text-transform: uppercase;
  transition: transform 80ms ease-in;
}

.form>.btn {
  margin-top: 1.5rem;
}

.btn:active {
  transform: scale(0.95);
}

.btn:focus {
  outline: none;
}

.form {
  background-color: #e9e9e9;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  padding: 0 3rem;
  height: 100%;
  text-align: center;
}

.input {
  background-color: #fff;
  border: none;
  padding: 0.9rem 0.9rem;
  margin: 0.5rem 0;
  width: 100%;
}

.getToken {
  color: #333;
  font-size: 0.9rem;
  text-decoration: none;
}

@keyframes show {
  0%, 49.99% {
    opacity: 0;
    z-index: 1;
  }

  50%, 100% {
    opacity: 1;
    z-index: 5;
  }
}

/* 动态粒子特效背景样式 */
.main-container {
  position: relative;
  width: 100%;
  height: 100vh;
  overflow: hidden;
}

.bubbles {
  position: relative;
  display: flex;
}

.bubbles span {
  position: relative;
  width: 30px;
  height: 30px;
  background: #4fc3dc;
  margin: 0 4px;
  border-radius: 50%;
  box-shadow: 0 0 0 10px #4fc3dc44,
  0 0 50px #4fc3dc,
  0 0 100px #4fc3dc;
  animation: animate 15s linear infinite;
  animation-duration: calc(125s / var(--i));
}

.bubbles span:nth-child(even){
  background: #ff2d75;
  box-shadow: 0 0 0 10px #ff2d7544,
  0 0 50px #ff2d75,
  0 0 100px #ff2d75;
}

@keyframes animate {
  0%{
    transform: translateY(100vh) scale(0);
  }
  100% {
    transform: translateY(-10vh) scale(1);
  }
}
</style>
