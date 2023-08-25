package java2.day26_컬렉션프레임워크.Ex1_ArrayList;

import java.util.ArrayList;
import java.util.List;

import java2.day26_컬렉션프레임워크.Board;

public class Ex1_예제1 {

	public static void main(String[] args) {
		
		// 1. ArrayList 컬렉션 객체 생성 
		List<Board> list = new ArrayList<>();
			// 둘은 동일하다. 
		// ArrayList<Board> list2 = new ArrayList<>();
		System.out.println(" -------------- 1 : " +list);
		
		// 2. ArrayList 객체 안에 객체 추가 
			// 리스트객체명.add(객체) : 해당 객체를 리스트에 끝에 추가 
			// 리스트객체명.add(인덱스 , 객체) : 해당 객체를 리스트내 인덱스 위치에 추가한다 
			// 리스트객체명.set(인덱스 , 객체) : 해당 객체를 리스트내 인덱스 위치에 바꾼다
		list.add(new Board("제목1" , "내용1" , "글쓴이1" ) );
		list.add(new Board("제목2" , "내용2" , "글쓴이2" ) );
		list.add(new Board("제목3" , "내용3" , "글쓴이3" ) );
		list.add(new Board("제목4" , "내용4" , "글쓴이4" ) );
		list.add(new Board("제목5" , "내용5" , "글쓴이5" ) );
		list.add(0 , new Board("제목6" , "내용6" , "글쓴이6") ); // 인덱스 0번에 객체를 추가하고 한칸씩 뒤로 물려난다.
		list.add(1 , new Board("제목7" , "내용7" , "글쓴이7") );	// 인덱스 1번에 객체가 사라지고 해당객체를 추가한다.
		
		Board board = new Board("제목8", "내용8", "글쓴이8"); 	list.add(board);	// 보드 객체 생성후 리스트객체 에 추가o
		Board board2 = new Board("제목9", "내용9", "글쓴이9");
		
		// board - 스택   ,  new Board - 힙 list - 힙[ 번지수가들어가있음 ]
		// 리스트는 객체를 저장시키지않고 객체의 주소값을 저장시킨다.
		// 단 객체의 값을 알고있어야한다.
		
		System.out.println(" -------------- 2 : " +list);
		
		// 3. ArrayList 객체 안에 객체의 총 개수 
			// 리스트객체명.size() 		:	리스트내 저장된 객체 수 
		System.out.println(" -------------- 3 size() : " +list.size() +" 개"); // 배열명.length
		
		// 4. ArrayList 객체 안에 특징 객체 검색
			// 리스트객체명.get(인덱스)	: 	리스트내 해당 인덱스 위치에 객체 반환 
		System.out.println(" -------------- 4 get() : " +list.get(2) ); // 배열명[인덱스]
		System.out.println(" -------------- 4 contains() : " +list.contains(board) );
		System.out.println(" -------------- 4 contains() : " +list.contains(board2) );
		System.out.println(" -------------- 4 isEmpty() : " +list.isEmpty() );
		
		// 경계선 
		System.out.println("\n ======================= for문 종류 3가지 ============================= \n ");
			// 리스트의 반복문 활용 : 여러개 데이터를 순차적으로 순회 하는 방법
			// 1. for문 - [i를 인덱스로 활용해서 사용한다] 인덱스가 필요할때 사용한다.
		System.out.println("\n ======================== 1. for문  ======================== \n ");
			for(int i = 0; i<list.size(); i++) { // 배열일경우 - for(int i = 0; i<list.length(); i++)\
				// 인덱스 i 번째의 결과물 
				System.out.println(" 인덱스 : "+i+"  " + list.get(i)+ " ------------------ ");
				
			}// for e
			System.out.println("\n ====================================================== \n ");
			
			// 2. 항상된 for문   단점 : 인덱스를 알수없다 
			System.out.println("\n ======================== 2. 항상된 for문  ======================== \n ");
			int index = 0; // 인덱스로 사용할 변수 선언 
			for(Board b : list) {// 리스트내 객체를 자동으로 처음부터 처음부터 반복변수에 하나씩 대입하면  
				System.out.println(" 인덱스 "+index+" "+b);
				
			}// for e
			System.out.println("\n ====================================================== \n ");
			
			// 3. forEach( 반복변수명 -> { 실행코드 } ) - 함수 ,api , 라이브러리 ( 누군가미리만들어놓음 ) , 화살표함수를 이용한다.
			// list.forEach(b -> {} ); // 화살표함수 : java에서 - [ 매개변수 -> {실행코드} ] ,스크립트에서(js) - [ 매개변수 => {실행코드} ]
			System.out.println("\n ============================= 3. forEach( ) ========================= \n ");
			// 리스트내 객체를 자동으로 처음부터 끄티까지 매개변수 b에 하나씩 대입하고 { } 중괄호를 실행한다. 
			// 언제까지? 마지막 인덱스까지 
			// list에 b를 넣고 System으로 실행한다.
			list.forEach(b -> {System.out.println(b); } );
			// list.forEach(b , i) -> {System.out.println(b);};
			
		
		// 5. ArrayList 객체 안에 특정 객체 삭제 
			// 리스트객체명.remove(인덱스) : 리스트내 해당 인덱스 위치에 객체 삭제 / 1칸씩 당겨짐
			// 리스트객체명.remove(객체)	 : 리스트내 해당 객체가 존재하면 삭제 
			// 리스트객체명.clear()		 : 리스트ㅑ내 모든 객체 삭제 / 초기화 
		list.remove(2); // 리스트객체내 2번인덱스 객체 삭제 
		list.remove(board); // 리스트개채내 해당 board 객체가 존재하면 삭제 
		System.out.println(" -------------- 4 remove() : " +list );
		list.clear();
		System.out.println(" -------------- 4 clear() : " +list );
		
		
	}// main e
	
}// class e
