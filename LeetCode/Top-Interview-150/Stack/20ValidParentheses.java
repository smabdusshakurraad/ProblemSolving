class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0){
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '[' ){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                else if( (ch == ')' && stack.peek() == '(') ||
                        (ch == '}' && stack.peek() == '{') ||
                        (ch == ']' && stack.peek() == '[')){
                    stack.pop();
                }
                else
                    return false;
            }
        }

        return stack.isEmpty();
    }
}