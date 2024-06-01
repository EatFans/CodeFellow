<!-- 底部栏 -->
<template>
  <div class="footer">

  </div>
</template>

<script>
import '@/assets/theme.css';


export default {
  computed: {
    // 从 Vuex 中获取当前主题状态

  },

  data() {
    return {

    }
  },
  methods: {

  }
}

</script>

<style scoped>
.footer {
  position: relative;
  bottom: 0;
  left: 0;
  height: 200px;
  width: 100%;
  background-color: var(--footer-bar-color);
}
</style>
