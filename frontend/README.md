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
│   │   ├── Main/
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
│   ├── containers/
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
│   ├── modules/
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





