package cn.karlrixon;

public class customExceptionLearning {
	public static class AddException extends Exception{
		/**
		 * 
		 */
		private static final long serialVersionUID = 6836634148155121570L;

		public AddException(String msg) {
			super(msg);
		}
	}
	public static void main(String[] args) {
		int num = 20;
		try {
			if(num > 10) {
				throw new AddException("数值传递过大");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
