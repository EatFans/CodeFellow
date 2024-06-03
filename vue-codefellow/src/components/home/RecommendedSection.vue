<!-- 推荐栏目组件 -->
<template>
  <div class="recommended-section-content">
    <!-- 主要轮播图 -->
    <div class="carousel-main-content">

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
      slides: [
        { image: 'https://attach.klpbbs.com/forum/202403/10/015444vs3wlrqqfkyzfyly.jpg', link: 'https://example.com/1', title: 'Slide 1' },
        { image: 'https://attach.klpbbs.com/forum/202403/10/015444vs3wlrqqfkyzfyly.jpg', link: 'https://example.com/2', title: 'Slide 2' },
        { image: 'https://attach.klpbbs.com/forum/202403/10/015444vs3wlrqqfkyzfyly.jpg', link: 'https://example.com/3', title: 'Slide 3' },
        { image: 'https://attach.klpbbs.com/forum/202403/10/015444vs3wlrqqfkyzfyly.jpg', link: 'https://example.com/4', title: 'Slide 4' },
        { image: 'https://attach.klpbbs.com/forum/202403/10/015444vs3wlrqqfkyzfyly.jpg', link: 'https://example.com/5', title: 'Slide 5' }
      ]
    }
  }
}
</script>

<style scoped>
/* 推荐栏目容器样式 */
.recommended-section-content {
  width: auto;
}

/* 主要轮播图样式 */
.carousel-main-content {
  width: auto;
  height: 350px;
  border-radius: 10px;
  background: url("https://images.pexels.com/photos/1097456/pexels-photo-1097456.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
  background-size: cover; /* 背景图片覆盖整个容器 */
  background-repeat: no-repeat; /* 防止背景图片重复 */
  background-position: center; /* 背景图片居中 */
}



/* 底部轮播图 */
.carousel-footer-content {
  width: auto;
  height: 160px;

  margin-top: 10px;

  background: blueviolet;

}
</style>