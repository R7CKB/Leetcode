/**
 * @Title: Interpret_goal
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/9/30 18:28
 * @description: leetcode
 */
// leetcode 1678:https://leetcode.cn/problems/goal-parser-interpretation/
public class Interpret_goal {
//    public String interpret(String command) {
//        char[] chars = command.toCharArray();
//        StringBuilder sb = new StringBuilder();
//        int index = 0;
//        while (index < chars.length) {
//            if (chars[index] == 'G') {
//                sb.append('G');
//                index++;
//            } else if (chars[index] == '(') {
//                if (chars[index + 1] == ')') {
//                    sb.append('o');
//                    index += 2;
//                } else if (chars[index + 1] == 'a') {
//                    sb.append('a');
//                    sb.append('l');
//                    index += 4;
//                }
//            }
//        }
//        return sb.toString();
//    }

    // more easy way
    // 使用正则表达式进行替换
    public String interpret(String command) {
        command = command.replace("()", "o");
        command = command.replace("(al)", "al");
        return command;
    }

    public static void main(String[] args) {
        Interpret_goal obj = new Interpret_goal();
        String command = "G()(al)";
        System.out.println(obj.interpret(command));
    }
}
