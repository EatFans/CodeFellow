// api/AuthAPI.js
import axios from 'axios';

const baseURL = 'http://localhost:8080/auth'; // 根据实际后端地址修改

const axiosInstance = axios.create({
  baseURL,
  timeout: 10000 // 超时时间
});

const authAPI = {
  // 登录接口
  login(credentials) {
    return axiosInstance.post('/login', credentials);
  },
  // 注册接口
  register(registerData){
    return axiosInstance.post('/register',registerData);
  },
  // 验证登录token接口
  verifyLoginToken(verifyLoginTokenData){
    return axiosInstance.post('/verify-login-token',verifyLoginTokenData)
  }
};

export default authAPI;
