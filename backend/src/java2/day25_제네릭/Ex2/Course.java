package java2.day25_제네릭.Ex2;

import java1.day08.Student;

public class Course {

	// 1. 모든 사람이면 등록 가능 [ 매개변수에 모든 타입이 가능하다 ]
	public static void registerCourse1(Applicant<?> applicant) {
		
		// 1. 타입 확인
		System.out.println(applicant.kind.getClass().getSimpleName() );
		
	}
	
	// 2. 학생만 등록 가능 [ 매개변수에 student 클래스와 자손 클래스의 타입 가능 ]  Applicant< ?  extends Student >
		public static void registerCourse2( Applicant< ?  extends Student > applicant ) {
			// 1. 타입 확인 
			System.out.println( applicant.kind.getClass().getSimpleName() );
		}
	
	// 3. 직장인 및 일반인만 등록 가능 [ 매개변수에 Worker 클래스의 부모 클래스 타입 가능 ]
	public static void registerCourse3(Applicant<? super Worker> applicant) {
		// 1. 타입 확인
		System.out.println(applicant.kind.getClass().getSimpleName() );
		
	}
	
}
