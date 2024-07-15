<!-- 编程语言与技术讨论 -->
<template>
  <div class="forum-node-container">
    <!-- 标题栏 -->
    <div class="node-bar">
      <div class="node-bar-content">
        <div class="node-title">
          <h1>编程语言与技术讨论</h1>
        </div>

        <div class="node-list-button">
          <button @click="onShowNodeButtonClick">
            <i :class="node2Visible ? 'bx bx-chevron-up' : 'bx bx-chevron-down'"></i>
          </button>
        </div>
      </div>
      <div class="border-bottom"></div>
    </div>

    <!-- 节点展开后容器 -->
    <div v-show="node2Visible" class="node-content">
      <!-- 前端开发 -->
      <div class="front-end-development-node-item" @click="handlerForLinkA">

      </div>

      <!-- 后端开发 -->
      <div class="backend-development-node-item" @click="handlerForLinkB">

      </div>

      <!-- 编程语言 -->
      <div class="programming-language-node-item" @click="handlerForLinkC">

      </div>
    </div>
  </div>
</template>

<script>
import "@/assets/theme.css"
import {mapState} from "vuex";

export default {
  name: 'ProgrammingTechnologiesNode',
  data()  {
    return {
      // isShowNode: true
    }
  },
  computed: {
    ...mapState('settings',{
      node2Visible: state => state.node2Visible
    })
  },
  methods: {
    onShowNodeButtonClick(){
      this.$store.commit('settings/SET_NODE_2_VISIBLE',!this.node2Visible);
    },
    handlerForLinkA() {
      this.$router.push('/forum/front-end-development');
    },
    handlerForLinkB() {
      this.$router.push('/forum/backend-development');
    },
    handlerForLinkC() {
      this.$router.push('/forum/programming-language');
    }
  }
}

</script>

<style scoped>
.node-content {
  width: 100%;
  margin-top: 5px;
  min-height: 180px;
  background: transparent;

  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
}

.front-end-development-node-item {
  height: 180px;
  width: 48%;
  background: url("/images/test.jpg");
  background-size: cover;
  margin-bottom: 10px;
  margin-left: 12px;
  border-radius: 5px;
}

.backend-development-node-item {
  height: 180px;
  width: 48%;
  background: green;
  margin-bottom: 10px;
  margin-right: 12px;
  border-radius: 5px;
}

.programming-language-node-item {
  width: 100%;
  height: 140px;
  background: pink;
  margin-left: 12px;
  margin-right: 12px;
}

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

</style>