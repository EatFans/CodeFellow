<!-- 帖子标签 -->
<template>
  <div class="label-container" :style="labelStyle">
    <p>{{ label }}</p>
  </div>
</template>

<script>
export default {
  name:'Label',
  props: {
    label: {
      type: String,
      required: true
    }
  },
  computed: {
    labelStyle() {
      let backgroundColor;
      let textColor;
      switch (this.label.toLowerCase()) {
        case '公告':
          backgroundColor = '#d22f2f';
          textColor = '#fff';
          break;
        case '转载':
          backgroundColor = '#28a745';
          textColor = '#fff';
          break;
        case '原创':
          backgroundColor = 'gold';
          textColor = '#090707';
          break;
        case '开源':
          backgroundColor = '#0d47a0';
          textColor = '#fff';
          break;
        default:
          backgroundColor = '#2174f1'; // 默认浅蓝色
          textColor = '#fff';
      }
      return {
        marginLeft: '3px',
        backgroundColor: backgroundColor,
        borderRadius: '3px',
        width: 'auto',//34px
        height: '15px',
        color: textColor,
        fontSize: '12px',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center'
      };
    }
  }
}
</script>

<style scoped>
.label-container p {
  margin-left: 5px;
  margin-right: 5px;
}
</style>