# CodeFellow 代码研究员项目开发

<br>
<br>
<br>
<div align="center" style="margin-top: 60px;">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" alt="Java" style="margin: 5px;">
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white" alt="Maven" style="margin: 5px;">
  <img src="https://img.shields.io/badge/Vue.js-35495E?style=for-the-badge&logo=vue.js&logoColor=4FC08D" alt="Vue.js" style="margin: 5px;">
  <img src="https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white" alt="Spring Boot" style="margin: 5px;">
  <img src="https://img.shields.io/badge/Redis-DC382D?style=for-the-badge&logo=redis&logoColor=white" alt="Redis" style="margin: 5px;">
  <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL" style="margin: 5px;">
  <img src="https://img.shields.io/badge/MyBatis-003B57?style=for-the-badge&logo=mybatis&logoColor=white" alt="MyBatis" style="margin: 5px;">
</div>

<div align="center" style="margin-top: 20px;">
  <img src="https://img.shields.io/github/issues/eatfans/CodeFellow.svg" alt="GitHub issues" style="margin: 5px;">
  <img src="https://img.shields.io/github/stars/eatfans/CodeFellow.svg" alt="GitHub stars" style="margin: 5px;">
  <img src="https://img.shields.io/github/forks/eatfans/CodeFellow.svg" alt="GitHub forks" style="margin: 5px;">
  <img src="https://img.shields.io/github/contributors/eatfans/CodeFellow.svg" alt="Contributors" style="margin: 5px;">
  <img src="https://img.shields.io/github/last-commit/eatfans/CodeFellow.svg" alt="Last Commit" style="margin: 5px;">
</div>
<br>
<br>
<br>
<br>
<br>
<br>

<div style="margin-top: 40px;">

**CodeFellow论坛 是一个基于 Maven、SpringBoot、MySQL、MyBatis、Redis 和 Vue 开发的开源论坛博客系统。
它采用了前后端分离的架构，用户端与管理员端功能分离，旨在提供一个简洁、高效的社区平台，满足用户分享知识和交流的需求。**
</div>

********

### 项目特点
* **前后端分离**：使用 Vue.js 实现了响应式的用户界面，与后端通过 RESTful API 进行通信。
* **用户端与管理员端分离**：用户和管理员拥有不同的权限和功能模块，保证了安全性和操作的便捷性。
* **安全可靠**：采用 Spring Security 进行用户认证和权限管理，并结合 Redis 实现了临时令牌的安全管理，防止重复请求和恶意攻击。
* **数据库持久化**：使用 MySQL 数据库存储用户信息、文章内容等数据，MyBatis 提供了与数据库的交互。
* **缓存优化**：利用 Redis 缓存常用数据，提高系统的访问速度和响应性能。
* **开发简便**：基于 Maven 构建管理工具和 SpringBoot 框架，简化了项目的配置和依赖管理。

### 技术栈
* **后端**：
  * SpringBoot：快速开发框架，简化配置和部署。
  * MyBatis：持久化框架，简化了与数据库的交互。
  * Redis：内存数据库，用于缓存和临时数据存储。
  * Spring Security：安全框架，保障用户认证和授权功能。
* **前端**：
  * Vue.js：流行的 JavaScript 框架，用于构建用户界面。
  * Vuex：Vue.js 的状态管理工具，用于集中管理应用状态。
  * Axios：用于处理前端与后端的 HTTP 请求和响应。

********

## 快速开始
### 后端部署

### 前端部署

********

## 贡献者
<table>
  <tr>
    <td align="center" style="padding: 10px;">
      <a href="https://github.com/eatfans">
        <img src="https://avatars.githubusercontent.com/u/122099628?s=400&u=3d10845f14b751dd240fee9001dfb5a8edc0a800&v=4" width="100px;" style="border-radius: 50%; border: none;" alt="eatfans"/>
        <br />
        <sub><b>EatFan (项目负责人/开发者)</b></sub>
      </a>
    </td>
  </tr>
</table>

## 许可证
本项目采用MIT 许可证 
