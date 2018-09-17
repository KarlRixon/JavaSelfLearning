package link.karlrixon;

import java.util.Random;
import java.util.Set;
import java.util.HashSet;

public class Java容器 {
	public static void main(String[] args) {
		Random random=new Random(47);
        Set<Integer> intset=new HashSet<Integer>();
        for (int i=0;i<10000;i++){
            intset.add(random.nextInt(30));
        }
        System.out.print(intset);
	}
}
