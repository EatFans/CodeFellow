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
          <!-- 推荐 轮播图+推荐帖子 -->
          <RecommendedSection />

          <!-- 论坛版块节点 -->
          <ForumNodeList />

          <!-- 友情链接 -->
          <FriendLinks />


        </div>

        <!-- 主体页面中的侧边栏 -->
        <div v-show="isOpenListBar" class="body-sidebar">

          <!-- 广告框 -->
          <div class="body-sidebar-advertise-container">
            <p>广告联盟广告框</p>
          </div>

          <!-- 签到框 -->
          <div class="body-sidebar-checkin-container">
            <p>签到</p>
          </div>

        </div>
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
      if (this.isOpenListBar){
        this.isOpenListBar = false;
      } else {
        this.isOpenListBar = true;
      }
    }
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

  display: flex;
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
  background: #00bd7e;
  right: 0;
  transition: all 0.3s ease; /* 添加过渡效果 */
}

/* 侧边栏广告容器样式 */
.body-sidebar-advertise-container{
  height: 250px;
  background: forestgreen;
}

/* 侧边栏签到容器样式 */
.body-sidebar-checkin-container {
  height: 300px;
  background: deeppink;
  margin-top: 40px;
}

</style>