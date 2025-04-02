class Solution1 {
    public String addBinary(String a, String b) {
        int binaryA = Integer.parseInt(a, 2);
        int binaryB = Integer.parseInt(b, 2);
        int result = binaryA + binaryB;
        return Integer.toBinaryString(result);
    }
}

class Solution {
    public String addBinary(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();

        if(aLength < bLength) return addBinary(b, a);

        StringBuilder res = new StringBuilder();

        int carry = 0;
        int j = bLength - 1;
        for(int i = aLength - 1; i >= 0; i--){
            
            int digitA = a.charAt(i) - '0';
            int digitB = (j >= 0) ? b.charAt(j--) - '0' : 0;

            carry = digitA + digitB + carry;

            if(carry % 2 == 0) res.append("0");
            else res.append("1");

            carry = carry / 2;
        }
        if(carry == 1) res.append("1");

        return res.reverse().toString();
    }
}