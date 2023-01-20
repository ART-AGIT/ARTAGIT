$(document).ready(function() {
	//여기 아래 부분
	$('#summernote').summernote({
		toolbar: [
			//글씨체 굵게, 기울임, 밑줄, 지우기
			['style', ['bold', 'italic', 'underline', 'clear']],
			//글씨 취소선, 위에, 아래
			['font', ['strikethrough']],
			//글씨 사이즈 
			['fontsize', ['fontsize']],
			//색상 
			['color', ['color']]],
			height: 300, // 에디터 높이 
    minHeight: null, // 최소 높이 
    maxHeight: null, // 최대 높이 
    lang: "ko-KR", //한글 설정 
    placeholder: '최대 2048자까지 쓸 수 있습니다' //placeholder 설정 
			//정렬 
	});
  });