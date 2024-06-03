import { createRouter,createWebHistory } from "vue-router";

import ForumHome from "@/views/ForumHome.vue";
import NewFeedback from "@/views/NewFeedback.vue"

import EggPage1 from "@/views/EggPage1.vue"
import AdminAuth from "@/views/AdminAuth.vue";

// 创建路由
const router = createRouter({
    history:createWebHistory(),
    routes:[
        {
            path:"/",
            component: ForumHome
        },
        {
            path:"/forum",
            component: ForumHome
        },
        {
            // 社区公告与反馈 页面
            path:"/news-feedback",
            component: NewFeedback
        },
        {
            // 为爱发电捐献页面
            path:"/donate",
            component: ForumHome
        },
        {
            path:"/94af9f02-de89-44bf-87b7-e6d764018299",
            component: AdminAuth
        },
        {
            // admin彩蛋页面
            path:"/admin",
            component:EggPage1
        },
    ]
});

// 暴露路由
export default router;

