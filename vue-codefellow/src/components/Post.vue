<!-- 帖子组件 -->
<template>
  <div class="post-container">
    <!-- 帖子作者信息容器 -->
    <div class="post-author-container">
      <div class="post-author-avatar-container">
        <img :src="postAuthorAvatar" alt="" class="post-author-avatar">
      </div>
      <div class="post-author-content">

      </div>
    </div>

    <!-- 帖子信息容器 -->
    <div class="post-info-container">
      <!-- 帖子信息内容 -->
      <div class="post-info-content">
        <div class="post-info-title">
          <!-- 帖子标签 -->
          <div class="post-label-container">
            <Label v-for="(label, index) in labels" :key="index" :label="label"></Label>
          </div>
          <!-- 帖子标题 -->
          <h3 class="post-title-value">{{ title }}</h3>
        </div>

        <div class="post-info-body">
          <!-- 帖子自述 -->
          <div class="post-info-readme">
            <p class="post-info-text-value">{{postReadme}}</p>
          </div>
          <!-- 帖子状态 -->
          <div class="post-info-stats">
            <!-- 点赞量 -->
            <div class="post-info-stats-like">
              <i class='bx bx-like' ></i>
              <p>{{ postLikeAmount }} 赞</p>
            </div>
            <!-- 不喜欢量 -->
            <div class="post-info-stats-dislike">
              <i class='bx bx-dislike' ></i>
              <p>{{ postDislikeAmount }} 踩</p>
            </div>
            <!-- 帖子发布日期 -->
            <div class="post-info-stats-data">
              <p>{{ postData }}</p>
            </div>
            <!-- 帖子作者 -->
            <div class="post-info-stats-author">
              <p>作者：{{ postAuthorName }}</p>
            </div>
          </div>
        </div>
      </div>
      <!-- 帖子封面内容 -->
      <div class="post-cover-content">

      </div>
    </div>

  </div>
</template>

<script>

import Label from "@/components/Label.vue";

export default {
  name: 'Post',
  components: {Label},
  props: {
    title: {
      type: String,
      required: true
    },
    labels: {
      type: Array,
      required: true
    }
  },
  data(){
    return{
      postAuthorAvatar: 'https://avatars.githubusercontent.com/u/122099628?v=4',
      postAuthorName: 'EatFan',
      postReadme: '帖子测试介绍文肥大放大和JFK大黄蜂扩大是否点卡收费很低放大换芬迪哈克放大恢复大会的撒娇案守空房大数据开发快发大货开发和大家看法和打客服等哈艰苦奋斗和开发和非阿尔法而非我发大鳄嗡嗡',
      postLikeAmount: 999,
      postDislikeAmount: 999,
      postData: '2024/6/5'
    }
  }
}
</script>

<style>
.post-container {
  height: 75px;
  width: 100%;
  display: flex;
  flex-direction: row;
  margin-bottom: 5px;

  //border: 1px solid #1c1010;

}

.post-author-container {
  height: 100%;
  width: 150px;
  //border: 1px solid #cc4242;
}

.post-author-avatar-container {
  height: 64px;
  width: 100%;
  display: flex;
  justify-content: center;
  //border: 1px solid gold;
}

.post-author-avatar {
  height: 64px;
  width: 64px;

  border-radius: 50%;
}

.post-author-content  {
  width: 100%;
  //border: 1px solid red;
}

.post-info-container {
  height: 100%;
  width: 100%;
  display: flex;
}

.post-info-content {
  height: 100%;
  flex: 3;
  //border: 1px solid #2174f1;

}

.post-label-container {
  display: flex;
  flex-direction: row;
}

.post-info-title {
  display: flex;
  flex-direction: row;
  //border: 1px solid red;
}

.post-title-value {
  margin-left: 5px;
  font-size: 13px;
  font-weight: bold; /* 调整为较细的字体 */
  color: #1c1010; /* 较柔和的文本颜色 */
  font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
}

.post-title-value:hover {
  text-decoration: underline;
}

.post-info-body {
  height: auto;
  //min-height: 28px;
  //border: 1px solid #cc4242;
}

.post-info-readme {
  margin-left: 5px;
  height: 40px;
}

.post-info-text-value {
  font-size: 13px;
  color: #384764;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 2; /* 限制行数为3行 */
  overflow: hidden;
  text-overflow: ellipsis; /* 超出部分显示省略号 */
}

.post-info-stats {
  height: auto;
  display: flex;
  flex-direction: row;
  //border: 1px solid gold;
}

.post-info-stats-like, .post-info-stats-dislike, .post-info-stats-data, .post-info-stats-author{
  width: 80px;
  height: 100%;
  margin-left: 5px;

  display: flex;
  flex-direction: row;

  //background: #cc4242;
}

.post-info-stats-like i, .post-info-stats-dislike i {
  font-size: 1em;
  color: #384764;
}

.post-info-stats-like p, .post-info-stats-dislike p , .post-info-stats-data p, .post-info-stats-author p{
  margin-left: 5px;
  font-size: 12px;
  color: #384764;
}




.post-cover-content {
  height: 100%;
  flex: 1;
  //border: 1px solid gold;
}

</style>