<!-- 论坛主页 -->
<template>
  <div class="forum-home-content-container">
    <!-- 通知栏 -->
    <NoticesContainer />

    <!-- 论坛主页主体头部 -->
    <div class="forum-home-body-header">
      <PageTitle title="论坛主页" />
      <div class="forum-home-body-header-list-button">
        <button @click="onBodyHeaderListButtonClick">
          <i class='bx bx-dots-vertical-rounded'></i>
        </button>
      </div>
    </div>

    <!-- 论坛主页主体主要内容容器 -->
    <div class="forum-home-body-main-container">
      <!-- 主页页面主要内容 -->
      <div class="body-content">
        <div class="body-pageContent">
          <!-- 推荐 推荐帖子 -->
<!--          <RecommendedSection />-->

          <!-- 论坛版块节点 -->
          <ForumNodeList />

          <!-- 友情链接 -->
          <FriendLinks />

        </div>

        <!-- 主体页面中的侧边栏 -->
        <div v-show="isOpenListBar" class="body-sidebar">

          <!-- 广告框 -->
          <div class="body-sidebar-advertise-container">
            <p>广告招租</p>
          </div>

          <!-- 签到框 -->
          <div class="body-sidebar-checkin-container">
            <CheckinBox />
          </div>

        </div>
      </div>

    </div>

  </div>
</template>

<script>
import NoticesContainer from "@/components/NoticesContainer.vue"
import RecommendedSection from "@/components/home/RecommendedSection.vue"
import ForumNodeList from "@/components/home/ForumNodeList.vue"
import FriendLinks from "@/components/home/FriendLinks.vue"
import CheckinBox from "@/components/home/CheckinBox.vue"
import PageTitle from "@/components/PageTitle.vue";
export default {
  components:{
    NoticesContainer,
    RecommendedSection,
    ForumNodeList,
    FriendLinks,
    CheckinBox,
    PageTitle
  },
  data(){
    return {
      isOpenListBar: true
    }
  },
  methods:{
    /**
     * 当主体头部右边侧边栏显示按钮被点击
     */
    onBodyHeaderListButtonClick() {
      this.isOpenListBar = !this.isOpenListBar;
    }
  }

}
</script>

<style scoped>
/* 论坛主页主体容器样式 */
.forum-home-content-container {
  height: auto;
  max-width: 1200px;
  margin: 60px auto 100px;
  //background: #00bd7e;
}

/* 论坛主页主体头部样式 */
.forum-home-body-header {
  height: 47px;
  width: 100%;
  margin-top: 20px;

  display: flex;
}

/* 论坛主页主体头部右边侧边栏显示按钮盒子样式 */
.forum-home-body-header-list-button {
  position: relative;
  width: 40px;
  height: 40px;

  margin-left: auto;
}

/* 头部右边侧边栏显示按钮样式 */
.forum-home-body-header-list-button button {
  position: absolute;
  right: 0;
  width: 25px;
  height: 40px;

  border: none;
  border-radius: 8px;
}

/* 头部右边侧边栏显示按钮被覆盖样式 */
.forum-home-body-header-list-button button:hover {
  background: #b7b8bd;
}

.forum-home-body-header-list-button i {
  font-size: 1.4em;
}

/* 主体部分样式 */
.body-content {
  display: flex;
}

/* 主页页面主要内容容器样式 */
.body-pageContent {
  display: flex;
  flex: 1;
  flex-direction: column;
  gap: 20px; /* 设置各容器之间的间距 */
}


/* 主体侧边栏容器样式 */
.body-sidebar {
  //display: none;

  width: 250px;
  margin-left: 15px;
  //background: #00bd7e;
  right: 0;
  transition: all 0.3s ease; /* 添加过渡效果 */
}

/* 侧边栏广告容器样式 */
.body-sidebar-advertise-container{
  height: 200px;
}

/* 侧边栏签到容器样式 */
.body-sidebar-checkin-container {
  margin-top: 40px;
}

</style>