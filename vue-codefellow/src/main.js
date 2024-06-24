import { createApp } from 'vue'
import App from './App.vue'
import router from "@/router/index.js";
import store from "@/store/index.js";
import axios from 'axios';
import authAPI from "@/api/authAPI.js";


const app = createApp(App);

app.config.globalProperties.$axios = axios;
app.config.globalProperties.$authAPI = authAPI;

app.use(router);
app.use(store);
app.mount('#app');
