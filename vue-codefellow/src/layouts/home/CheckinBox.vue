<!-- 签到盒子 -->
<template>
  <div class="body-sidebar-checkin-content">
    <div class="sidebar-checkin-title">
      <i class='bx bxs-calendar-event'></i>
      <p>每日签到</p>
    </div>
    <div class="checkin-button-box">
      <button class="sidebar-checkin-button">签到</button>
    </div>
    <div class="checkin-info-content">
      <p>签到天数: {{ day }}</p>
      <p>今天奖励: {{}}</p>
    </div>
  </div>
</template>

<script>
export default {
  data(){
    return {
      day: 0
    }
  },
  methods: {

  }
}
</script>

<style>
/* 侧边栏签到容器内容样式 */
.body-sidebar-checkin-content {
  height: 200px;

  border-radius: 8px;
  border: 2px solid #2174f1;


}

/* 侧边栏签到标题样式 */
.sidebar-checkin-title {
  display: flex;
  background: #2174f1;
  color: #9faecd;
}

.sidebar-checkin-title i {
  font-size: 1.5em;
}

.sidebar-checkin-title p {
  margin-left: 5px;
  font-size: 14px;
  font-weight: bold;
  margin-top: auto;
}

.checkin-button-box {
  width: 100%;
  text-align: center;
}

/* 侧边栏签到按钮样式 */
.sidebar-checkin-button {
  height: 35px;
  width: 110px;
  margin-top: 30px;

  border: none;
  border-radius: 8px;
  background: #83c13b;

  color: #ffffff;
  font-size: 16px;
}

.sidebar-checkin-button:hover {
  background: #7db92e;
}
</style>