<template>
  <div class="left-nav-content">
    <ul class="left-nav-list">
      <li class="left-nav-item"
          v-for="(item, index) in leftNavItems"
          :key="index"
          @mouseover="changeLeftNavColor($event, index)"
          @mouseout="resetLeftNavColor($event, index)"
          :style="{ backgroundColor: leftNavColors[index] ? '#2174f1' : 'transparent' }">
        <i :class="item.icon" :style="{ color: leftNavColors[index] ? '#fff' : '#7082a7' }"></i>
        <a :href="item.link" :style="{ color: leftNavColors[index] ? '#fff' : '#7082a7' }">{{ item.text }}</a>
      </li>
    </ul>
  </div>
</template>

<script>

export default {
  name: 'LeftNav',
  data(){
    return {
      currentLeftNavColor: 0,
      leftNavColors: [false, false, false, false, false, false,false,false],
      leftNavItems: [
        { icon: 'bx bxs-home-alt-2', text: '首页', link: '/forum' },
        { icon: 'bx bxs-conversation', text: '博客中心', link: '/blog' },
        { icon: 'bx bxs-file-blank', text: '资源中心', link: '/resource' },
        { icon: 'bx bxs-folder', text: '项目中心', link: '/project'},
        { icon: 'bx bxs-bar-chart-alt-2', text: '排行榜', link: '/ranking-list' },
        { icon: 'bx bxs-heart', text: '为爱发电', link: '/donate' },
        { icon: 'bx bxs-widget', text: '工具', link: '/tool'},
        { icon: 'bx bxl-wikipedia', text: '文档', link: '/doc' }
      ]
    }
  },
  methods:{
    /**
     * 改变左侧导航栏颜色
     * @param event
     * @param index
     */
    changeLeftNavColor(event, index){
      event.currentTarget.style.backgroundColor = '#2174f1'; // 鼠标悬停时的背景颜色
      this.currentLeftNavColor = 1; // 修改图标颜色
      // 更新当前标签的颜色状态
      this.leftNavColors[index] = true;
    },
    /**
     * 重置左侧导航栏颜色
     * @param event
     * @param index
     */
    resetLeftNavColor(event, index){
      event.currentTarget.style.backgroundColor = 'transparent'; // 鼠标悬停时的背景颜色
      this.currentLeftNavColor = 0; // 修改图标颜色
      // 重置当前标签的颜色状态
      this.leftNavColors[index] = false;
    }
  }
}

</script>

<style  scoped>
/* 导航 */
.left-nav-content {
  position: absolute;
  width: 240px;
  margin-top: 40px;
}

.left-nav-list {
  list-style: none;
  padding: 0;
  margin: 0;
}

.left-nav-item {
  height: 20px;
  padding: 10px;
  text-align: center;
  display: flex;
  align-items: center;
  border-radius: 12px;

  background-color: transparent;/*#313742FF*/
  opacity: 0; /* 初始状态为透明 */
  animation: fadeIn 0.5s ease forwards; /* 添加渐显动画效果 */
}

/* 导航图标 */
.left-nav-item i {
  font-size: 1.6em;
}

.left-nav-item a {
  margin-left: 18px;
  font-size: 15px;
  font-weight: bolder;
  text-decoration: none;
}

/* 使用@keyframes定义动画 */
@keyframes fadeIn {
  from {
    opacity: 0; /* 初始状态为透明 */
    transform: translateY(-20px); /* 向上偏移一段距离 */
  }
  to {
    opacity: 1; /* 结束状态为完全不透明 */
    transform: translateY(0); /* 恢复原位 */
  }
}

/* 为每个导航标签添加延迟，实现依次出现的效果 */
.left-nav-item:nth-child(1) {
  animation-delay: 0.1s;
}
.left-nav-item:nth-child(2) {
  animation-delay: 0.2s;
}
.left-nav-item:nth-child(3) {
  animation-delay: 0.3s;
}
.left-nav-item:nth-child(4) {
  animation-delay: 0.4s;
}
.left-nav-item:nth-child(5) {
  animation-delay: 0.5s;
}
.left-nav-item:nth-child(6) {
  animation-delay: 0.6s;
}
</style>
