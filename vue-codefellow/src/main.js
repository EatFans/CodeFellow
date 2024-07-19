import { createApp } from 'vue'
import App from './App.vue'
import router from "@/router/index.js";
import store from "@/store/index.js";
import axios from 'axios';
import authAPI from "@/api/AuthAPI.js";
import userAPI from './api/UserAPI';

const app = createApp(App);

// 排除自定义元素的组件解析

app.config.globalProperties.$axios = axios;
app.config.globalProperties.$authAPI = authAPI;
app.config.globalProperties.$userAPI = userAPI;

// 初始化数据
Promise.all([
    store.dispatch('user/initializeUser'),  // 初始化 user 状态模块

  ]).then(() => {
    // 使用路由和 Vuex Store
    app.use(router);
    app.use(store);
    // 挂载 Vue 实例
    app.mount('#app');
  }).catch(error => {
    console.error("初始化数据时发生错误: ", error);
    

  });
