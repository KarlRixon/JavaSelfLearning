package JavaCommonClassLibrary;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateClassLearning {
	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		System.out.println(date);
		
		long cur = System.currentTimeMillis();
		Date date2 = new Date(cur);
		System.out.println(date2);
		System.out.println(cur);
		System.out.println(date.getTime());
		
		// 日期格式化
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss.sss");
		String str = sdf.format(date);
		System.out.println(str);
		
		// 字符串转换为日期
		String str2 = "2022-07-22 19:18:50.555";
		Date date3 = sdf.parse(str2);
		System.out.println(date3);
		
		// SimpleDateFormat可以自动处理错误的时间数
		String str3 = "2029-19-55 55:66:77.999";
		Date date4 = sdf.parse(str3);
		System.out.println(sdf.format(date4));
		System.out.println(date4);
		
		// Calendar类
		Calendar cal = Calendar.getInstance();					//取得本类对象
		StringBuffer buf = new StringBuffer();					//保存日期时间数据
		buf.append(cal.get(Calendar.YEAR)).append("-");			//取得年数据
		buf.append(cal.get(Calendar.MONTH)+1).append("-");		//取得月数据，从0开始
		buf.append(cal.get(Calendar.DAY_OF_MONTH)).append(" ");	//取得天数据
		buf.append(cal.get(Calendar.HOUR_OF_DAY)).append("-");	//取得小时数据
		buf.append(cal.get(Calendar.MINUTE)).append("-");		//取得分数据
		buf.append(cal.get(Calendar.SECOND));		//取得秒数据
		System.out.println(buf);
	}
}
