<!-- 帖子显示列表容器组件 -->
<template>
  <div class="post-list-container">
    <!-- 置顶帖子区域 -->
    <div class="pinned-post-list-container">
      <!-- 置顶帖子标题头部栏 -->
      <ContentTitle title="置顶帖子" />
      <div class="pinned-post-list-content">
        <Post title="测试标题1" :labels="['公告']" />
      </div>
    </div>
    <!-- 普通帖子区域 -->
    <div class="post-list-container">
      <!-- 普通帖子标题头部栏 -->
      <ContentTitle title="普通帖子" />
      <div class="post-list-content">
        <Post title="测试标题2" :labels="['原创','C++','开源']" />
        <Post title="测试标题3" :labels="['转载','Python']" />
        <Post title="测试标题4" :labels="['原创']" />
        <Post title="测试标题5" :labels="['原创']" />
        <Post title="测试帖子标题10" :labels="['原创','Spring']"/>
        <Post title="测试帖子标题10" :labels="['转载','QT']"/>
        <Post title="测试帖子标题10" :labels="['转载','SpringBoot']"/>
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