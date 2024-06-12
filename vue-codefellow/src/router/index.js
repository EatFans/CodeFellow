import { createRouter,createWebHistory } from "vue-router";

import ForumHome from "@/views/ForumHome.vue";
import NewFeedback from "@/views/NewFeedback.vue"
import DonatePage from "@/views/DonatePage.vue";
import EggPage1 from "@/views/EggPage1.vue"
import Test from "@/views/Test.vue";

// 创建路由
const router = createRouter({
    history:createWebHistory(),
    routes:[
        {
            path:"/",
            component: ForumHome
        },
        {
            // 注册页面
            path:"/register",
            component: ForumHome
        },
        {
            path:"/forum",
            component: ForumHome
        },
        {
            // 社区公告与反馈 页面
            path:"/forum/news-feedback",
            component: NewFeedback
        },
        {
            // 为爱发电捐献页面
            path:"/donate",
            component: DonatePage
        },
        {
            // admin彩蛋页面
            path:"/admin",
            component:EggPage1
        },
        {
            path: "/test",
            component: Test
        }
    ]
});

// 暴露路由
export default router;

