class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < asteroids.length; i++){
            int current = asteroids[i];
            boolean exploded = false;

            //Cases when Collision Happens
            /* 
            1) Current Element is negative and the stack contains Positive 
            Subcases in this
                1) abs(top) > abs(current) break
                2) abs(current) > abs(top) pop()
                3) abs(current) = abs(top) pop and break
             */
            while(!st.isEmpty() && (st.peek() > 0 && current < 0)){
                
                if(Math.abs(current) == Math.abs(st.peek())){
                    st.pop();
                    exploded = true;
                    break;
                }

                else if(Math.abs(current) > Math.abs(st.peek())){
                    st.pop();
                }

                else {
                    exploded = true;
                    break;
                }
            }

            //Cases when they dont collide
            /* Simply put in the stack */
            if(!exploded){
                st.push(current);
            }
        }

        int size = st.size();
        int[] result = new int[size];
        for(int i = 0; i < size; i++){
            result[size - i - 1] = st.pop();
        }

        return result;
    }
}