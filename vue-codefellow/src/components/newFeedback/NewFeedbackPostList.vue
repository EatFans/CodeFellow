<!-- 帖子显示列表容器组件 -->
<template>
  <div class="post-list-container">
    <!-- 置顶帖子区域 -->
    <div class="pinned-post-list-container">
      <!-- 置顶帖子标题头部栏 -->
      <ContentTitle title="置顶帖子" />
      <div class="pinned-post-list-content">
        <Post title="测试帖子标题1" />
        <Post title="测试帖子标题2" />
        <Post title="测试帖子标题3" />
        <Post title="测试帖子标题4" />
        <Post title="测试帖子标题5" />
      </div>
    </div>
    <!-- 普通帖子区域 -->
    <div class="post-list-container">
      <!-- 普通帖子标题头部栏 -->
      <ContentTitle title="普通帖子" />
      <div class="post-list-content">
        <Post title="测试帖子标题1" />
        <Post title="测试帖子标题2" />
        <Post title="测试帖子标题3" />
        <Post title="测试帖子标题4" />
        <Post title="测试帖子标题5" />
        <Post title="测试帖子标题6" />
        <Post title="测试帖子标题7" />
        <Post title="测试帖子标题8" />
        <Post title="测试帖子标题9" />
        <Post title="测试帖子标题10" />
      </div>
    </div>
  </div>
</template>

<script>
import ContentTitle from "@/components/ContentTitle.vue";
import Post from "@/components/Post.vue";
export default {
  components:{
    Post,
    ContentTitle,
  }
}
</script>

<style scoped>
.pinned-post-list-content {
  margin-top: 10px;
}
.post-list-content {
  margin-top: 10px;
}
</style>