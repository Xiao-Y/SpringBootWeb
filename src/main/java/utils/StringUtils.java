package utils;

public class StringUtils {

	/**
	 * 去掉右边的空白
	 * 
	 * <br>
	 * added by liuyongtao<br>
	 * 
	 * @param str
	 * @return
	 * 
	 * @date 2016年11月25日 下午5:35:34
	 */
	public static String rightTrim(String str) {
		if (str == null) {
			return "";
		}
		int length = str.length();
		for (int i = length - 1; i >= 0; i--) {
			if (str.charAt(i) != ' ') {
				break;
			}
			length--;
		}
		return str.substring(0, length);
	}
}
