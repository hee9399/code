package java2.day25_제네릭.Ex2;

import java1.day08.Student;

public class Ex2_와일드카드제네릭타입 {

	public static void main(String[] args) {
	
		// 1. 모든 사람이 신청 가능 
			// 1. 사람 객체
		Person person = new Person();
			// 2. 지원자 객체 [ 지원자객체에 사람 객체를 생성자 대입 ]
		Applicant<Person> applicant = new Applicant<>(person);
		
		// 3. 모든 객체가 지원 가능한 코스 등록 함수 
		Course.registerCourse1(applicant);
		
		// ------ 코스1 : ( 모든 지원서(사람,직장인,학생,고등학생,중학생) ) 누구나 등록 가능한 코스 
		Course.registerCourse1( new Applicant<Person>(new Person() ) );
		Course.registerCourse1( new Applicant<Worker>(new Worker() ) );
		Course.registerCourse1( new Applicant<Student>(new Student() ) );
		Course.registerCourse1( new Applicant<MiddleStudent>(new MiddleStudent() ) );
		
		// ------- 코스2 : 학생만 신청 가능 
			// Applicant< ? extlends Student > applicant
		
	}
}
