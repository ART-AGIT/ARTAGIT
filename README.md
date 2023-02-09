# SpringBoot-Project-ARTAGIT
전시 소개 플래폼  
## 프로젝트 소개  
Art Agit
아트아지트 입니다.

## 개발기간  
2022-12-10 - 진행중  

### 멤버구성
주성균(조장) : 각자 맡은역할 쓰기  aka.천둥호랭이🐱    
김정현 :   소음인  
양호정 :   선베  
황보은진 :    
이진희 :   청양고추 성애자  
이상민 :    
김유민 :  귀여움담당  


## ⚙ 개발환경
- java 17
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white">
<img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black">
- jkd 17.0.4
- IDE STS 4.0
- database : maria DB
- ORM : Mybatis

## git commit message convention  
### 제목 (Subject)  
- 커밋 메시지 제목은 제일 앞에 제목의 타입을 붙여준다. 커밋 타입의 종류는 위 내용을 참고한다.  
- 제목은 50자를 넘기지 않고, 대문자로 작성하고 마침표를 붙이지 않는다.  
- 과거 시제를 사용하지 않고 명령어로 작성한다.  
- 커밋 유형들이 복합적인 경우에는 최대한 분리하여 커밋한다.    

### 본문 (Body)
- 선택 사항이므로 작성하지 않아도 무방하다.  
- 부연설명이 필요하거나 커밋의 이유를 전달해야할 경우 작성한다.  
- 내용은 어떻게 변경하였는지 보다 무엇을, 왜 변경하였는지를 설명하는 위주로 작성한다.  
- 한 줄이 72자를 넘기지 안고 제목과 구분되게 한 줄을 띄우고 작성한다.  
### 푸터 (Footer)
- 선택 사항이기 때문에 작성하지 않아도 무방하다  
- 보통 이슈를 추적하기 위해 이슈 트래커 ID를 넣어주는 용도로 사용된다.  
<br>
<br>

//type 더 추가하고 싶으면 얼마든지  
✨ feat : 새로운 기능에 대한 커밋   
🐛 fix : 버그 수정에 대한 커밋  
👷 build : 빌드 관련 파일 수정에 대한 커밋   
🔨 chore : 그 외 자잘한 수정에 대한 커밋(rlxk qusrud)   
📝 docs : 문서 수정에 대한 커밋   
💄 style : ui 스타일에 관한 커밋   
🎨 refactor : 코드 리팩토링에 대한 커밋   
✅ test : 테스트 코드 수정에 대한 커밋  
🎉 init : 프로젝트 시작에 대한 커밋  
🔖 release: 릴리즈에 대한 커밋  
➕ plus : add dependency   
➖ minus : remove dependency  


//body  
무엇을, 왜(What, Why)에 대해서 작성  
ex)   
1 기능 추가   
- 1.ts : 쏼라  
- 2.ts : 쏼라  

//footer  
해결, 관련, 참고  
ex) 해결: {이슈번호}  

//예시  
✨ feat : 홈 검색기능 추가  

홈에서 검색기능 추가  
- searchViewController.swift: 검색 api function 추가, 검색 되었을때 emptyStateView 보이게 추가  
- emptyStateView.swift: 검색결과 없을시 뜨는 view 로직 추가  

해결: PI-323  
