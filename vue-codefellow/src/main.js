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

app.use(router);
app.use(store);
app.mount('#app');
