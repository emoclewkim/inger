# Front-End

## Tree

```
├── README.md
│
├── public/
│   ├── index.html
│   ├── img/
│   │   ├── inger_background6.png
│   │   ├── inger.ico
│   │   └── inger.png
│   │
├── src/
│   ├── App.css
│   ├── App.js
│   │── index.css
│   │── index.js
│   │── reportWebVitals.js
│   │
│   ├── api/ 							axios요청. 백엔드와 통신.
│   │   ├── createRequestSaga.js
│   │   ├── admin/
│   │   │   └── adminSetting.js
│   │   │
│   │   ├── auth/
│   │   │   │── memberSetting.js
│   │   │   └── userAuthoriazaion.js
│   │   │
│   │   ├── session/
│   │   │   └── index.js
│   │   │
│   │   ├── timer/
│   │   │   └── timer.js
│   │   │
│   │   └── user/
│   │       └── index.js
│   │
│   ├── common/
│   │
│   └── components/
│   │   ├── buttons/
│   │   │   ├── RoomClose/
│   │   │   ├── RoomPause/
│   │   │   └── RoomPlay/
│   │   │
│   │   ├── Entrance/
│   │   │   ├── CommonLogin/
│   │   │   ├── DirectorSetting/
│   │   │   ├── Introduce/
│   │   │   ├── KakaoLogin/
│   │   │   └── MemberSetting/
│   │   │
│   │   ├── Main/       캘린더, 투두리스트 컴포넌트
│   │   │   ├── HorizontalTabs/
│   │   │   ├── MyCalendar/
│   │   │   │   ├── CalendarComponent/
│   │   │   │   ├── CalendarDiary/
│   │   │   │   └── CalendarPromise/
│   │   │   │
│   │   │   └── MyTodolist/
│   │   │       ├── TodolistAdd/
│   │   │       └── TodolistComponent/
│   │   │
│   │   ├── Room/
│   │   │   ├── Drawer/ 				다짐, 일기를 부모 컴포넌트와 공유.
│   │   │   │
│   │   │   ├── DrawerContentContainer/
│   │   │   │   ├── DrawerProfile/
│   │   │   │   │   ├── RemoteCalendar/
│   │   │   │   │   ├── RemoteDiary/
│   │   │   │   │   └── RemotePromise/
│   │   │   │	│
│   │   │   │   └── DrawerTodo/
│   │   │   │
│   │   │   ├── RoomAppbar/
│   │   │   │
│   │   │   ├── Screen/ 				실제 스크린 컴포넌트가 보여지는 영역
│   │   │   │   ├── Name/
│   │   │   │   ├── Rest/
│   │   │   │   └── Timer/
│   │   │   │
│   │   │   └── ScreenContainer/		스크린을 담는 컨테이너 영역
│   │   │
│   │   └── Webrtc/
│   │
│   ├── containers/         리덕스 스토어에 접근하는 컴포넌트 담는 폴더
│   │   ├── DirectorSettingContainer.js
│   │   ├── DrawerContainer.js
│   │   ├── DrawerProfileContainer.js
│   │   ├── DrawerTodoContainer.js
│   │   ├── HeaderContainer.js
│   │   ├── HorizontalTabsContainer.js
│   │   ├── LoginContainer.js
│   │   ├── MemberSettingContainer.js
│   │   ├── MyCalendarContainer.js
│   │   ├── MyTodolistContainer.js
│   │   └── StudyTimeContainer.js
│   │
│   ├── font/
│   │
│   ├── layout/
│   │   ├── Footer/
│   │   └── Header/
│   │
│   ├── modules/        redux reducer들 담는 폴더
│   │   ├── directorSetting.js
│   │   ├── index.js
│   │   ├── memberSetting.js
│   │   ├── setCalendar.js
│   │   ├── setIsRandomRoom.js
│   │   ├── setLightMode.js
│   │   ├── setTodolist.js
│   │   ├── studyTime.js
│   │   └── userAuthorization.js
│   │
│   ├── pages/
│   │   ├── Admin/
│   │   ├── DirectorSetting/
│   │   ├── Entrance/
│   │   ├── KakaoLogin/
│   │   ├── Main/
│   │   ├── MemberSetting/
│   │   └── Room/
│   │
│   └── utils/ 							재사용 하는 함수
│       ├── calendar.js
│       ├── data.js
│       ├── event.js
│       ├── header.js
│       ├── room.js
│       └── timer.js
│
├── .env
├── .gitignore
├── package-lock.json
├── package.json
└── node_modules
```

# 폴더 구성 방법

- 리덕스 스토어에 접근해야 하는 컴포넌트의 상위 컴포넌트를 생성해서 container 폴더에 함께 관리를 하도록 구성했다.
- 리덕스 스토어의 action을 dispatch한 함수와 state들을 props로 전달해서 하위 컴포넌트들이 접근할 수 있도록 했다.

# container 폴더 생성 이유

- 유지 보수와 재사용성
  - 프레젠테이션 컴포넌트에는 스타일, DOM 마크업, component local state 위주로 갖고 있고, 컨테이너 컴포넌트에는 데이터들의 상태나 action을 dispatch한 함수를 갖고 있으므로 나눠서 관리하게 되어서 유지보수하기 좋다.
  - 같은 프레젠테이션 컴포넌트에서 여러개의 컨테이너 컴포넌트를 사용할 수 있고 다른 프레젠테이션 컴포넌트에서 이미 있는 컨테이너 컴포넌트를 사용할 수 있기 때문에 재사용성이 좋다.
