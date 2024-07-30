
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

        <div class="post-info">

        </div>


      </div>
      <!-- 主体右侧侧边栏 -->
      <div v-show="isOpenListBar" class="body-sidebar">

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
      sectionType: this.$route.params.sectionType
    }
  }
}
</script>

<style scoped>
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
  border: black solid 1px;

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
  border: black solid 1px;
}


.body-pageContent {
  height: 1500px;
  flex: 4;
  display: flex;
  flex-direction: column;
}

/* 主体容器右侧侧边栏样式 */
.body-sidebar {
  flex: 1;
  background: #00bd7e;
  right: 0;
  //display: none;

  width: 250px;
  margin-left: 15px;
}

.post-info {
  width: 100%;
  height: 100px;


}

</style>