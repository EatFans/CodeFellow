<!-- 为爱发电页面  -->
<template>
  <HeaderBar />
  <DonateContent />
  <Footer />
</template>

<script>
import HeaderBar from "@/components/HeaderBar.vue";
import Footer from "@/components/Footer.vue";
import DonateContent from "@/layouts/donate/DonateContent.vue";
export default {
  name: 'DonatePage',
  components: {
    HeaderBar,
    Footer,
    DonateContent
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