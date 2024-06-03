<!-- 页面大标题组件 -->
<template>
  <div class="body-header-title">
    <div class="title-decoration"></div>
    <h1 class="title-value">{{ title }}</h1>
  </div>
</template>

<script>

export default {
  name: 'PageTitle',
  props: {
    title: {
      type: String,
      required: true
    }
  }

}
</script>

<style scoped>
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
</style>