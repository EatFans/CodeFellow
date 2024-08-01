import { createRouter,createWebHistory } from "vue-router";

import ForumHome from "@/views/ForumHomePage.vue";
import NewFeedback from "@/views/NewFeedbackPage.vue"
import DonatePage from "@/views/DonatePage.vue";
import EggPage1 from "@/views/EggPage1.vue"
import Test from "@/views/Test.vue";
import RegisterPage from "@/views/RegisterPage.vue";
import CommunicationPage from "@/views/CommunicationPage.vue";
import PostPage from "@/views/PostPage.vue";
import BlogPage from "@/views/BlogPage.vue";
import ResourcePage from "@/views/ResourcePage.vue";
import ProjectPage from "@/views/ProjectPage.vue";
import RankingListPage from "@/views/RankingListPage.vue";
import ToolPage from "@/views/ToolPage.vue";

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
            // 博客页面
            path: "/blog",
            component: BlogPage,
            meta: {
                title: '博客中心 | CodeFellow 开发者交流论坛'
            }
        },
        {
            // 资源中心页面
            path: "/resource",
            component: ResourcePage,
            meta: {
                title: '资源中心 | CodeFellow 开发者论坛'
            }
        },
        {
            // 项目中心页面
            path: "/project",
            component: ProjectPage,
            meta: {
                title: '项目中心 | CodeFellow 开发者论坛'
            }
        },
        {
            // 排行榜页面
            path: "/ranking-list",
            component: RankingListPage,
            meta: {
                title: '排行榜 | CodeFellow 开发者论坛'
            }
        },
        {
            // 工具页面
            path: "/tool",
            component: ToolPage,
            meta: {
                title: '工具 | CodeFellow 开发者论坛'
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
            // 社区公告与反馈 帖子页面
            path:"/post/:sectionType/:postUuid",
            name: "Post",
            component: PostPage,
        },
        {
            path: "/forum/communication",
            component: CommunicationPage,
            meta: {
                title: '新手报到与交流 | CodeFellow 开发者交流论坛'
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

