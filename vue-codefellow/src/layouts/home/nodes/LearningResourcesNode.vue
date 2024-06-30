<!-- 学习资源与知识分享 -->
<template>
  <div class="forum-node-container">
    <!-- 标题栏 -->
    <div class="node-bar">
      <div class="node-bar-content">
        <div class="node-title">
          <h1>学习资源与知识分享</h1>
        </div>

        <div class="node-list-button">
          <button @click="onShowNodeButtonClick">
            <i :class="node6Visible ? 'bx bx-chevron-up' : 'bx bx-chevron-down'"></i>
          </button>
        </div>
      </div>
      <div class="border-bottom"></div>
    </div>

    <!-- 节点展开后容器 -->
    <div v-show="node6Visible" class="node-content">
      <!-- 新闻资讯 -->

      <!-- 公告 -->

      <!-- 开发讨论 -->

    </div>
  </div>
</template>

<script>
import "@/assets/theme.css"
import {mapState} from "vuex";

export default {
  name: 'LearningResourcesNode',
  data()  {
    return {
      // isShowNode: true
    }
  },
  computed: {
    ...mapState('settings',{
      node6Visible: state => state.node6Visible
    })
  },
  methods: {
    onShowNodeButtonClick(){
      this.$store.commit('settings/SET_NODE_6_VISIBLE',!this.node6Visible);
    }
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
.node-title h1{
  position: absolute;
  left: 10px;
  bottom: 10px;
  font-size: 18px;
  font-weight: 300;
  color: #1c1010;
  font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
}

/* 节点按钮框 */
.node-list-button {
  position: absolute;
  right: 10px;
  bottom: 12px;
  width: 20px;
  height: 20px;
}

.node-list-button button {
  width: 25px;
  height: 22px;

  border: none;
  border-radius: 5px;
}

.node-list-button button:hover {
  background: #b7b8bd;
}

.node-list-button i {
  font-size: 1.5em;
}



.node-content {
  width: 100%;
  margin-top: 5px;
  height: 200px;
  background: transparent;
}
</style>