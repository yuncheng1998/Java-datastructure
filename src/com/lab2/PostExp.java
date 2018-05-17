package com.lab2;

import java.util.Stack;

class PostExp {
    private String postExp;
    private double value;

    PostExp(String inExp) {
        String postExp;
        try {
            postExp = toPostExp(inExp);
        } catch (NumberFormatException e) {
            System.out.println("非数字 ");
            return;
        } catch (IllegalArgumentException e) {
            System.out.println("运算符错误 " + e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println("表达式错误 ");
            return;
        }
        this.postExp = postExp;
    }

    private String toPostExp(String input) throws IllegalArgumentException {

        StringBuilder stringBuilder = new StringBuilder();

        int len = input.length();
        char c, temp;
        Stack<Character> characterStack = new Stack<>();
        Stack<Double> doubleStack = new Stack<>();
        double number;
        int lastIndex;
        for (int i = 0; i < len; ++i) {
            c = input.charAt(i);
            if (Character.isDigit(c) || c == '.') {
                lastIndex = getNumber(input, i);
                number = Double.parseDouble(input.substring(i, lastIndex));//把字符串的数字转化为double类型
                doubleStack.push(number);//遇到数字就进栈
                i = lastIndex - 1;
                stringBuilder.append(number);
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!characterStack.isEmpty() && characterStack.peek() != '(' && operatorCmp(c, characterStack.peek())) {
                    stringBuilder.append(characterStack.peek());
                    double num1 = doubleStack.pop();
                    double num2 = doubleStack.pop();
                    doubleStack.push(getResult(characterStack.pop(), num2, num1));
                }
                characterStack.push(c);
            } else if (c == '(') {
                characterStack.push(c);
            } else if (c == ')') {
                while ((temp = characterStack.pop()) != '(') {
                    stringBuilder.append(temp);
                    double num1 = doubleStack.pop();
                    double num2 = doubleStack.pop();
                    doubleStack.push(getResult(temp, num2, num1));
                    if (characterStack.isEmpty()) {
                        throw new IllegalArgumentException("输入表达式有误，括号不能匹配");
                    }
                }
            } else if (c == ' '){

            } else {
                throw new IllegalArgumentException(c+ "");
            }
        }

        while (!characterStack.isEmpty()) {
            temp = characterStack.pop();
            stringBuilder.append(temp);
            double num1 = doubleStack.pop();
            double num2 = doubleStack.pop();
            doubleStack.push(getResult(temp, num2, num1));
        }
        double result = doubleStack.pop();
        if (!doubleStack.isEmpty())
            throw new IllegalArgumentException("输入的表达式错误");
        this.value = result;

        return stringBuilder.toString();
    }

    private static int getNumber(String exp, int begin) throws IllegalArgumentException {
        int len = exp.length();
        char c;
        for (int i = begin; i < len; ++i) {
            c = exp.charAt(i);
            //小数点跳过
            if (c != '.') {
                if (!Character.isDigit(c)) {
                    return i;
                } else if (i == len - 1) {
                    return len;
                }
            }
        }
        throw new IllegalArgumentException("输入的不是一个数字");
    }

    private static double getResult(char c, double data1, double data2) {
        double result;
        if (c == '+') {
            result = data1 + data2;
        } else if (c == '-') {
            result = data1 - data2;
        } else if (c == '*') {
            result = data1 * data2;
        } else {
            result = data1 / data2;
        }
        return result;
    }

    private static boolean operatorCmp(char c, char top) {
        if (c == '+' || c == '-') {              //新元素为+/-
            return true;
        } else if (c == '*' || c == '/') {       //
            return top == '*' || c == '/';
        }
        return false;
    }

    double getValue() {
        return value;
    }

    String getPostExp() {
        return postExp;
    }
}
