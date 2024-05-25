<!-- 论坛主页主体 -->
<template>
  <div class="forum-home-content-container">
    <!-- 通知栏 -->
    <NoticesContainer />

    <!-- 论坛主页主体头部 -->
    <div class="forum-home-body-header">
      <div class="forum-home-body-header-title">
        <h1 class="title-value">推荐列表</h1>
      </div>
    </div>

    <!-- 论坛主页主体主要内容容器 -->
    <div class="forum-home-body-main-container">
      <!-- 主页页面主要内容 -->
      <div class="body-content">
        <div class="body-pageContent">
          <!-- 推荐 轮播图+推荐帖子 -->
          <RecommendedSection class="body-content-item" />

          <!-- 论坛版块节点 -->
          <ForumNodeList class="body-content-item"/>

          <!-- 友情链接 -->
          <FriendLinks class="body-content-item"/>


        </div>
      </div>

      <!-- 主体页面中的侧边栏 -->
      <div class="body-sidebar">

      </div>

    </div>


    <!-- 广告位 -->
  </div>
</template>

<script>
import NoticesContainer from "@/components/NoticesContainer.vue"
import RecommendedSection from "@/components/RecommendedSection.vue"
import ForumNodeList from "@/components/ForumNodeList.vue"
import FriendLinks from "@/components/FriendLinks.vue"
export default {
  components:{
    NoticesContainer,
    RecommendedSection,
    ForumNodeList,
    FriendLinks
  }

}
</script>

<style scoped>
/* 论坛主页主体容器样式 */
.forum-home-content-container {
  height: auto;
  max-width: 1200px;
  margin: 60px auto 200px;
  //background: #00bd7e;
}

/* 论坛主页主体头部样式 */
.forum-home-body-header {
  height: 47px;
  width: 100%;
  margin-top: 20px;
}

/* 论坛主页主体头部标题盒样式 */
.forum-home-body-header-title {
  position: relative; /* 设置为相对定位，以便子元素绝对定位相对于它 */
  height: 100%;
  width: 200px;
}

/* 标题文字样式 */
.title-value {
  position: absolute;
  bottom: 10px;
  font-size: 23px;
  font-weight: 300; /* 较细的字体权重 */
  color: #1c1010; /* 较柔和的文本颜色 */
  font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
}

/* 主页页面主要内容容器样式 */
.body-pageContent {
  display: flex;
  flex-direction: column;
  gap: 20px; /* 设置各容器之间的间距 */
}

.body-content-item {
  flex: 1 0 auto; /* 使容器自适应 */
}
</style>