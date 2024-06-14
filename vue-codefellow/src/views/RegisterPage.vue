<!-- 注册页面 -->
<template>
  <HeaderBar />
  <RegisterPageContent />
  <Footer />
</template>

<script>
import HeaderBar from "@/components/HeaderBar.vue";
import Footer from "@/components/Footer.vue";
import RegisterPageContent from "@/layouts/registerPage/RegisterPageContent.vue";

export default {
  name: 'RegisterPage',
  components: {
    HeaderBar,
    Footer,
    RegisterPageContent

  }
}
</script>

<style scoped>
.register-page-container {
  height: 1000px;
}
</style>