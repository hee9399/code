package 과제.과제11;

import 과제.과제11.view.MainPage;

public class AppStart {

	public static void main(String[] args) {
		MainPage.getInstance().mainView();
		// MainPage.getInstance() : MainPage 싱글톤객체 호출( 해당 메소드를 사용하기위해 )
			// 반환 => mainPage객체가 반환된다. 
			// 2. mainPage.mainView()
			// getInstance() 에서 반환된 객체가 mainView(싱글톤객체) 함수를 호출
		
	}
	
}
