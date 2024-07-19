
<template>
  <div class="communication-content-container">
    <NoticesContainer />

    <div class="header-advertisement-A-container"></div>

    <div class="body-header-content">
      <div class="body-header-title-box">
        <PageTitle :title="pageTitle" />
        <div class="body-header-list-button">
          <button @click="onBodyHeaderListButtonClick">
            <i class='bx bx-dots-vertical-rounded'></i>
          </button>
        </div>
      </div>

      <!-- 版块信息与自述 -->
      <div class="body-header-section-info"></div>
    </div>

    <!-- 主体内容 -->
    <div class="body-content">
      <div class="body-pageContent">
        <div class="post-list-container">
          <!-- TODO: 显示帖子的区域 -->
          <CommunicationPostList />
        </div>
      </div>

      <!-- 主体右侧侧边栏 -->
      <div v-show="isOpenListBar" class="body-sidebar">

      </div>

    </div>


    <!-- 底部装饰板 -->
    <div class="decorative-plates"></div>

  </div>

</template>


<script>
import NoticesContainer from "@/components/NoticesContainer.vue";
import PageTitle from "@/components/PageTitle.vue";
import CommunicationPostList from "@/layouts/communication/CommunicationPostList.vue";

export default {
  name: "CommunicationContent",
  components: {
    CommunicationPostList,
    PageTitle,
    NoticesContainer
  },
  data(){
    return {
      pageTitle: "新手报到与交流",
      isOpenListBar: false
    }
  },
  methods : {
    onBodyHeaderListButtonClick(){

    }
  }
}
</script>

<style scoped>
.communication-content-container {
  max-width: 1200px;
  margin: 60px auto 100px;
  height: auto;
}

.body-header-content {
  width: 100%;
}

.body-header-title-box {
  height: 47px;
  width: 100%;
  margin-top: 20px;
  display: flex;
}

.body-header-list-button {
  position: relative;
  width: 40px;
  height: 40px;
  margin-left: auto;
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

/* 版块信息与自述容器样式 */
.body-header-section-info {
  background: #fff;
  height: 200px;
  border-radius: 0.7rem;
  box-shadow: 0 0.9rem 1.7rem rgba(0, 0, 0, 0.25), 0 0.7rem 0.7rem rgba(0, 0, 0, 0.22);
}

.body-content {
  width: 100%;
  margin-top: 50px;

  display: flex;
  flex-direction: row;
}


.body-pageContent {
  min-height: 2000px;
  flex: 4;
  display: flex;
  flex-direction: column;
}

.post-list-container {
  margin-top: 5px;
}

.decorative-plates {
  width: 100%;
  height: 240px;
  background: url("https://camo.githubusercontent.com/958d3c4a2ec51daf18c5eeed23bed3f039ca13a6aa96a056b7883d9a642c5fbf/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f67682f73756e3032323553554e2f73756e3032323553554e2f6173736574732f696d616765732f69636f6e2e706e67");
  background-size: cover;
  border-radius: 10px;
  margin-top: 20px;
}
</style>