package JavaCommonClassLibrary;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexLearning {
	public static void main(String[] args) {
		// 匹配
		String str = "123abc";
		System.out.println(str.matches("\\d+[a-c]+"));
		
		// 替换
		String str2 = "Hello666 World111 KarlRixon222";
		String regex = "\\d\\d\\d";
		System.out.println(str2.replaceAll(regex, ""));
		
		// 拆分
		String str3 = "Hello1World2KarlRixon3";
		String regex2 = "\\d";
		String strs[] = str3.split(regex2);
		for(int i=0; i<strs.length; i++) {
			System.out.println(strs[i]);
		}
		
		// Pattern类
		// splite
		String str4 = "Hello1World22Karl333Rixon";
		String regex3 = "\\d+";
		Pattern pattern = Pattern.compile(regex3);
		String result[] = pattern.split(str4);
		System.out.println(Arrays.toString(result));
		
		// matcher字符串验证
		String str5 = "100";
		String regex4 = "\\d+";
		Pattern pattern2 = Pattern.compile(regex4);
		Matcher mat = pattern2.matcher(str5);
		System.out.println(mat.matches());
	}
}
