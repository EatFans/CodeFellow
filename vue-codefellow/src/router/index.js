import { createRouter,createWebHistory } from "vue-router";

import ForumHome from "@/views/ForumHome.vue";
import EggPage1 from "@/views/EggPage1.vue"

// 创建路由
const router = createRouter({
    history:createWebHistory(),
    routes:[
        {
            path:"/",
            component: ForumHome
        },
        {
            // 菜单页面
            path:"/admin",
            component:EggPage1
        }
    ]
});

// 暴露路由
export default router;
