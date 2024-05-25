<!-- 技术问答与社区互动 -->
<template>
  <div class="forum-node-container">
    <!-- 标题栏 -->
    <div class="node-bar">
      <div class="node-bar-content">
        <h1 class="node-title">技术问答与社区互动</h1>
      </div>
      <div class="border-bottom"></div>
    </div>

    <!-- 节点展开后容器 -->
    <div class="node-content">
      <!-- 新闻资讯 -->

      <!-- 公告 -->

      <!-- 开发讨论 -->

    </div>
  </div>
</template>

<script>
import "@/assets/theme.css"

export default {
  data()  {
    return {

    }
  },
  methods: {

  }
}

</script>

<style scoped>
/* 论坛版块节点容器样式 */
.forum-node-container {
  width: auto;
}

/* 节点栏样式 */
.node-bar {
  position: relative; /* 使子元素能够相对于此元素定位 */
  height: 50px;
  width: auto;
}

/* 节点栏下边框样式 */
.border-bottom {
  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 5px;
  background: var(--ui-color);
  border-radius: 4px;
}

/* 节点标题字体样式 */
.node-title {
  position: absolute;
  left: 10px;
  bottom: 10px;
  font-size: 18px;
  font-weight: 300;
  color: #1c1010;
  font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
}

.node-content {
  width: 100%;
  height: 200px;
  margin-top: 5px;
  background: red;
}
</style>