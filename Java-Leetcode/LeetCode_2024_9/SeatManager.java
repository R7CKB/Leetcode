package LeetCode_2024_9;

import java.util.PriorityQueue;

/**
 * @Title: SeatManager
 * @Author R7CKB
 * @Package LeetCode
 * @Date 2024/9/30 14:20
 * @description: leetcode
 */
// leetcode: https://leetcode.cn/problems/seat-reservation-manager/
// 使用数组实现:笨方法
// 必定会超时,因为数组长度会过大
//public class SeatManager {
//    // 使用数据结构来表示座位的被预约情况
//    // 使用栈无法实现，因为栈的特性是先进后出，而且栈无法保证预约的时候是最小的
//    // 使用集合无法实现,而且集合无法保证预约的时候是最小的
//    // 使用数组实现的话:,如何寻找最小的空闲位置？
//    long[] seats;
//
//    public SeatManager(int n) {
//        this.seats = new long[n + 1];
//        for (int i = 0; i < n; i++) {
//            seats[i] = 0;
//        }
//    }
//
//    public int reserve() {
//        int seatNumber = minAvailable();
//        seats[seatNumber] = 1;
//        return seatNumber;
//    }
//
//    public void unreserve(int seatNumber) {
//        seats[seatNumber] = 0;
//    }
//
//    // 寻找最小的空闲位置
//    public int minAvailable() {
//        int min = Integer.MAX_VALUE;
//        for (int i = 1; i < seats.length; i++) {
//            if (seats[i] == 0) {
//                min = Math.min(min, i);
//            }
//        }
//        return min;
//    }
//
//    public static void main(String[] args) {
//        SeatManager seatManager = new SeatManager(5);
//        System.out.println(seatManager.reserve());
//        System.out.println(seatManager.reserve());
//        seatManager.unreserve(2);
//        System.out.println(seatManager.reserve());
//        System.out.println(seatManager.reserve());
//        System.out.println(seatManager.reserve());
//        System.out.println(seatManager.reserve());
//        seatManager.unreserve(5);
//    }
//}

// 使用堆的简单方法:
//class SeatManager {
//    PriorityQueue<Integer> seats;
//
//    public SeatManager(int n) {
//        seats = new PriorityQueue<>();
//        for (int i = 1; i <= n; i++) {
//            seats.add(i);
//        }
//    }
//
//    public int reserve() {
//        return seats.poll();
//    }
//
//    public void unreserve(int seatNumber) {
//        seats.add(seatNumber);
//    }
//
//
//    public static void main(String[] args) {
//        SeatManager seatManager = new SeatManager(5);
//        System.out.println(seatManager.reserve());
//        System.out.println(seatManager.reserve());
//        seatManager.unreserve(2);
//        System.out.println(seatManager.reserve());
//        System.out.println(seatManager.reserve());
//        System.out.println(seatManager.reserve());
//        System.out.println(seatManager.reserve());
//        seatManager.unreserve(5);
//    }
//}

// 灵神的方法
// 思路:
// 想象有一个空房间，一开始没有椅子。
// 如果有人进入了房间（reserve），我们可以添加一把新的椅子给人坐（如果没有空出来的椅子）。
// 如果有人离开了椅子（unreserve），后面来的人不需要新的椅子，直接坐空出来的椅子就行。
// 直到所有椅子都被坐满，此时必需要添加一把新的椅子给人坐。
// 实现:
// 用一个变量 seats 表示目前房间内有多少把椅子，初始值为 0。用一个最小堆 available 维护空出来的椅子编号，初始为空。
// 对于 unreserve(seatNumber)，把 seatNumber 入堆。
// 对于 reserve，如果堆不为空（有空出来的椅子），就弹出并返回堆顶；否则把 seats 加一（添加一把新的椅子），然后返回 seats。
// 妙啊！
class SeatManager {
    private final PriorityQueue<Integer> available = new PriorityQueue<>();
    private int seats;

    public SeatManager(int n) {

    }

    public int reserve() {
        if (!available.isEmpty()) { // 有空出来的椅子
            return available.poll(); // 坐编号最小的
        }
        return ++seats; // 添加一把新的椅子
    }

    public void unreserve(int seatNumber) {
        available.add(seatNumber); // 有人离开了椅子
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */