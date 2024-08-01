
<template>
  <div class="post-page-content-container">
    <NoticesContainer />

    <div class="post-title-container">
      <!-- 帖子标题 -->
      <div class="body-header-title">
        <div class="title-decoration"></div>
        <h1 class="title-value">{{ title }}</h1>
      </div>
    </div>


    <!-- 主体内容 -->
    <div class="body-content">
      <div class="body-pageContent">
        <div class="post-info-box">

          <div class="post-meta-item">
            <p class="post-meta-name">版权类型：</p>
            <a class="post-meta-value" href="">原创</a>
          </div>

          <div class="post-meta-item">
            <p class="post-meta-name">版块类型：</p>
            <a class="post-meta-value" href="">社区公告与反馈</a>
          </div>

          <div class="post-meta-item">
            <p class="post-meta-name">标签类型：</p>
            <a class="post-meta-value" href="">公告</a>
          </div>

          <div class="post-meta-item">
            <p class="post-meta-name">发布时间：</p>
            <p class="post-meta-value">2024/7/31</p>
          </div>

          <div class="post-meta-item">
            <p class="post-meta-name">最后编辑：</p>
            <p class="post-meta-value">2024/7/31</p>
          </div>
        </div>

      </div>


      <!-- 主体右侧侧边栏 -->
      <div v-show="isOpenListBar" class="body-sidebar">
        <div class="post-info-container">
          <div class="post-author-info">
            <!-- 帖子作者头像 -->
            <div class="post-author-avatar">
              <img :src="authorAvatarUrl" alt="">
            </div>
            <!-- 帖子作者名字 -->
            <div class="post-author-name">
              <p>{{authorName}}</p>
            </div>
            <!-- 帖子作者等级 -->
            <div class="post-author-level">
              <p>【lv: {{authorLevel}}】</p>
            </div>
            <!-- 帖子作者身份 -->

          </div>

        </div>
      </div>
    </div>

  </div>
</template>

<script>
import NoticesContainer from "@/components/NoticesContainer.vue";
import PageTitle from "@/components/PageTitle.vue";

export default {
  name: "PostPageContent",
  components: {PageTitle, NoticesContainer},
  data() {
    return {
      isOpenListBar: true,
      postUuid: this.$route.params.postUuid,
      title: "测试帖子标题321321321",
      readme: "这是测试帖子的自述内容...",
      content: "这是一份测试帖子，我也不知道这个测试帖子该怎么写，所有我就随便打打，发的哈萨克积分活动就是咯复活的撒娇开发防护等级喀什返回的是咖啡很多卡萨活佛的发货的就撒开发货的撒开发还是打客服电话i二u哦惹我热舞哦热舞哦",
      label1: "公告",
      sectionType: this.$route.params.sectionType,

      authorName: "EatFan",
      authorLevel: 6,


      authorAvatarUrl: "https://avatars.githubusercontent.com/u/122099628?v=4"
    }
  }
}
</script>

<style scoped>
.post-meta-item {
  width: 100%;
  height: 30px;
  margin-bottom: 8px;
  display: flex;
  align-items: center;
  flex-direction: row;
  //background: deeppink;
}

.post-meta-name{
  font-size: 13px;
  color: #8893ab;
  margin-left: 20px;
}

.post-meta-value {
  font-size: 13px;
  color: black;
  text-decoration: none ;
  margin-left: 150px;
}

.post-info-box {
  width: 100%;
  height: 200px;

  //background: #7db92e;
  border-radius: 0.7rem;
  box-shadow: 0 0.3rem 1.4rem rgba(0, 0, 0, 0.25), 0 0.3rem 0.3rem rgba(0, 0, 0, 0.22);
  //box-shadow: 0 0.9rem 1.7rem rgba(0, 0, 0, 0.25), 0 0.7rem 0.7rem rgba(0, 0, 0, 0.22);
}

/* 主体头部标题盒样式 */
.body-header-title {
  position: relative; /* 设置为相对定位，以便子元素绝对定位相对于它 */
  height: 47px;
  width: auto;
}

/* 标题装饰块 */
.title-decoration {
  position: absolute;
  width: 5px;
  height: 100%;
  background: var(--ui-color);
}

/* 标题文字样式 */
.title-value {
  position: absolute;
  bottom: 10px;
  left: 15px; /* 标题距离标题装饰块左边 10px */
  font-size: 25px;
  font-weight: 500; /* 较细的字体权重 */
  color: #384764; /* 较柔和的文本颜色 */
  font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
}


.post-page-content-container {
  max-width: 1200px;
  margin: 60px auto 100px;
  height: auto;

}

.post-title-container {
  margin-top: 10px;
  width: 100%;
  //border: black solid 1px;

}

.post-label p {
  color: white;
  font-size: 20px;
  display: flex;
  justify-content: center;
  align-items: center;
}

.post-title-container h1 {
  margin-left: 10px;
  font-size: 25px;
  font-weight: 500; /* 较细的字体权重 */
  color: #384764; /* 较柔和的文本颜色 */
  font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
}


.body-content {
  width: 100%;
  margin-top: 10px;

  display: flex;
  flex-direction: row;
  //border: black solid 1px;
}


.body-pageContent {
  height: 1500px;
  flex: 4;
  display: flex;
  flex-direction: column;

  border-right: #e1d4d4 solid 1px;
}

/* 主体容器右侧侧边栏样式 */
.body-sidebar {
  flex: 1;
  //background: #00bd7e;
  right: 0;
  //display: none;

  width: 250px;
}

.post-info-container {
  width: 100%;
  height: 200px;

  display: flex;
  flex-direction: row;
  //background: #2174f1;
  //border: black solid 1px;
}


.post-author-info {
  height: 100%;
  width: 100%;

  display: flex;
  flex-direction: column;
  //background: deeppink;

  //border: black solid 1px;
}



.post-author-avatar {
  width: 100%;
  height: 60px;
  display: flex;
  justify-content: center;

  //background: #7db92e;
}

.post-author-avatar img {
  width: 60px;
  height: 60px;
  border-radius: 50%;
}

.post-author-name {
  width: 100%;
  height: auto;
  display: flex;
  justify-content: center;
}

.post-author-name p {
  font-size: 12px;
}

.post-author-level {
  width: 100%;
  height: auto;
  display: flex;
  justify-content: center;
}

.post-author-level p {
  font-size: 12px;
}
</style>