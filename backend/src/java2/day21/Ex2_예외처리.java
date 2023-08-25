package java2.day21;

public class Ex2_예외처리 {

	public static void main(String[] args) {
		
		// p. 470 : 다중 catch 사용이유 : 다양한 예외에 따른 서로 다른 흐름을 제어한다
		String[] array = {"100" , "loo"};
		
			// Integer.parseInt(문자열인숫자) : 문자열숫자 => 정수형숫자 정수로타입변환
			// System.out.println(Integer.parseInt("7")); // 문자 7 => 숫자7 형변환 가능
			// System.out.println(Integer.parseInt("ㄱ")); // 문자 ㄱ => 숫자 // NumberFormatException - 문자라서 숫자로판단할수없다 
		
		for(int i = 0; i<=array.length; i++) { // 인덱스:0~1 // 길이 : 2 // 인덱스 2는 없음
			try {
			// System.out.println(array[i]); // ArrayIndexOutOfBoundsException
			
			int value = Integer.parseInt(array[i]);
				// NumberFormatException : for input string: "loo"
			}
			// 예외클래스 catch 작성순서 : 하위 예외 클래스 블록 먼저 작성
			// catch (Exception e) {System.out.println("예외발생 : "+e);} // 예외 상위 클래스가 앞에 있으면 아래있는 하위 클래스들은 실행이안된다 
			catch (NumberFormatException e) {System.out.println("숫자로 변환 할수 없는 데이터 : "+e);}
			catch (ArrayIndexOutOfBoundsException e) {System.out.println("배열 인덱스 초과 : "+e);}
			// catch (NullPointException | ClassCastException e) {System.out.println();}
			catch (Exception e) {System.out.println("예외발생 : "+e);} // 예외 상위클래스는 아래에 있어야한다 
		}
		
	}// main e
}
