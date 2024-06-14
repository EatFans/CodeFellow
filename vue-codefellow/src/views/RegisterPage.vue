<!-- 注册页面 -->
<template>
  <HeaderBar />
  <div class="register-page-container">

  </div>
  <Footer />
</template>

<script>
import HeaderBar from "@/components/HeaderBar.vue";
import Footer from "@/components/Footer.vue";

export default {
  name: 'RegisterPage',
  components: {
    HeaderBar,
    Footer

  }
}
</script>

<style scoped>
.register-page-container {
  height: 1000px;
}
</style>