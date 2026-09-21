class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                calc(stack, s);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.peek();
    }

    void calc(Deque<Integer> stack, String s) {
        int operand2 = stack.pop();
        int operand1 = stack.pop();
        if (s.equals("+")) {
            stack.push(operand1 + operand2);
        } else if (s.equals("-")) {
            stack.push(operand1 - operand2);
        } else if (s.equals("*")) {
            stack.push(operand1 * operand2);
        } else if (s.equals("/")) {
            stack.push(operand1 / operand2);
        }
    }
}
