<!-- 登录注册弹窗组件 -->
<template>
  <div v-show="visible" class="auth-dialog-overlay-container">
    <div class="auth-dialog-overlay-content" >
      <div class="auth-dialog-overlay-header">
        <h3 class="title-value">登录</h3>
        <button class="close-button" @click="closeDialog">
          <i class='bx bx-x'></i>
        </button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'AuthDialog',
  props: {
    visible: {
      type: Boolean,
      default: false
    },
    // 弹窗类型
    authType: {
      type: String,
      required: true,
      validator(value) {
        return ['login', 'register',''].includes(value);
      }
    }
  },
  methods: {
    closeDialog() {
      // 触发关闭弹窗的操作
      this.$emit('update:visible', false);
    },
  },


}
</script>

<style scoped>
.auth-dialog-overlay-container {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5); /* rgba(红, 绿, 蓝, 透明度) */
  z-index: 1000;
  display: flex;
  justify-content: center; /* 水平居中 */
  align-items: center; /* 垂直居中 */
}

.auth-dialog-overlay-content {
  width: 700px;
  height: 700px;
  background: #fff;
  border-radius: 0.7rem;
  box-shadow: 0 0.9rem 1.7rem rgba(0, 0, 0, 0.25), 0 0.7rem 0.7rem rgba(0, 0, 0, 0.22);
  overflow-y: auto; /* 当内容溢出时显示滚动条 */
}

.auth-dialog-overlay-header {
  width: 100%;
  height: 40px;
  //border: 1px solid #2174f1;
  border-radius: 0.7rem 0.7rem 0 0;
  display: flex;
  flex-direction: row;
  justify-content: space-between; /* 将元素分散对齐 */
  align-items: center; /* 垂直居中对齐 */
}

.title-value {
  margin-left: 10px;
  font-size: 13px;
  font-weight: bold; /* 调整为较细的字体 */
  color: #1c1010; /* 较柔和的文本颜色 */
  font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
}

.close-button {
  margin-top: 5px;
  margin-right: 10px;
  font-size: 1.4em;
  border: none;
}

.login-dialog-content {

}


</style>