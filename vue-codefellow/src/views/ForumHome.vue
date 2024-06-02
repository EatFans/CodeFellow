<!-- 论坛主页页面 -->
<template>
  <HeaderBar  />
  <ForumHomeContent />
  <Footer />
</template>

<script>
import HeaderBar from "@/components/HeaderBar.vue";
import Footer from "@/components/Footer.vue";
import ForumHomeContent from "@/components/home/ForumHomeContent.vue";

export default {
  components: {
    HeaderBar,
    Footer,
    ForumHomeContent
  }
}

</script>

<style scoped>

</style>