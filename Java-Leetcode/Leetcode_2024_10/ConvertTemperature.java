/**
 * Title: ConvertTemperature
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/10/26 09:29
 * Description: Leetcode 2469 easy
 */
// leetcode: https://leetcode.cn/problems/convert-the-temperature/
public class ConvertTemperature {
    //    public double[] convertTemperature(double celsius) {
//        double[] result = new double[2];
//        result[0] = celsius + 273.15;
//        result[1] = celsius * 1.8 + 32.00;
//        return result;
//    }
    public double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15, celsius * 1.80 + 32.00};
    }
}
