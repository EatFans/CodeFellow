<!-- 帖子显示列表容器组件 -->
<template>
  <div class="post-list-container">
    <!-- 置顶帖子区域 -->
    <div class="pinned-post-list-container">
      <!-- 置顶帖子标题头部栏 -->
      <ContentTitle title="置顶帖子" />
      <div class="pinned-post-list-content">
        <Post v-for="(post, index) in pinnedPosts" :key="index" :post-data="post" />
      </div>
    </div>
    <!-- 普通帖子区域 -->
    <div class="post-list-container">
      <!-- 普通帖子标题头部栏 -->
      <ContentTitle title="普通帖子" />
      <div class="post-list-content">
        <Post v-for="(post, index) in posts" :key="index" :post-data="post" />
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
      pinnedPosts: [
        {
          title: "示例公告帖子1",
          postUUID: "fhdakfhdsajk-fdsafdhji-ewqewq",
          labels: ["公告"],
          postAuthorAvatar: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ5yIcZRiufRzMzcRtLbusbSWPfFfXS9jsg-Q&s",
          postAuthorName: "EatFan",
          postReadme: "这是一个测试的公告帖子，我也不知道写什么，所以我就随便写写写写写写写写写.....................",
          postLikeAmount: 999,
          postDislikeAmount: 999,
          postDate: "2024/6/5",
          postCover: "/images/cover.jpg"
        },
        {
          title: "示例公告帖子2",
          postUUID: "fhdakfhdsajk-fdsafdhji-ewqewq",
          labels: ["公告"],
          postAuthorAvatar: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ5yIcZRiufRzMzcRtLbusbSWPfFfXS9jsg-Q&s",
          postAuthorName: "EatFan",
          postReadme: "这是一个测试的公告帖子，我也不知道写什么，所以我就随便写写写写写写写写写，阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴",
          postLikeAmount: 999,
          postDislikeAmount: 999,
          postDate: "2024/6/5",
          postCover: "/images/cover.jpg"
        }
      ],

      posts: [
        {
          title: "示例普通帖子1",
          postUUID: "fhdakfhdsajk-fdsafdhji-ewqewq",
          labels: ["转载","C++","QT"],
          postAuthorAvatar: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ5yIcZRiufRzMzcRtLbusbSWPfFfXS9jsg-Q&s",
          postAuthorName: "EatFan",
          postReadme: "这是一个测试的普通帖子，我也不知道写什么，所以我就随便写写写写写写写写写，阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴",
          postLikeAmount: 999,
          postDislikeAmount: 999,
          postDate: "2024/6/5",
          postCover: "/images/cover.jpg"
        },
        {
          title: "示例普通帖子2",
          postUUID: "fhdakfhdsajk-fdsafdhji-ewqewq",
          labels: ["原创","Java"],
          postAuthorAvatar: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ5yIcZRiufRzMzcRtLbusbSWPfFfXS9jsg-Q&s",
          postAuthorName: "EatFan",
          postReadme: "这是一个测试的普通帖子，我也不知道写什么，所以我就随便写写写写写写写写写，阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴阿巴",
          postLikeAmount: 999,
          postDislikeAmount: 999,
          postDate: "2024/6/5",
          postCover: "/images/cover.jpg"
        },


      ],


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