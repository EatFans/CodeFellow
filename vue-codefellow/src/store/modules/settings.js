// 用户在网站上的偏好设置

const state = {
    leftNavVisible: JSON.parse(sessionStorage.getItem('leftNavVisible')) !== null ? JSON.parse(sessionStorage.getItem('leftNavVisible')) : true,
    node1Visible: JSON.parse(sessionStorage.getItem('node1Visible')) !== null ? JSON.parse(sessionStorage.getItem('node1Visible')) : true,
    node2Visible: JSON.parse(sessionStorage.getItem('node2Visible')) !== null ? JSON.parse(sessionStorage.getItem('node2Visible')) : true,
    node3Visible: JSON.parse(sessionStorage.getItem('node3Visible')) !== null ? JSON.parse(sessionStorage.getItem('node3Visible')) : true,
    node4Visible: JSON.parse(sessionStorage.getItem('node4Visible')) !== null ? JSON.parse(sessionStorage.getItem('node4Visible')) : true,
    node5Visible: JSON.parse(sessionStorage.getItem('node5Visible')) !== null ? JSON.parse(sessionStorage.getItem('node5Visible')) : true,
    node6Visible: JSON.parse(sessionStorage.getItem('node6Visible')) !== null ? JSON.parse(sessionStorage.getItem('node6Visible')) : true,
    node7Visible: JSON.parse(sessionStorage.getItem('node7Visible')) !== null ? JSON.parse(sessionStorage.getItem('node7Visible')) : true,
    theme: 'light',

};

const getters = {
    // 获取左侧导航栏是否显示标识
    getLeftNavVisible: (state) => state.leftNavVisible,
    // 获取论坛主页版块各节点显示标识
    getNode1Visible: (state) => state.node1Visible,
    getNode2Visible: (state) => state.node2Visible,
    getNode3Visible: (state) => state.node3Visible,
    getNode4Visible: (state) => state.node4Visible,
    getNode5Visible: (state) => state.node5Visible,
    getNode6Visible: (state) => state.node6Visible,
    getNode7Visible: (state) => state.node7Visible,
}

const mutations = {
    // 设置左侧导航栏显示标识
    SET_LEFT_NAV_VISIBLE(state, visible){
        state.leftNavVisible = visible;
        sessionStorage.setItem('leftNavVisible',JSON.stringify(visible));
    },
    // 设置论坛主页版块节点1显示标识
    SET_NODE_1_VISIBLE(state, visible) {
        state.node1Visible = visible;
        sessionStorage.setItem('node1Visible',JSON.stringify(visible));
    },
    // 设置论坛主页版块节点2显示标识
    SET_NODE_2_VISIBLE(state,visible) {
        state.node2Visible = visible;
        sessionStorage.setItem('node2Visible',JSON.stringify(visible));
    },
    // 设置论坛主页版块节点3显示标识
    SET_NODE_3_VISIBLE(state,visible) {
        state.node3Visible = visible;
        sessionStorage.setItem('node3Visible',JSON.stringify(visible));
    },
    // 设置论坛主页版块节点4显示标识
    SET_NODE_4_VISIBLE(state,visible) {
        state.node4Visible = visible;
        sessionStorage.setItem('node4Visible',JSON.stringify(visible));
    },
    // 设置论坛主页版块节点5显示标识
    SET_NODE_5_VISIBLE(state,visible) {
        state.node5Visible = visible;
        sessionStorage.setItem('node5Visible',JSON.stringify(visible));
    },
    // 设置论坛主页版块节点6显示标识
    SET_NODE_6_VISIBLE(state,visible) {
        state.node6Visible = visible;
        sessionStorage.setItem('node6Visible',JSON.stringify(visible));
    },
    // 设置论坛主页版块节点7显示标识
    SET_NODE_7_VISIBLE(state,visible) {
        state.node7Visible = visible;
        sessionStorage.setItem('node7Visible',JSON.stringify(visible));
    }
};

const actions = {
    // 初始化偏好设置
    initializeSettings({ commit }) {


    }
};



export default {
    namespaced: true,
    state,
    mutations,
    actions,
    getters
};
