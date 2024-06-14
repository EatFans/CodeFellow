// 用户在网站上的设置

const state = {
    leftNavVisible: '',
    theme: 'light',

};

const mutations = {
    setLeftNavVisible(state, visible){
        state.leftNavVisible = visible;
    }
};

const actions = {
    updateLeftNavVisible({ commit }, visible) {
        commit('setLeftNavVisible',visible);
    }
};

const getters = {

};

export default {
    namespaced: true,
    state,
    mutations,
    actions,
    getters
};
