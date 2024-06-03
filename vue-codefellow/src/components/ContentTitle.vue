<!-- 页面容器内容标题通用组件 -->
<template>
  <div class="content-title-container">
    <p class="title-value">{{title}}</p>
    <div class="title-decoration"></div>
  </div>
</template>

<script>
import "@/assets/theme.css"
export default {
  name:'ContentTitle',
  props:{
    title: {
      type: String,
      required: true
    }
  }
}
</script>

<style scoped>
.content-title-container{
  width: 100%;
  display: flex;
  flex-direction: column;
}

.title-value {
  font-size: 12px;
  font-weight: bold;
  color: #1c1010; /* 较柔和的文本颜色 */
  font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
  margin-left: 10px;
  margin-top: 10px;
  margin-bottom: 10px;
}

.title-decoration{
  height: 5px;
  width: 100%;

  background: var(--ui-color);
  border-radius: 10px;
}
</style>