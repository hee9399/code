package java2.day28_컬렉션프레임워크3.Ex3_사용자정의정렬;

import java.util.Comparator;

public class FrulitComparator implements Comparator<Frulit> {

	@Override
	public int compare(Frulit o1, Frulit o2) {
		if(o1.price < o2.price ) return -1;
		else if(o1.price == o2.price) return 0;
		else return 1;
	}
	
}
