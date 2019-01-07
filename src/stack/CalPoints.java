package stack;

import java.util.Stack;

public class CalPoints {
    public int calPoints(String[] ops) {
        Stack<Integer> scores = new Stack<>();//保存分数
//        Stack<String> characters = new Stack<>();//保存符号
        if(ops.length == 0) return 0;
        int sum = 0;//最后的总得分
        int score = 0;
        boolean isCancel = false;
        for(String str : ops) {
          if(str.equals("C")) {
              if(!scores.isEmpty()) {
                  score = scores.pop();//移除最后一轮的分数
                  isCancel = true;
              }
          } else if(str.equals("D")) {
              score = scores.peek() * 2;
              scores.push(score);//将本轮得分入栈
          } else if(str.equals("+")) {
              int pre = scores.pop();
              //记录此时的栈顶元素
              int prepre = scores.peek();
              scores.push(pre);
              score = pre + prepre;
              scores.push(score);//将本轮得分入栈
          } else {
              score = Integer.valueOf(str);
              scores.push(score);
          }
          if(isCancel) {
              sum -= score;

          } else {
              sum += score;//分数相加

          }
          isCancel = false;
          score = 0;//重置score

        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new CalPoints().calPoints(new String[] {"-52","-92","-70","C","+","26","17","+","17","+","-27","-46","73","D","+","D","-25","C","84","C"}));
    }
}
