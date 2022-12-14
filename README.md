## git commit message convention
//type 더 추가하고 싶으면 얼마든지  
✨ feat : 새로운 기능에 대한 커밋   
🐛 fix : 버그 수정에 대한 커밋  
👷 build : 빌드 관련 파일 수정에 대한 커밋   
🔨 chore : 그 외 자잘한 수정에 대한 커밋(rlxk qusrud)   
💚 ci : CI 관련 설정 수정에 대한 커밋     
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
