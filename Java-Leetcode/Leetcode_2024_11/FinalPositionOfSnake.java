import java.util.List;

/**
 * Title: FinalPositionOfSnake
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/11/2 10:12
 * Description: Leetcode 3248 easy
 */
// leetcode: https://leetcode.cn/problems/snake-in-matrix/
public class FinalPositionOfSnake {
    // 模拟方法.但是没有使用矩阵的性质
//    public int finalPositionOfSnake(int n, List<String> commands) {
//        int position = 0;
//        for (String command : commands) {
//            if (command.equals("UP")) {
//                position -= n;
//            } else if (command.equals("DOWN")) {
//                position += n;
//            } else if (command.equals("LEFT")) {
//                position -= 1;
//            } else if (command.equals("RIGHT")) {
//                position += 1;
//            }
//        }
//        return position;
//    }

    // 灵神的方法.使用矩阵的性质
    public int finalPositionOfSnake(int n, List<String> commands) {
        int i = 0;
        int j = 0;
        for (String command : commands) {
            switch (command.charAt(0)) {
                case 'U':
                    i--;
                    break;
                case 'D':
                    i++;
                    break;
                case 'L':
                    j--;
                    break;
                case 'R':
                    j++;
                    break;
            }
        }
        return i * n + j;
    }
}
