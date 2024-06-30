// Vuex Store 状态
import { createStore } from "vuex";
import settings from "@/store/modules/settings.js";
import user from "./modules/user";

const store = createStore({
    modules: {
        settings,
        user
    }
});

export default store