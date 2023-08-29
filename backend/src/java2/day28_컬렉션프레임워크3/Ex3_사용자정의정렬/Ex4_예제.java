package java2.day28_컬렉션프레임워크3.Ex3_사용자정의정렬;

import java.util.TreeSet;

public class Ex4_예제 {
	public static void main(String[] args) {
		
		// 1. ( Frulit )정렬 구현객체 생성 
		FrulitComparator frulitComparator = new  FrulitComparator();
				
		// 2. TreeSet 객체 생성 		
		TreeSet<Frulit> treeSet = new TreeSet<>(frulitComparator);
		
		// 3. 무작위 Fruit 객체 대입 
		treeSet.add( new Frulit("포도", 3000) );
		treeSet.add( new Frulit("수박", 10000) );
		treeSet.add( new Frulit("딸기", 6000) );
		
		System.out.println(" 이진트리 상태 : "+treeSet);
		
	}// main e
}// class e

