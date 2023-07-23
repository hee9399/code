package 연습_1;
import java.util.Scanner;

public class 연습2 {
	   public static void main(String[] args) {// main s

		      Scanner scanner = new Scanner(System.in);
		      
		      
		      int 콜라재고 = 10;
		      int 환타재고 = 10;
		      int 사이다재고 = 10;

		      int 콜라바구니 = 0;
		      int 환타바구니 = 0;
		      int 사이다바구니 = 0;

		      int 콜라가격 = 300;
		      int 환타가격 = 200;
		      int 사이다가격 = 100;

		      // 비교하는 거를 만들어야 하는데
		      while (true) {// 무한루프
		      
		         System.out.println("메뉴");
		         System.out.println("1.콜라 2. 사이다 3.환타 4.결제 : ");
		         int drink = scanner.nextInt();
		         if (drink == 1) {
		            if (콜라재고 > 0) {
		               콜라재고--;
		               콜라바구니++;
		            } else {
		               System.out.println("콜라재고부족");
		            }
		         }
		         if(drink==2) {
		            if (사이다재고 > 0) {
		               사이다재고--;
		               사이다바구니++;
		            } else {
		               System.out.println("사이다재고부족");
		            }
		         }
		         if(drink==3) {
		            if (환타재고 > 0) {
		               환타재고--;
		               환타바구니++;
		            } else {
		               System.out.println("환타재고부족");
		            }
		         }
		         if(drink==4) {//선택한 얘들의 상태를 보여줘야하는데
		            //바구니, 가격을 보여준다?
		            System.out.println("현재 장바구니 현황 표시목록");
		            System.out.println("-------------------------");
		            System.out.println("제품명      수량   가격");
		            // 유효성 검사
		            // 바구니 가 0이면 출력x 아니면 상태출력o
		            if(콜라바구니 !=0) {
		               System.out.println("콜라\t" +  콜라바구니 +"    "+ 콜라가격);   
		            }
		            if(사이다바구니 !=0) {
		               System.out.println("사이다\t" +   사이다바구니+"     "+ 사이다가격 );
		            }
		            if(환타바구니!=0) {
		               System.out.println("환타\t" +   환타바구니 +"      "+ 환타가격);
		            }
		            //총가격
		            
		            int sum = (콜라바구니*콜라가격)+(사이다바구니*사이다가격)+(환타바구니*환타가격);
		            System.out.println("총가격 :"+sum);
		            // sum을 받고
		               if(sum>1) {
		                  System.out.println("1.결제  2.취소");
		                  int select = scanner.nextInt();
		                  //결제나 취소를 선택했을 때
		                  if(select==1) {
		                     //sum-내가 입력한 가격=잔액  -> (결제성공시)잔액이 있을경우
		                     //sum>내가입력한가격 -> 결제성공 -> 장바구니=0
		                     //내가 입력한 가격을 어떻게 알 수 있을까.
		                     int money = scanner.nextInt();
		                     if(sum<=money) {
		                        System.out.println(sum-money+"결제성공");
		                        콜라바구니=0; 사이다바구니=0; 환타바구니=0;
		                     }
		                     else {
		                        System.out.println("잔액부족");
		                        콜라재고+=콜라바구니;
		                        사이다재고+=사이다바구니;
		                        환타재고+=환타바구니;
		                        콜라바구니=0; 사이다바구니=0; 환타바구니=0;
		                     }
		                  }
		                  if(select==2) {
		                     //장바구니 = 0 , 재고 =0
		                     콜라재고+=콜라바구니;
		                     사이다재고+=사이다바구니;
		                     환타재고+=환타바구니;
		                     콜라바구니=0; 사이다바구니=0; 환타바구니=0;
		                  }
		               }
		            
		            
		            
		            
		            
		         }
		         
		         
		      }// while end

		      
	   }	// main e
	   
} // class e
