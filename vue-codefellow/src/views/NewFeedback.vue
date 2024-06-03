<!-- 社区公告与反馈版块页面 -->
<template>
  <HeaderBar />
  <div class="section-content-container">

  </div>
  <Footer />
</template>

<script>
import HeaderBar from "@/components/HeaderBar.vue";
import Footer from "@/components/Footer.vue";
export default {
  components: {
    HeaderBar,
    Footer,
  },
  data() {
    return {
      // 定义你的数据
    };
  },
  methods: {
    // 定义你的方法
  }
};
</script>

<style scoped>
.section-content-container {
  height: 3000px;
  max-width: 1200px;
  margin: 60px auto 100px;
  background: #7db92e;
}
</style>