<!-- 论坛主页页面组件  -->
<template>
  <HeaderBar />
<!--  TODO:左边侧边栏宽度208px -->
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