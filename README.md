### 安卓架构，待实现功能点：
- [x] compose-first（实现Single Activity Application(SAA)）
- [x] ktor请求
- [x] viewmodel
- [x] StateFlow
- [x] hilt
- [x] navigation-compose
- [x] 底部导航栏bottomBar
- [ ] deeplink
- [ ] 定制Application，实现全局context

项目说明：
1. gradle构建，需要使用jdk 17
2. 报错：[Hilt] Expected @AndroidEntryPoint to have a value. Did you forget to apply the Gradle Plugin? (com.google.dagger.hilt.android)，解决：1.build.gradle.kts的plugins里添加：id("com.google.dagger.hilt.android") version "2.51.1" apply false，2.app/build.gradle.kts的plugins里需要添加：id("com.google.dagger.hilt.android")

资料 | 说明
--- | ---
异步请求框架Ktor | https://weread.qq.com/web/reader/4963226071e98fdd496000f
