package java2.day26_컬렉션프레임워크.Ex3_LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex3_예제 {
	public static void main(String[] args) {
		
		// 속도차이 	
		/*List - 구현객체 
		  List라는 인터페이스가 있다
		 // 인터페이스의 장점은? 바꿔치기가 가능하다 ArrayList 썻다가 Vector사용이 가능하다. 
		  	 구현체 
		  	  1. ArrayList
		  	  	- 정확한 데이터값이 정해지지않았을때 
		  	  2. Vector
		  	   	- 멀티스레드 사용하는 환경에서 권장한다. 멀티스레드가 아니여도 사용가능하다.( 예) 채팅구현할때 Vector를 사용한다)
		  	   	
		  	  3. LinkedList
		  	  	- 리스트내 많은 데이터를 중간 삽입,삭제 빈번할때 권장한다 ( 중간에 코드를 넣었다가 뺐다 하는경우가 많으면 권장한다는것이다.)
		  	  		ArrayList(동기를지원하지않는다) vs Vector( 동기를 지원한다 ) 
		  	  		- 사용방법동일 , 내부구도 동일 [ 차이점:비동기 vs 동기 ]
		  	  		
		  	  		ArrayList vs LinkedList 
		  	  		- 사용방법동일 , 비동기 [ 차이점: 배열구조 , 링크구 ]
		  	  		
		  	  - 리스트 객체 선언하는방법 [ 인터페이스 사용여부는 선택이다 ]
		  	  	// 인터페이스의 장점은? 바꿔치기가 가능하다 ArrayList 썻다가 Vector사용이 가능하다.
		  	  		List<String> list1 = new ArrayList<>();			또는		ArrayList<String> list1 = new ArrayList<>(); 
		  	  		List<String> list1 = new Vector<>();			또는		Vector<String> list1 = new Vector<>(); 
		  	  		List<String> list1 = new LinkedList<>();			또는		LinkedList<String> list1 = new LinkedList<>(); 
		  
		  	- 사용방법 동일 
		  	 	리스트객체명.add( 객체 )			 : 해당 객체를 마지막 인덱스에 객체 추가 
				리스트객체명.add( 인덱스 , 객체 ) 	 : 해당 객체를 리스트내 인덱스 위치에 추가 
				리스트객체명.set( 인덱스 , 객체 )	 : 해당 객체를 리스트내 인덱스 위치에 바꿈 
				리스트객체명.get( 인덱스 )		 : 리스트내 해당 인덱스 위치에 객체 반환 
				리스트객체명.contains( 객체 ) 	 : 리스트내 해당 객체가 있으면 true / 없으면 false
		  		리스트객체명.isEmpty()			 : 리스트내 객체가 모두 비어 있는지 true / 아니면 false
		  		리스트객체명.size()				 : 리스트내 저장된 객체 수
		  		리스트객체명.remove(인덱스)		 : 리스트내 해당 인덱스 위치에 객체 삭제 / 1칸씩 당겨짐 
		  		리스트객체명.remove(객체)			 : 리스트내 해당 객체가 존재하면 삭제 
		  		리스트객체명.clear()			 : 리스트내 모든 객체 삭제 / 초기화 			 			 			  
		  
		 
		  				  	추가			중간삽입		중간삭제 
		 	ArrayList  :  속도빠름			속도느림		속도느림
		 				ArrayList의 내부 구조는 인덱스로 저장한다 [ 0 ] [ 1 ] [ 2 ] [ 3 ] [ 4 ]
		 								주소/값 만저장한다	 31번지 32번지 33번지  34번지 35번지
 		 												  값		 값    값     값     값
		 												 ArrayList는 인덱스는 값을 저장한다 
		 								2번을	삭제했을때 	     [ 0 ] [ 1 ] [ x ] [ 3 ] [ 4 ]
		  
		   LinkedList  :  속도느림 		속도빠름		속도빠름
		   		LinkedList는 인접주소 , 인접한 앞주소와 뒤주소를 저장한다.  			
		   													   1의주소값을 0에저장 - 뒤주소 
		   													  32번지<- 32번지	
		   											앞주소
		   											뒤주소		  
		   							LinkedList의 내부 구조		  [ 0 ]---[ 1 ]---[ 2 ]---[ 3 ]---[ 4 ]
		   													 값		 값    값     값     값
		   													
		   									2번을	삭제했을때 	    [ 0 ]-[ 1 ]-     -[ 3 ]-[ 4 ]
		   --- 리스트내 중간 데이터 삽입/삭제 하는게 많으면 ArrayList는 비효율적이다 [ p.642 ]
		   --- 리스트내 중간 데이터를 삽입하거나/삭제 하는게 많으면 LinkedList 효율적이다
		   컴퓨터내부구조 자료구조에서 ArrayList , LinkedList가 있다
		   
		   
		   
		  */
		// ArrayList 객체
		List<String> list1 = new ArrayList<>();
			// ArrayList     vs   LinkedList 
			// 사용방법은 동일하지만  ,  내부구조 설계가 다르다
			// 배열[ ]에 객체저장하지만,  객체를 체인처럼 연결해서 사용한다 
			// .add( 객체 ) : 마지막 인덱스에 객체 추가 
			// .add( 인덱스 , 객체 ) : 해당 인덱스에 객체 추가 
		
		// LinkedList 객체 
		List<String> list2 = new LinkedList<>();
		
		// 두 객체의 저장 속도 체크 
		long stratTime; // 시작시간 
		long endTime;	// 끝시간 
		
		// 밀리초( 1/1000 초 ) 나노초( 1/1000000000 초)
		stratTime = System.nanoTime(); // 현재시간을 나노시간/초
												// 0 인덱스를  빼면 
		for(int i = 0; i<10000000; i++) {list1.add(0 , i+""); }
		endTime = System.nanoTime(); // 현재시간을 나노시간 으로 호훛/반환받는다.
		
		System.out.println("ArrayList 10000개를 저장하는데 걸리는 시간 : "+ (endTime-stratTime) );
		
		stratTime = System.nanoTime(); // 현재시간을 나노시간/초
		for(int i = 0; i<10000000; i++) {list2.add(0 , i+""); }
		endTime = System.nanoTime(); // 현재시간을 나노시간 으로 호훛/반환받는다.
		
		System.out.println("ArrayList 10000개를 저장하는데 걸리는 시간 : "+ (endTime-stratTime) );
		
		
		
		
	}// main e
}// class e
