<!-- 帖子组件 -->
<template>
  <div class="post-container">
    <!-- 帖子作者信息容器 -->
    <div class="post-author-container">
      <div class="post-author-avatar-content">
        <img :src="postData.postAuthorAvatar" alt="Author Avatar" class="post-author-avatar">
      </div>
      <div class="post-author-info-name-box">
        <p class="post-author-info-name" >{{postData.postAuthorName}}</p>
      </div>
    </div>

    <!-- 帖子信息容器 -->
    <div class="post-info-container">
      <!-- 帖子信息内容 -->
      <div class="post-info-content">
        <div class="post-info-title">
          <!-- 帖子标签 -->
          <div class="post-label-container">
            <Label v-for="(label, index) in postData.labels" :key="index" :label="label"></Label>
          </div>
          <!-- 帖子标题 -->
          <h3 class="post-title-value">{{ postData.title }}</h3>
        </div>

        <div class="post-info-body">
          <!-- 帖子自述 -->
          <div class="post-info-readme">
            <p class="post-info-text-value">{{ postData.postReadme }}</p>
          </div>
          <!-- 帖子状态 -->
          <div class="post-info-stats">
            <!-- 点赞量 -->
            <div class="post-info-stats-like">
              <i class='bx bx-like'></i>
              <p>{{ postData.postLikeAmount }} 赞</p>
            </div>
            <!-- 不喜欢量 -->
            <div class="post-info-stats-dislike">
              <i class='bx bx-dislike'></i>
              <p>{{ postData.postDislikeAmount }} 踩</p>
            </div>
            <!-- 帖子发布日期 -->
            <div class="post-info-stats-data">
              <p>{{ postData.postDate }}</p>
            </div>
          </div>
        </div>
      </div>
      <!-- 帖子封面内容 -->
      <div class="post-cover-content" :style="{ backgroundImage: 'url(' + postData.postCover + ')' }">
      </div>
    </div>
  </div>
</template>

<script>

import Label from "@/components/Label.vue";

export default {
  name: 'Post',
  components: { Label },
  props: {
    postData: {
      type: Object,
      required: true,
      validator(value) {
        return (
            'title' in value &&
            'postUUID' in value &&
            'labels' in value &&
            'postAuthorAvatar' in value &&
            'postAuthorName' in value &&
            'postReadme' in value &&
            'postLikeAmount' in value &&
            'postDislikeAmount' in value &&
            'postDate' in value &&
            'postCover' in value
        );
      }
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
  margin-bottom: 10px;

  //border: 1px solid #1c1010;

}

.post-author-container {
  height: 100%;
  //border: 1px solid #cc4242;
}

.post-author-avatar-content{
  height: 50px;
  width: 64px;
  display: flex;
  justify-content: center;
  //border: 1px solid gold;
}

.post-author-avatar {
  height: 48px;
  width: 48px;

  border-radius: 50%;
}

.post-author-info-name-box {
  display: flex;
  justify-content: center;
}

.post-author-info-name {
  font-size: 10px;
  color: #384764;
}

.post-info-container {
  height: 100%;
  width: 100%;
  display: flex;
}

.post-info-content {
  height: 100%;
  flex: 4;
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

.post-info-stats-like, .post-info-stats-dislike, .post-info-stats-data{
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

.post-info-stats-like p, .post-info-stats-dislike p , .post-info-stats-data p{
  margin-left: 5px;
  font-size: 12px;
  color: #384764;
}


.post-cover-content {
  height: 75px; /* 固定高度 */
  width: 150px; /* 固定宽度 */
  flex: none; /* 确保容器不会随着内容拉伸 */
  background-size: cover;
  //border: 1px solid gold;
}



</style>