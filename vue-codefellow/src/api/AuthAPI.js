// api/AuthAPI.js
import axios from 'axios';

const baseURL = 'http://localhost:8080/auth'; // 根据实际后端地址修改

const axiosInstance = axios.create({
  baseURL,
  timeout: 10000 // 超时时间
});

const authAPI = {
  login(credentials) {
    return axiosInstance.post('/login', credentials);
  },
  register(registerData){
    return axiosInstance.post('/register',registerData);
  }
};

export default authAPI;
