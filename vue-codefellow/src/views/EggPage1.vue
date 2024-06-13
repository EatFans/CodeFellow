<!-- admin彩蛋页面 -->
<template>
  <div class="container">
    <div class="content">
      <h1>大傻春！你在干什么！</h1>
      <h1>你怎么敢找管理员控制台的哇!</h1>
      <img src="/images/emo1.jpg">
      <h1>想正式加入本论坛开发管理团队吗？</h1>
      <img src="/images/emo2.jpg" style="width: 100px; height: 100px">
      <h1>下方就是申请按钮</h1>
      <a href="https://www.bilibili.com/video/BV1hq4y1s7VH/?buvid=XYB4E32B3AB6F9280472BAFA9A7E797ACF813&is_story_h5=false&mid=QzMlMq78pA%2BhDmMPJ36NHA%3D%3D&p=1&plat_id=116&share_from=ugc&share_plat=android&share_session_id=670aa997-cf38-480c-93f8-d9fd3c220761&share_tag=s_i&unique_k=Q4QtzbS&up_id=1717676259&vd_source=a095afd7e18ee1ff147d19f0c7860a4e" target="_blank" class="apply-button">申请加入</a>
    </div>
  </div>
</template>

<script>
export default {
  name: 'EggPage1'
}
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