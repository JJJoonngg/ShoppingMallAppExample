# Shopping Mall App Example - Parayo
- 책 : [코틀린으로 쇼핑몰 앱 만들기](http://www.yes24.com/Product/Goods/89913111?scode=029)

<img width = "300" height = "400" src = "https://user-images.githubusercontent.com/52276038/84369198-75437c80-ac11-11ea-8e75-0017559b81e4.png"> 

- 책에 나온 [MVP(Minumum Viable Product)](https://ko.wikipedia.org/wiki/%EC%B5%9C%EC%86%8C_%EA%B8%B0%EB%8A%A5_%EC%A0%9C%ED%92%88) 프로젝트를 완성 시킨 간단한 중고 거래 애플리케이션 & 서버 API

- 코드가 갑자기 비약적으로 뛴다거나, 순서가 살짝 엉킨 부분이 있지만 소스코드 github을 참조하며 제작 하였고, 서버와 앱 간의 통신에 대한 이해,

  `REST API` , `MVVM` 등을 공부하기에는 좋은 책으로 느껴진다. 이미지가 업로드 되는 방법, Firebase를 이용하여 PUSH 알람을 띄우는 방법, AWS으로 테스트 서버를 구축하고,

  배포하는 방법 등 기초적인 전반적 지식들을 습득하기에 좋다고 생각한다.

  - 공식 Source Github - [App](https://github.com/benimario/parayo-android) (Android) ,  [Api](https://github.com/benimario/parayo-api) (Spring boot)

  - `MVVM` 패턴을 이용하여 Android를 제작하고 `Spring Boot`를 이용해 서버를 제작

  - 문제점 : http 통신을 받는 부분에서 오류가 생겨 `알 수 없는 오류가 발생`, 또한 macOS가 Catalina로 업데이트 되면서

    file의 직접적인 접근이 불가해져 경로 설정을 직접 해야함 - 해당 [commit](https://github.com/JJJoonngg/ShoppingMallAppExample/commit/6daef4f02af657d2287d649b7eb66f20e991a12c)

  - `Kolin` `Android Studio` `IntelliJ` `MySQL`

  - `Spring Boot` `FireBase` `jbcrypt` `AndroidX LifeCycle` `Glide` `Anko` `retrofit2`

  - 스크린샷

    <img width = "120" height = "200" src = "https://user-images.githubusercontent.com/52276038/84370569-63fb6f80-ac13-11ea-8754-f62b05afdc8f.png">   <img width = "120" height = "200" src = "https://user-images.githubusercontent.com/52276038/84370571-652c9c80-ac13-11ea-847c-35d5225d858c.png">   <img width = "120" height = "200" src = "https://user-images.githubusercontent.com/52276038/84370573-665dc980-ac13-11ea-867e-890eb5237393.png">   <img width = "120" height = "200" src = "https://user-images.githubusercontent.com/52276038/84370576-66f66000-ac13-11ea-9c6f-e3f10dea3571.png">

    <img width = "120" height = "200" src = "https://user-images.githubusercontent.com/52276038/84370578-678ef680-ac13-11ea-8521-135cf2b54802.png">   <img width = "120" height = "200" src = "https://user-images.githubusercontent.com/52276038/84370579-68278d00-ac13-11ea-899e-af62ea81c457.png">   <img width = "120" height = "200" src = "https://user-images.githubusercontent.com/52276038/84370582-68278d00-ac13-11ea-95d6-840ed3670631.png">   <img width = "120" height = "200" src = "https://user-images.githubusercontent.com/52276038/84370583-69f15080-ac13-11ea-81b1-a9cc5294361d.gif">

