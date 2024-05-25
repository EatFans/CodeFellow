<!-- 主体中的通知栏容器 -->
<template>
  <div class="notices-container">
    <!-- 固定通知栏 -->
    <div class="fixed-notices">
      <div class="fixed-notices-bookmark-item">
        <i class='bx bxs-message-alt-error'></i>
      </div>
      <div class="fixed-notices-message">
        <p>{{fixedNoticeMessage}}</p>
        <a :href=joinQQLink>点击加入</a>
      </div>
    </div>
    <!-- 轮播通知栏 -->
    <div class="carousel-notice">

    </div>
  </div>
</template>

<script>

import '@/assets/theme.css'

export default {
  data(){
    return {
      // TODO:测试
      fixedNoticeMessage: "CodeFellow 开发者交流论坛官方QQ群聊 ：",
      joinQQLink: "http://qm.qq.com/cgi-bin/qm/qr?_wv=1027&k=xKzWslt79g0x_wg5V0y7eJD4ae-9ZJsc&authKey=oRDmZXWDgw8JcsfBzdzGoyUtFT1Up7WRDKVphWBddHh9vhfEZbowMB6zuaAmAKYy&noverify=0&group_code=835378015"
    }
  }
}

</script>

<style scoped>
/* 通知栏容器样式 */
.notices-container {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: stretch;
  height: 160px;
}

/* 固定通知栏样式 */
.fixed-notices {
  display: flex; /* 使用Flexbox布局 */
  align-items: center; /* 垂直居中对齐 */
  margin-top: 20px;
  height: 50px;
  border-radius: 10px;
  border: 2px solid #2174f1;
  overflow: hidden; /* 防止内容溢出 */
}

/* 固定通知栏书签样式 */
.fixed-notices-bookmark-item {
  width: 40px;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  background: var(--ui-color);
  border-radius: 7px 0 0 7px;
}

/* 固定通知栏书签图标样式 */
.fixed-notices-bookmark-item i {
  font-size: 1.7em;
  color: #8fb9f7;
}

/* 固定通知栏消息框样式 */
.fixed-notices-message {
  display: flex;
  align-items: center; /* 垂直居中对齐 */
  padding-left: 10px; /* 添加内边距 */
}

/* 固定通知栏消息样式 */
.fixed-notices-message p {
  font-size: 13px;
  color: #384764;
}

.fixed-notices-message a {
  font-size: 13px;
  color: #999999;
}

.fixed-notices-message a:hover {
  color: gold;
}

/* 轮播通知栏样式 */
.carousel-notice {
  margin-top: 20px;
  height: 70px;
  border-radius: 10px;
  border: 2px solid #2174f1;
}

</style>