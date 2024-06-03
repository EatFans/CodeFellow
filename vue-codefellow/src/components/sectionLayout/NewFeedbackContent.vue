<!-- 社区公告与反馈 版块页面主体内容 -->
<template>
  <div class="new-feedback-content-container">
    <!-- 通知栏 -->
    <NoticesContainer />

    <!-- 顶部A类广告栏 -->
    <div class="header-advertisement-A-container">

    </div>

    <!-- 头部内容 -->
    <div class="body-header-content">
      <!-- 主体头部标题盒 -->
      <div class="body-header-title-box">
        <div class="body-header-title">
          <div class="title-decoration"></div>
          <h1 class="title-value">社区公告与反馈</h1>
        </div>
        <div class="body-header-list-button">
          <button @click="onBodyHeaderListButtonClick">
            <i class='bx bx-dots-vertical-rounded'></i>
          </button>
        </div>
      </div>

      <!-- 版块信息与自述 -->

    </div>

    <!-- 主体内容 -->
    <div class="body-content">

    </div>

    <!-- 底部装饰板 -->
    <div class="decorative-plates">

    </div>
  </div>
</template>

<script>
import '@/assets/theme.css'
import NoticesContainer from "@/components/NoticesContainer.vue";
export default {
  components:{
    NoticesContainer
  }
}
</script>

<style scoped>
.new-feedback-content-container {
  max-width: 1200px;
  margin: 60px auto 100px;
}

/* 主体头部 */
.body-header-content {
  width: 100%;
  height: 300px;
  background: #00bd7e;
}

/* 主体头部标题盒样式 */
.body-header-title-box {
  height: 47px;
  width: 100%;
  margin-top: 20px;

  display: flex;
}

/* 主体头部标题盒样式 */
.body-header-title {
  position: relative; /* 设置为相对定位，以便子元素绝对定位相对于它 */
  height: 100%;
  width: 200px;
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
  font-size: 23px;
  font-weight: 300; /* 较细的字体权重 */
  color: #1c1010; /* 较柔和的文本颜色 */
  font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
}

/* 主体头部右边侧边栏显示按钮盒子样式 */
.body-header-list-button {
  position: relative;
  width: 40px;
  height: 40px;

  margin-left: auto;
}

/* 头部右边侧边栏显示按钮样式 */
.body-header-list-button button {
  position: absolute;
  right: 0;
  width: 25px;
  height: 40px;

  border: none;
  border-radius: 8px;
}

/* 头部右边侧边栏显示按钮被覆盖样式 */
.body-header-list-button button:hover {
  background: #b7b8bd;
}

.body-header-list-button i {
  font-size: 1.4em;
}

.body-content {
  height: 2000px;
  width: 100%;
  background: #7db92e;
  margin-top: 20px;
}

.decorative-plates {
  width: 100%;
  height: 240px;
  background: url("https://camo.githubusercontent.com/958d3c4a2ec51daf18c5eeed23bed3f039ca13a6aa96a056b7883d9a642c5fbf/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f67682f73756e3032323553554e2f73756e3032323553554e2f6173736574732f696d616765732f69636f6e2e706e67");
  background-size: cover;
  border-radius: 10px;
  margin-top: 20px;
}
</style>