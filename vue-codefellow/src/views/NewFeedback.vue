<!-- 社区公告与反馈版块页面 -->
<template>
  <HeaderBar />
  <NewFeedbackContent />
  <Footer />
</template>

<script>
import HeaderBar from "@/components/HeaderBar.vue";
import Footer from "@/components/Footer.vue";
import NewFeedbackContent from "@/layouts/newFeedback/NewFeedbackContent.vue"
export default {
  name: 'NewFeedback',
  components: {
    HeaderBar,
    Footer,
    NewFeedbackContent
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

</style>