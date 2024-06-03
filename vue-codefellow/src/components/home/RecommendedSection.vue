<!-- 推荐栏目组件 -->
<template>
  <div class="recommended-section-container">
    <!-- 主要推荐容器内容 -->
    <div class="recommended-main-content">

    </div>

    <!-- 底部轮播图 -->
    <div class="carousel-footer-content">
      <h3>底部帖子轮播 （待未完工）</h3>
    </div>
  </div>
</template>

<script>
export default {
  components:{

  },
  data(){
    return {

    }
  }
}
</script>

<style scoped>
/* 推荐栏目容器样式 */
.recommended-section-container {
  width: auto;
}

.recommended-main-content {
  width: auto;
  height: 350px;
  border-radius: 10px;
  background: #00bd7e;
}



/* 底部轮播图 */
.carousel-footer-content {
  width: auto;
  height: 160px;

  margin-top: 10px;

  background: blueviolet;

}
</style>