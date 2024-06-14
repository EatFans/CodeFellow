<!-- 为爱发电页面主体组件 -->
<template>
  <div class="donate-content-container">
    <NoticesContainer />

    <!-- 头部内容 -->
    <div class="body-header-content">
      <!-- 主体头部标题盒 -->
      <div class="body-header-title-box">
        <PageTitle :title="pageTitle" />
      </div>
    </div>


  </div>
</template>

<script>
import NoticesContainer from "@/components/NoticesContainer.vue";
import PageTitle from "@/components/PageTitle.vue";

export default {
  name: 'DonateContent',
  components: {
    PageTitle,
    NoticesContainer

  },
  data(){
    return {
      pageTitle: '为爱发电'
    }
  },
  methods:{
  }
}
</script>

<style scoped>
.donate-content-container {
  max-width: 1200px;
  margin: 60px auto 100px;
  height: 2000px;
}

/* 主体头部 */
.body-header-content {
  width: 100%;
}

/* 主体头部标题盒样式 */
.body-header-title-box {
  height: 47px;
  width: 100%;
  margin-top: 20px;
  display: flex;
}

/* 头部右边侧边栏显示按钮样式 */
.body-header-list-button button {
  position: absolute;
  right: 0;
  width: 25px;
  height: 40px;
  border: none;
  border-radius: 8px;
  background: transparent;
}

/* 头部右边侧边栏显示按钮被覆盖样式 */
.body-header-list-button button:hover {
  background: #b7b8bd;
}

.body-header-list-button i {
  font-size: 1.4em;
}

</style>