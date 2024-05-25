<!-- 论坛主页页面组件  -->
<template>
  <HeaderBar />
  <ForumHomeContent />
  <Footer />
</template>

<script>
import HeaderBar from "@/components/HeaderBar.vue";
import Footer from "@/components/Footer.vue";
import ForumHomeContent from "@/components/ForumHomeContent.vue";

export default {
  components: {
    HeaderBar,
    ForumHomeContent,
    Footer
  }
}

</script>

<style scoped>

</style>