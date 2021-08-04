# 프로젝트 잉어(inger)

## 목차

- [프로젝트 소개](#프로젝트-소개)   
- [잉어?](#잉어?)   
- [프로젝트 명세](#프로젝트-명세)
  - [배포 환경](#배포-환경)
  - [개발 환경](#개발-환경)
  - [Design Resources](#design-resources)
  - [핵심 라이브러리](#핵심-라이브러리)
<br>

## 프로젝트 소개
잉어는 webRTC기반 영상 공유 기술을 활용한 온라인 웹 스터디 서비스 입니다.
웹 스터디는 온라인 환경에서 자신이 공부하는 모습이나 내용을 공유하는 서비스입니다.
코로나19사태 이후 오프라인에서 다 같이 모여서 공부 할 수 없는 상황이 되며
자택 등 실내에서 혼자 공부를 해야 하는 경우가 이전보다 많아졌습니다.
이런 상황에서도 웹 스터디는 여럿이 같은 공간에서 학습하고 있는 느낌을 줄 수 있습니다.
코로나19사태 이후 몇개월이 채 지나지 않아 웹 스터디 서비스 사용량이 증가하고 있다는 것과,
10대들의 온라인 스터디 앱 활용량이 증가하는 것을 확인 할 수 있었습니다.
기존의 온라인 스터디는 주최자가 조건을 설정하여 방 또는 그룹을 개설하면, 마음에 드는 사람이 참여하는 방식이 주를 이루고 있습니다.
저희 팀에서는이러한 중간 과정을 줄여 공부에 좀 더 초점을 맞추는 시도를 하게 됐습니다.
또한 학습 시간 등으로 경쟁심을 유발하여 학습 의지를 높히거나, 학습 내용을 공유하는 부담감을 줄이고자
캘린더를 가꿔나가고 상호작용 없이 자유롭게 열람하는 개인 맞춤형 서비스에 초점을 맞췄습니다.
<br>

## 잉어?
잉어는 ~ing와 ~er을 이어 붙여, 저희가 새롭게 만든 단어입니다. '무언가를 하고 있는 사람' 이라는 뜻을 가지고 있는데,
목표로 하는 '직업'이 아닌 목표로 하는 '행위'에 초점을 맞추고자 하는 저희 사이트의 가치를 담고 있습니다.
예시로 나는 '작가'가 되기 위해 노력하는 것이 아닌, '글을 쓰기'위해 노력한다는 것입니다.
우리들이 해 온 노력들은 직업에 가려지기 쉬운데, 사용자들이 매일매일 하고 있는 일이 의미 있는 일임을 상기시켜주고 싶어서 이러한 이름을 짓게 됐습니다.
<br>

## 프로젝트 명세
### 배포 환경
- __URL__ : 
- __배포 여부__ : O / X
- __접속 가능__ : 접속 가능 / 수정 중
- __HTTPS 적용__ : O / X
- __PORT__ : // 3rd Party에서 사용하는 포트가 있다면 기입해주세요. <- 기입 후 해당 주석 삭제
<br>

### 개발 환경
#### Front-end / Android
- __Framework__ : Vue.js / React / Android / Unity
- __지원 환경__ : Web / Mobile / Web App / Native App
- __담당자__ : 팀원 A, 팀원 B,
<br>

#### Back-end
- __Framework__ : Spring boot / Node.js / Django / Flask
- __Database__ : MySQL / MariaDB
- __담당자__ : 팀원 A, 팀원 B,
<br>

#### Design
- __Framework 사용__ : O / X
  - [Vuetify](https://vuetifyjs.com/)
  - [Element Plus](https://element-plus.org/)
- __Design Tool 사용__ : Adobe XD, Photoshop, Blender, Zeplin 등 (없을 경우 빈칸)
- __담당자__ : 팀원 A, 팀원 B,
<br>

### Design Resources
__외부 템플릿 또는 에셋__ (이미지 또는 링크 첨부)
- 무료 이미지, 아이콘, 폰트 등은 제외
- [Vue Argon Design System](https://www.creative-tim.com/product/vue-argon-design-system?affiliate_id=116187) (무료)
  - __사용 기능__ : 디자인 전반 적용
- [Vue Black Dashboard Pro](https://www.creative-tim.com/product/vue-black-dashboard-pro?affiliate_id=116187) (유료)
  - __사용 기능__ : 캘린더 컴포넌트 사용
<br>

__자체 제작 산출물__ (필요시 이미지 또는 설명 첨부)
- LOGO
- CardView
- Button
- Calendar
<br>

### 핵심 라이브러리
기본 제공하는 라이브러리 외 핵심 기능 구현에 사용한 라이브러리가 있다면 작성해주세요.   
예시 ) VR/AR 라이브러리, 애니메이션 라이브러리, 텍스트/사진/동영상 지원, 편집 라이브러리 등

- __AR CORE__
  - __링크__ : https://developers.google.com/ar
  - __소개__ : 구글에서 제공하는 AR 지원 라이브러리
  - __사용 기능__ : 이미지 인식, 이미지 위 영상 표시
  - __담당자__ : 팀원 A, 

- __COLOR THIEF__
  - __링크__ : https://lokeshdhakar.com/projects/color-thief/
  - __소개__ : 이미지에서 색상을 추출해주는 라이브러리
  - __사용 기능__ : 커버 사진에서 색상 추출 -> 배경 색상 변경
  - __담당자__ : 팀원 A,

- __Animate.css__
  - __링크__ : https://animate.style/
  - __소개__ : css 애니메이션 지원 라이브러리
  - __사용 기능__ : 메인 페이지 진입 시 애니메이션 사용
  - __담당자__ : 팀원 A,


