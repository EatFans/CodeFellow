import { createRouter,createWebHistory } from "vue-router";

import ForumHome from "@/views/ForumHome.vue";
import NewFeedback from "@/views/NewFeedback.vue"
import DonatePage from "@/views/DonatePage.vue";
import EggPage1 from "@/views/EggPage1.vue"
import Test from "@/views/Test.vue";
import RegisterPage from "@/views/RegisterPage.vue";

// 创建路由
const router = createRouter({
    history:createWebHistory(),
    routes:[
        {
            path:"/",
            component: ForumHome,

        },
        {
            // 注册页面
            path:"/register",
            component: RegisterPage,
            meta: {
                title: '注册 | CodeFellow 开发者交流论坛'
            }
        },
        {
            // 论坛主页
            path:"/forum",
            component: ForumHome,
            meta: {
                title: '主页 | CodeFellow 开发者交流论坛'
            }
        },
        {
            // 社区公告与反馈 页面
            path:"/forum/news-feedback",
            component: NewFeedback,
            meta: {
                title: '社区公告与反馈 | CodeFellow 开发者交流论坛'
            }
        },
        {
            // 为爱发电捐献页面
            path:"/donate",
            component: DonatePage,
            meta: {
                title: '为爱发电 | CodeFellow 开发者交流论坛'
            }
        },
        {
            // admin彩蛋页面
            path:"/admin",
            component:EggPage1,
            meta: {
                title: 'Qwq 你在干什么'
            }
        },
        {
            path: "/test",
            component: Test
        }
    ]
});

router.beforeEach((to, from, next) => {
    /* 路由发生变化修改页面title */
    if (to.meta.title) {
        document.title = to.meta.title
    }
    next()
})

// 暴露路由
export default router;

