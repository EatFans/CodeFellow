  // src/store/modules/auth.js

  import axios from 'axios';
  import authAPI from '@/api/AuthAPI';
  import userAPI from '@/api/UserAPI';

  const state = {
    // 用户资料，存储用户的所有信息
    userProfile: {
      profileId: null,
      userUuid: null,
      username: null,
      avatarUrl: null,
      gender: null,
      experience: null,
      level: null,
      officialCertification: null,
      identity: null,
      bio: null,
      company: null,
      location: null,
      email: null,
      link: null
    },
    // 是否登录
    isLogin: JSON.parse(localStorage.getItem('isLogin')) || false,
    // 登录令牌
    token: localStorage.getItem('token') || ''
  };

  const getters = {
    // 获取用户资料
    getUserProfile: (state) => state.userProfile,
    // 获取登录状态
    getIsLogin: (state) => state.isLogin,
    // 获取令牌
    getToken: (state) => state.token
  };

  const mutations = {
    // 设置用户资料
    SET_USER_PROFILE(state, profile) {
      state.userProfile = profile;
    },
    // 设置登录状态
    SET_IS_LOGIN(state, status) {
      state.isLogin = status;
      localStorage.setItem('isLogin', JSON.stringify(status));
    },
    // 设置令牌
    SET_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
    },
    // 清除登录状态
    CLEAR_AUTH(state) {
      state.userProfile = {};
      state.isLogin = false;
      state.token = '';
      localStorage.removeItem('token');
      localStorage.removeItem('isLogin');
    }
  };
  



  const actions = {
    // 初始化用户资料
    async initializeUser({ commit }) {
      const token = localStorage.getItem('token');
      if (token) {
        const verifyLoginTokenData = { token }; // 组装对象
        await verifyToken(commit, verifyLoginTokenData);
        // 如果验证令牌失效isLogin会变成false
        // 如果isLogin为true，说明现在是状态为保持登录，发送请求获取用户资料数据并保存
        if (state.isLogin){
          await initUserProfileData(commit,verifyLoginTokenData);
        }

      } else {
        commit('SET_IS_LOGIN', false);
        console.log("本地没有token令牌，未登录！");
        
      }

      console.log("+++++++++++++++++++++++++++++++++");
      console.log(" ");
    },
    // 用户登录
    async login({ commit }, credentials) {
      try {
        const response = await axios.post('/api/auth/login', credentials);
        const token = response.data.token;
        commit('SET_TOKEN', token);
        await dispatch('initializeAuth');
      } catch (error) {
        console.error('登录失败:', error);
      }
    },
    // 用户登出
    logout({ commit }) {
      commit('CLEAR_AUTH');
    }
  };

  // 验证令牌并更新登录状态
  async function verifyToken(commit, verifyLoginTokenData) {
    try {
      const response = await authAPI.verifyLoginToken(verifyLoginTokenData); // 发送验证令牌请求
      const { status, message } = response.data;

      if (status === 'success') {
        commit('SET_IS_LOGIN', true);
        console.log(message);
      } else {
        commit('SET_IS_LOGIN', false);
        console.log(message);
      }
    } catch (error) {
      console.error('验证令牌失败:', error);
      commit('SET_IS_LOGIN', false);
    }
  }

  // 发送请求获取数据，初始化数据状态
  async function initUserProfileData(commit,verifyLoginTokenData){
    try {
      const response = await userAPI.getUserProfile(verifyLoginTokenData);
      const {status,message,data } = response.data;
      
      console.log("请求到的用户资料数据为：");
      console.log(response.data);

      if (status == 'success'){
        commit('SET_USER_PROFILE',data);
        console.log(message);
      }
      if (status == 'error'){
        console.log(message);
      }
    } catch (error) {
      console.error('数据初始化失败！原因：'+error);
    }
  }

  export default {
    namespaced: true,
    state,
    getters,
    mutations,
    actions
  };
