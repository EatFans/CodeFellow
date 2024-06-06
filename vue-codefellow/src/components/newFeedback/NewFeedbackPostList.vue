<!-- 帖子显示列表容器组件 -->
<template>
  <div class="post-list-container">
    <!-- 置顶帖子区域 -->
    <div class="pinned-post-list-container">
      <!-- 置顶帖子标题头部栏 -->
      <ContentTitle title="置顶帖子" />
      <div class="pinned-post-list-content">
        <Post :post-data="postData1" />
      </div>
    </div>
    <!-- 普通帖子区域 -->
    <div class="post-list-container">
      <!-- 普通帖子标题头部栏 -->
      <ContentTitle title="普通帖子" />
      <div class="post-list-content">
        <Post :post-data="postData2" />
        <Post :post-data="postData3" />
        <Post :post-data="postData4" />
        <Post :post-data="postData5" />
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
  },
  data() {
    return {
      postData1: {
        title: "示例公告帖子标题",
        labels: ["公告"],
        postAuthorAvatar: "https://avatars.githubusercontent.com/u/122099628?v=4",
        postAuthorName: "EatFan",
        postReadme: "这是一个测试的公告帖子，我也不知道写什么，所以我就随便写写写写写写写写写.....................",
        postLikeAmount: 999,
        postDislikeAmount: 999,
        postDate: "2024/6/5",
        postCover: "/images/cover.jpg"
      },
      postData2: {
        title: "示例普通帖子标题",
        labels: ["原创","Java","开源"],
        postAuthorAvatar: "https://avatars.githubusercontent.com/u/122099628?v=4",
        postAuthorName: "EatFan",
        postReadme: "这是一个测试的普通帖子，我也不知道写什么，所以我就随便写写写写写写写写写，阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴",
        postLikeAmount: 999,
        postDislikeAmount: 999,
        postDate: "2024/6/5",
        postCover: "/images/cover.jpg"
      },
      postData3: {
        title: "示例普通帖子标题",
        labels: ["转载","C++","QT"],
        postAuthorAvatar: "https://avatars.githubusercontent.com/u/122099628?v=4",
        postAuthorName: "EatFan",
        postReadme: "这是一个测试的普通帖子，我也不知道写什么，所以我就随便写写写写写写写写写，阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴",
        postLikeAmount: 999,
        postDislikeAmount: 999,
        postDate: "2024/6/5",
        postCover: "/images/cover.jpg"
      },
      postData4: {
        title: "示例普通帖子标题",
        labels: ["原创","Spring"],
        postAuthorAvatar: "https://avatars.githubusercontent.com/u/122099628?v=4",
        postAuthorName: "EatFan",
        postReadme: "这是一个测试的普通帖子，我也不知道写什么，所以我就随便写写写写写写写写写，阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴",
        postLikeAmount: 999,
        postDislikeAmount: 999,
        postDate: "2024/6/5",
        postCover: "/images/cover.jpg"
      },
      postData5: {
        title: "示例普通帖子标题",
        labels: ["转载","Java","SpringBoot","开源"],
        postAuthorAvatar: "https://avatars.githubusercontent.com/u/122099628?v=4",
        postAuthorName: "EatFan",
        postReadme: "这是一个测试的普通帖子，我也不知道写什么，所以我就随便写写写写写写写写写，阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴",
        postLikeAmount: 999,
        postDislikeAmount: 999,
        postDate: "2024/6/5",
        postCover: "/images/cover.jpg"
      },
    }
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