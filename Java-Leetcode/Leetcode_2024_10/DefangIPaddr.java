/**
 * @Title: DefangIPaddr
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/3 19:40
 * @description: leetcode 1108 easy
 */
// leetcode: https://leetcode.cn/problems/defanging-an-ip-address/
public class DefangIPaddr {

//    public String defangIPaddr(String address) {
//        return address.replaceAll("\\.", "[.]");
//    }

    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                sb.append("[.]");
            } else {
                sb.append(address.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DefangIPaddr ip = new DefangIPaddr();
        System.out.println(ip.defangIPaddr("1.1.1.1"));
    }
}
