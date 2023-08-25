package java2.day24_제네릭.Ex3;
// 홈 렌탈 해주는 지점 
public class HomeAgency implements Rentable<Home> {
		@Override
		public Home rent() {return new Home();}
}
