<!-- 帖子页面 -->
<template>
  <HeaderBar />
  <PostPageContent />
  <Footer />
</template>

<script>
import HeaderBar from "@/components/HeaderBar.vue";
import Footer from "@/components/Footer.vue";
import PostPageContent from "@/layouts/postPage/PostPageContent.vue";

export default {
  name: "PostPage",
  components: {PostPageContent, Footer, HeaderBar},
  data(){
    return {
      post:{}
    }
  },
  created() {
    document.title = "测试帖子标题";
  }
}
</script>

<style scoped>

</style>