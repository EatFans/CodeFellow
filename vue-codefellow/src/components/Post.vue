<!-- 帖子组件 -->
<template>
  <div class="post-container">
    <!-- 帖子作者信息容器 -->
    <div class="post-author-container">
      <div class="post-author-avatar-container">
        <img :src="postAuthorAvatar" alt="" class="post-author-avatar">
      </div>
    </div>

    <!-- 帖子信息容器 -->
    <div class="post-info-container">
      <!-- 帖子信息内容 -->
      <div class="post-info-content">
        <div class="post-info-title">
          <!-- 帖子标题 -->
          <h3 class="post-title-value">{{ title }}</h3>
          <!-- 帖子标签 -->

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

export default {
  name: 'Post',
  props: {
    title: {
      type: String,
      required: true
    }
  },
  data(){
    return{
      postAuthorAvatar: 'https://avatars.githubusercontent.com/u/122099628?v=4',
      postAuthorName: 'EatFan',
      postReadme: '帖子测试介绍文案fdafhdjkafhd就很烦的卡号发可达四十风华贷记卡发货的发货的急啊卡复活打客服回答科技开发哈桑风很大开发的哈客服回答是开放的哈佛的的发哈的看法哈桑独守空房大数据开发大叔控发动机啊看看凤凰大厦客服回答水库日u额放大开发的哈设计开发等哈尽快发大货开发和大家看法和打客服等哈艰苦奋斗和开发和',
      postLikeAmount: 1,
      postDislikeAmount: 0,
      postData: '2024/6/5'
    }
  }
}
</script>

<style>
.post-container {
  height: 150px;
  width: 100%;
  border: 1px solid #1c1010;
  display: flex;
  flex-direction: row;
}

.post-author-container {
  height: 100%;
  width: 150px;
  border: 1px solid #cc4242;
}

.post-author-avatar-container {
  height: 64px;
  width: 100%;
  display: flex;
  justify-content: center;
  margin-top: 10px;
  border: 1px solid gold;
}

.post-author-avatar {
  height: 64px;
  width: 64px;

  border-radius: 50%;
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

.post-info-title {

  //border: 1px solid red;
}

.post-title-value {
  margin-top: 10px;
  margin-left: 5px;
  font-size: 18px;
  font-weight: 400; /* 调整为较细的字体 */
  color: #1c1010; /* 较柔和的文本颜色 */
  font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
}

.post-title-value:hover {
  text-decoration: underline;
}

.post-info-body {
  min-height: 28px;
  //border: 1px solid #cc4242;
}

.post-info-readme {
  margin-left: 5px;
  margin-top: 10px;
  height: 72px;
}


.post-info-stats {
  height: 28px;
  display: flex;
  flex-direction: row;
  //border: 1px solid gold;
}

.post-info-stats-like, .post-info-stats-dislike, .post-info-stats-data {
  width: 60px;
  height: 100%;
  margin-left: 5px;
  margin-top: 5px;

  display: flex;
  flex-direction: row;

  //background: #cc4242;
}

.post-info-stats-like i, .post-info-stats-dislike i {
  font-size: 1.3em;
  color: #384764;
}

.post-info-stats-like p, .post-info-stats-dislike p , .post-info-stats-data p{
  margin-left: 5px;
  font-size: 15px;
  color: #384764;
}


.post-info-text-value {
  font-size: 15px;
  color: #384764;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 3; /* 限制行数为3行 */
  overflow: hidden;
  text-overflow: ellipsis; /* 超出部分显示省略号 */
}

.post-cover-content {
  height: 100%;
  flex: 1;
  border: 1px solid gold;
}

</style>