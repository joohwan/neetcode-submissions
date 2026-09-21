class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new LinkedList<>();
        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                calc(stack, s);
            } else {
                stack.push(s);
            }
        }
        return Integer.valueOf(stack.peek());
    }

    void calc(Deque<String> stack, String s) {
        int operand2 = Integer.valueOf(stack.removeFirst());
        int operand1 = Integer.valueOf(stack.removeFirst());
        if (s.equals("+")) {
            stack.push(String.valueOf(operand1 + operand2));
        } else if (s.equals("-")) {
            stack.push(String.valueOf(operand1 - operand2));
        } else if (s.equals("*")) {
            stack.push(String.valueOf(operand1 * operand2));
        } else if (s.equals("/")) {
            stack.push(String.valueOf(operand1 / operand2));
        }
    }
}
