import { createRouter,createWebHistory } from "vue-router";

import ForumHomeContent from "@/views/ForumHomeContent.vue";
import Test from "@/views/Test.vue"

// 创建路由
const router = createRouter({
    history:createWebHistory(),
    routes:[
        {
            path:"/",
            component: ForumHomeContent
        },
        {
            path:"/test",
            component:Test
        }
    ]
});

// 暴露路由
export default router;
