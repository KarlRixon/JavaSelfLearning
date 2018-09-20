package JavaCommonClassLibrary;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

public class MathRandomBigIntegerBigDecimal {
	public static double round(double num, int scale) {
		return Math.round(num*Math.pow(10.0, scale))/Math.pow(10.0, scale);
	}
	public static boolean isRepeated(int temp[], int num) {
		if(num == 0) {
			return true;
		}
		for(int i=0; i<temp.length; i++) {
			if(temp[i] == num) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// 四舍五入
		System.out.println(Math.round(15.5));
		System.out.println(Math.round(-15.5));
		System.out.println(Math.round(-15.51));
		System.out.println(round(15.5545646454, 3));
		
		// 随机数
		Random rand = new Random();
		for(int i=0; i<10; i++) {
			System.out.print(rand.nextInt(100)+",");
		}
		System.out.println();
		
		//36选7
		int data[] = new int[7];
		int foot = 0;
		while(foot<7) {
			int t = rand.nextInt(36);
			if(!isRepeated(data, t)) {
				data[foot++] = t;
			}
		}
		Arrays.sort(data);
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]+",");
		}System.out.println();
		
		// 超过数据范围的计算
		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.MAX_VALUE*Double.MAX_VALUE);
		
		// BigInteger大整数
		BigInteger bgA = new BigInteger("216523763634353472896487987643546");
		BigInteger bgB = new BigInteger("12357837943343789345848645465");
		System.out.println("加法结果："+bgA.add(bgB));
		System.out.println("减法结果："+bgA.subtract(bgB));
		System.out.println("乘法结果："+bgA.multiply(bgB));
		System.out.println("除法结果："+bgA.divide(bgB));
		BigInteger result[] = bgA.divideAndRemainder(bgB);
		System.out.println("商："+result[0]+"，余数"+result[1]);
		System.out.println("幂运算："+bgA.pow(10));
		
		// BigDecimal大小数
		//,,,
	}
}
