// Vuex Store 状态
import { createStore } from "vuex";
import settings from "@/store/modules/settings.js";

const store = createStore({
    modules: {
        settings,
    }
});

export default store