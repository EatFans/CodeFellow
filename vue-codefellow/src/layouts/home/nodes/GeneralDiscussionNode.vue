<!-- 综合讨论区 -->
<template>
  <div class="forum-node-container">
    <!-- 标题栏 -->
    <div class="node-bar">
      <div class="node-bar-content">
        <div class="node-title">
          <h1>综合讨论区</h1>
        </div>

        <div class="node-list-button">
          <button @click="onShowNodeButtonClick">
            <i :class="node1Visible ? 'bx bx-chevron-up' : 'bx bx-chevron-down'"></i>
          </button>
        </div>
      </div>
      <div class="border-bottom"></div>
    </div>

    <!-- 节点展开后容器 -->
    <div v-show="node1Visible" class="node-content">
      <!-- 社区公告与反馈 -->
      <div class="news-feedback-node-item" @click="handlerForNodeLinkA">
        <p>Hello World</p>
      </div>
      <!-- 新手报到与交流 -->
      <div class="communication-node-item" @click="handlerForNodeLinkB">

      </div>
    </div>
  </div>
</template>

<script>
import "@/assets/theme.css"
import {mapState} from "vuex";

export default {
  name: 'GeneralDiscussionNode',
  data()  {
    return {
      // isShowNode: true
    }
  },
  computed: {
    ...mapState('settings',{
      node1Visible: state => state.node1Visible
    })
  },
  methods: {
    onShowNodeButtonClick(){
      this.$store.commit('settings/SET_NODE_1_VISIBLE',!this.node1Visible);
    },
    handlerForNodeLinkA() {
      this.$router.push('/forum/news-feedback');
    },
    handlerForNodeLinkB() {
      this.$router.push('/forum/communication');
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

/* 社区公告与反馈容器 */
.news-feedback-node-item {
  height: 180px;
  width: 48%;
  background: blue;
  background-size: cover;
  margin-bottom: 10px;
  margin-left: 12px;
  border-radius: 5px;
}

.communication-node-item {
  height: 180px;
  width: 48%;
  background: deeppink;
  margin-bottom: 10px;
  margin-right: 12px;
  border-radius: 5px;
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