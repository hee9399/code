function onJoin(){

//[유효성검사]
	//각 폼 안에 있는 input들의 값 호출
	const joinForm=document.joinForm;
	if(joinForm.custno.value==''){
		alert('회원번호을 입력해주세요'); 
		joinForm.custno.focus(); //해당 위치로 마우스커서 이동
		return false;
		}
	if(joinForm.custname.value==''){alert('회원성명 입력해주세요'); joinForm.custname.focus();return false;}
	if(joinForm.phone.value==''){alert('회원번호 입력해주세요'); joinForm.phone.focus();return false;}
	if(joinForm.address.value==''){alert('회원주소를 입력해주세요'); joinForm.address.focus();return false;}
	if(joinForm.joindate.value==''){alert('가입일자를 입력해주세요'); joinForm.joindate.focus();return false;}
	if(joinForm.grade.value==''){alert('고객등급을 입력해주세요'); joinForm.grade.focus();return false;}
	if(joinForm.city.value==''){alert('도시코드를 입력해주세요'); joinForm.city.focus();return false;}
	
	alert('회원등록이 완료되었습니다')
	
	
		
	
	//1.폼 가져오기 (document.joinForm)
	document.joinForm.submit();//submit() 폼전송 vs reset() 폼초기화
		
}