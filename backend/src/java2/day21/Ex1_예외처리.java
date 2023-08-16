package java2.day21;

public class Ex1_예외처리 {
	
	// p.466
	public static void printLength(String data) {
		try { // 예외 발생 할것 같은 코드
		int result = data.length(); //  1. TgisIsJava => String 객체의 주소값 // 2. null => 객체의 주소값 없음 
									// 메소드는 객체마다들어가는것이아니고 메소드하나에 들어간다 
		System.out.println("문자수 : "+result);
		}catch (NullPointerException e) {  // 예외 발생 하면 이곳으로 이동하고 *예외 정보를 객채내 저장
			System.out.println(e.getMessage() );
			System.out.println(e); // 실무 : 오류 정보를 파일처리해서 추후에 문제 발생한 것들을 개발자 업데이트/유지보수
		}finally { // 예외 발생 하던 안하던 무조건 실행되는 코드 
			System.out.println("마무리 실행");
		}
	}
	
	public static void main(String[] args) {
		
		// p.466 
		System.out.println("프로그램 시작");
		printLength("TgisIsJava"); // 정상 실행 
		printLength(null);	// 예외 발생 NullPointerException => 프로그램 강제 종료 => 아래코드 실행x
		
		System.out.println("프로그램 종료");
		
		
		// p.468 : 일반 예외 : [ - 실행 전부터 컴파일러가 예외 검사 하기때문에 예외 필수 ] 
		try {// (실행예외) 예외가 발생할것 같은 코트 + (일반예외)예외 무조건 발생할것 같은 코드 
		Class.forName("java.lang.String"); // Class.forName : 클래스 찾기 	// java.lang.String : 
			System.out.println("java.lang.String 클래스 존재");
		// ClassNotFoundException : 만약에 클래스를 못찾았을때 예외처리 미리 해달라
		}catch (ClassNotFoundException e) { e.printStackTrace(); }
		
		try {
			Class.forName("java.lang.String2"); // Class.forName : 클래스 찾기 	// java.lang.String : 
				System.out.println("java.lang.String2 클래스 존재");
			// ClassNotFoundException : 만약에 클래스를 못찾았을때 예외처리 미리 해달라
			}catch (ClassNotFoundException e) { e.printStackTrace(); }
		
	}
	
}// class e

/*
 
 	에러 : 컴퓨터의 하드웨어 고장으로 인해 실행 오류가 발생
 	예외 : 에러 이외
 		- 1. 일반예외 : 컴파일러가 예외 처리 코드 여부를 검사하는 예외.
 			- 외부입출력 관련 :  파일처리 , JDBC(DAO) , 네트워크 , 입출력 
 		
 		- 2. 실행예외 : 예외 처리 코드 여부를 검사하지 않는 예외를 말함.
 			- 실행 도중에 오류가 발생하는것 : - 개발자의 경험에 외존해서 사용해야함
 			- 타입오류 , 배열인덱스 , NULL(주소값이없는데 함수로쓴다거나 , NULL이면 객체가없다는뜻/객체사용불가/메소드사용X) 
 			
 	예외처리
 		try{예외가 발생할것 같은 코드}
 		catch(예외클래스 변수객체){ 예외가 발생했을때 코드 }
 		finally{ 예외와 상관없이 항상 실행 코드 }
 
 
 	프로그램을 다운하면 강제 종료가되고 아래코드는 실행되지않아요
 
	예외처리를할께요 try catch를 해서 예외가 발생할것 같은 코드를 

	예외처리가 코드를 수정하는게 아니고 제어해주는거에요
	예외가 발생하면  catch로 이동하고 예외 정보를 객체내 저장한다는거에요 

	NullPointerException 이 오류가 뜨는 이유는 몰라요 
	경험을하는거에요 경험을 한 결과 실제오류가 NullPointerException 예외가 발생했다는 경험을 해본거에요
	어떤예외가 발생하는지는 처음에는 몰라요 

	e.getMessae() 를 써주면 예외 발생에 관련된 정보 들어있는 객체를 확인할수있어요

	finally 라는 애는 예외가 발생하던 말던 상관없이 실행되는 코드에요 

	제일중요한건 NullPointerException 이라는 오류라는걸 정보를 받아서 수정한다거나 고쳐준다거나 그렇게 생각하는게
	아니에요 프로그램의 예외가 발생했을때 코드를 정상적으로 실행해줄수있도록 그거를 유지해주는애가 예외 처리에요
	그런거 어떻게 알아요?
	대부분 프로그램이랑 소프트웨어는 테스트라는애가 있어요 어떤서비스를 f5를 할때 
	우리회사는 홈페이지를파는데 회사사이트를 만들어줘요 홈페이지를만들고 판매를해요
	근대 홈페이지에서 오류가 떠요 그러면 유지보수를 해줘야해요 
	이런오류를 try로 한번감싸는데 실무에서는 파일처리를해줘야해요 

	절대적인 유지보수가 필요해요 수정,업데이트,유지보수 그런거를 해줘야해요 
	왜중요하냐면 이런예외처리를해서 파일처리를 하는경우가 많아요 
	오류 정보를 파일처리해서 추후에 문제 발생한것들을 개발자 업데이트/유지보수 해줘야 한다는거에요 
 
 	코드적으로가아니라 접속했을때에 대한 오류가뜨기때문에 예외처리를 해줘야한다 
 	
	일반예외와 실행예외의차이점은 

 	* 일반예외는 실행 전부터 컴파일러가 예외 검사 하기때문에 예외 필수이다

 	* 실행예외는 실행 후 예외 발생하기 때문에 예외 처리하는 경험/테스트 후에
 
*/


















