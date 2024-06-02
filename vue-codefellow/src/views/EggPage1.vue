<!-- admin彩蛋页面 -->
<template>
  <div class="container">
    <div class="content">
      <h1>大傻春！你在干什么！</h1>
      <h1>你怎么敢找管理员控制台的哇!</h1>
      <img src="/imges/emo1.jpg">
      <h1>想正式加入本论坛开发管理团队吗？</h1>
      <h1>下方就是申请按钮</h1>
      <router-link to="" class="apply-button">申请加入</router-link>
    </div>
  </div>
</template>

<script>

</script>

<style scoped>
.container {
  display: flex;
  justify-content: center; /* 水平居中 */
  height: 100vh; /* 父容器高度 */
}

.content {
  padding: 20px; /* 可选：设置内边距 */
  text-align: center; /* 可选：文本居中 */
}

.apply-button {
  display: inline-block; /* 使其成为内联块元素 */
  margin-top: 20px; /* 设置上边距 */
  width: 200px; /* 按钮宽度 */
  height: 50px; /* 按钮高度 */
  background: #7db92e; /* 背景颜色 */
  color: white; /* 文字颜色 */
  text-align: center; /* 文字居中 */
  line-height: 50px; /* 设置行高，使文字垂直居中 */
  font-size: 18px; /* 文字大小 */
  text-decoration: none; /* 去掉下划线 */
  border-radius: 5px; /* 圆角 */
  transition: background 0.3s; /* 过渡效果 */
}

.apply-button:hover {
  background: #5a7b1e; /* 悬停时背景颜色 */
}
</style>