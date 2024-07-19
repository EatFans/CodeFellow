
<template>
  <div class="post-page-content-container">
    <h1>这个测试帖子id为 {{this.$route.params.postId}}</h1>
  </div>
</template>

<script>
export default {
  name: "PostPageContent"
}
</script>

<style scoped>
.post-page-content-container {
  max-width: 1200px;
  margin: 60px auto 100px;
  height: 1000px;
}
</style>