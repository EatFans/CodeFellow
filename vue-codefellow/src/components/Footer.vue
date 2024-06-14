<!-- 底部栏 -->
<template>
  <div class="footer">
    <div class="footer-nav">
      <ul>
        <li><a href=" ">首页</a></li>
        <li><a href=" ">关于我们</a></li>
        <li><a href=" ">联系我们</a></li>
        <li><a href=" ">服务</a></li>
      </ul>
    </div>
    <!-- 底部信息 -->
    <div class="footer-info">
      <p>@ 2023 NewWorld Studio. All rights reserved.</p>
      <p><a href=" ">隐私条款</a> | <a href=" ">使用条款</a> | <a href=" ">常见问题</a></p>
    </div>
    <div class="footer-contact">
      <p>联系我们：newworldstudio@163.com</p>
      <p>友情链接：<a href="https://eatfans.github.io">EatFan的博客</a></p>
    </div>
  </div>
</template>

<script>
import '@/assets/theme.css';


export default {
  name: 'Footer',
  computed: {
    // 从 Vuex 中获取当前主题状态

  },

  data() {
    return {

    }
  },
  methods: {

  }
}

</script>

<style scoped>
.footer {
  position: relative;
  bottom: 0;
  left: 0;
  height: 200px;
  width: 100%;
  background-color: var(--footer-bar-color);
  text-align: center;
  padding: 50px;
}


.footer-nav ul {
  list-style-type: none;
  padding: 0;
}

.footer-nav ul li {
  display: inline-block;
  margin-right: 10px;
}

.footer-nav ul li a {
  text-decoration: none;
  color: #b7b8bd;
}

.footer-info {
  margin: 10px 0;
}

.footer-info p {
  font-size: 12px;
  color: #b7b8bd;
}

.footer-info p a {
  color:white;
}

.footer-contact p {
  font-size: 12px;
  color: #b7b8bd;
  margin: 5px 0;
}

.footer-contact p a {
  color: white;
}
</style>
