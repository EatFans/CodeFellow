// api/UserAPI.js
import axios from 'axios';

const baseURL = 'http://localhost:8080/user'; // 根据实际后端地址修改

const axiosInstance = axios.create({
  baseURL,
  timeout: 10000 // 超时时间
});

const authAPI = {
  // 获取用户资料接口
  getUserProfile(verifyLoginTokenData) {
    return axiosInstance.post('/getUserProfile', verifyLoginTokenData);
  }
};

export default authAPI;
