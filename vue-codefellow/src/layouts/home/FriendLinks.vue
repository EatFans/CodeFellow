<template>
  <div class="friend-links-container">
    <div class="friend-links-content">
      <div class="friend-links-title">
        <h1 class="title-value">友情链接</h1>
      </div>
      <div class="friend-links-main">
        <!-- 个人展示盒子 -->
        <div class="show-personal-box">
          <div class="personal-item" v-for="(item,index) in personal" :key="index">
            <a :href="item.link" target="_blank">
              <img :src="item.avatar" class="personal-item-avatar" >
            </a>
            <p class="personal-item-name">{{item.name}}</p>
          </div>
        </div>
        <!-- 团队展示盒子 -->
        <div class="show-team-box">

        </div>
      </div>
    </div>
  </div>


</template>

<script>
export default {
  data(){
    return{
      personal: [
        {avatar:'https://avatars.githubusercontent.com/u/122099628?v=4',name: "EatFan",link:'https://github.com/eatfans'},
        {avatar:'https://avatars.githubusercontent.com/u/152675346?s=96&v=4',name: "NewWorld",link:'https://github.com/New-WorldStudio'}
      ],
      team: [

      ]
    }
  },
  methods:{

  }
}
</script>

<style scoped>
.friend-links-container{
  width: 100%;
  min-height: 200px;
}

.friend-links-content {
  width: 100%;
  height: 100%;
}

/* 标题文字样式 */
.title-value {
  bottom: 10px;
  font-size: 23px;
  font-weight: 300; /* 较细的字体权重 */
  color: #1c1010; /* 较柔和的文本颜色 */
  font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
}

.friend-links-main {
  width: 100%;
  height: 100%;
  border-radius: 0.7rem;
  box-shadow: 0 0.9rem 1.7rem rgba(0, 0, 0, 0.25), 0 0.7rem 0.7rem rgba(0, 0, 0, 0.22);
  margin-top: 10px;

  display: flex;
  flex-direction: column;
}

.show-personal-box {
  flex: 1;
  display: flex;
  flex-wrap: wrap; /* 在空间不足时自动换行 */
  justify-content: flex-start; /* 从左到右排列 */
}

.show-team-box {
  flex: 1;
}

.personal-item {
  width: 48px;
  height: 48px;
  margin-top: 5px;
  margin-left: 20px;
  border-radius: 50%;
}

.personal-item-avatar {
  width: 48px;
  height: 48px;
  border-radius: 50%;
}
.personal-item-name {
  font-size: 12px;
}
</style>