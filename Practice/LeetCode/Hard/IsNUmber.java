public class Solution {
    public boolean isNumber(String s) {

        if(s == null || s.equals("") || s.equals(" "))
            return false;

        char c = 0;
        s = s.trim();
        if(s.length() == 1){
            c = s.charAt(0);
            if(c >= '0' && c <='9')
                return true;
            else
                return false;
        }
        s = s.trim();
        boolean hasModifier = false;
        boolean hasE = false;
        for(int i=0;i<s.length();i++){
            c = s.charAt(i);
            if(c == ' ' || (hasE && c == 'e') || (hasModifier && (c == '.' || c == '+' || c== '-')) || (c == 'e' && (i == 0 || i+1==s.length())) || (hasModifier && (i == 1) && c == 'e') || (hasE && (i+1 == s.length() && c == '.')))
                return false;

            if(c == '.' || c == '+' || c== '-'){
                hasModifier = true;
                continue;
            }

            if(c == 'e' && (i!=0 || i+1!=s.length())){
                hasE = true;
                continue;
            }

            if(c >= '0' && c <= '9')
                continue;
            else
                return false;
        }

        return true;
    }
}
//Pattern.matches("(\\+|-)?(\\d+(\\.\\d*)?|\\.\\d+)(e(\\+|-)?\\d+)?", s);
//Pattern.matches("-?(([1-9]{1}+\\d*|0)(\\.\\d+)?|\\.\\d+)(e-?[1-9]{1}+\\d*)?", s);

// We start with trimming.
//
//     If we see [0-9] we reset the number flags.
//     We can only see . if we didn't see e or ..
//     We can only see e if we didn't see e but we did see a number. We reset numberAfterE flag.
//     We can only see + and - in the beginning and after an e
//     any other character break the validation.
//
// At the and it is only valid if there was at least 1 number and if we did see an e then a number after it as well.
//
// So basically the number should match this regular expression:
//
// [-+]?(([0-9]+(.[0-9]*)?)|.[0-9]+)(e[-+]?[0-9]+)?
// "e9"
// " "
// "  $"
// " ."
// " ,"
// " .1 "
// " +1 "
// " -1 "
// "01"
// "34"
// "0 "
// "1a"
// "#1"
// "00"
// "1 a"
// "..1"
// "--1"
// "a1"
// "a34"
// "007"
// "0.1.1"
// "0.1"
// " 1"
// "1.2"
// "1.3456"
// "22.3"
// "2e1"
// "22.3"
// "-2e10"
// " 1"
// "0e"
// "012112e"
// "1ea2"
// "1ee2"
// ". 1"
// "1 1"
// "-12211324"
// " 1"
// "0e"
// "012112e"
// "1ea2"
// "1ee2"
// ".e2"
// "1.e2"
// "e."
// "e2"
// ".e."
// ".1"
// "7.e2"
// ".e2"
// "..e2"
// "1e."
public boolean isNumber(String s) {
		/**
		 * isNumber(s)==true if and only if s=s1 or s1+'e'+s2, where s1, s2
		 * are valid strings of a number without the char 'e', and s2 is an
		 * integer.
		 *
		 * 'e' : valid_count=0~1; [boolean hasE]
		 *
		 * Valid chars in a string of a number without 'e':
		 *
		 * ' ' : valid_count=0~n; must appear at two ends
		 *
		 * '+/-' : valid_count=0~1; must be the first non-space valid char;
		 * [boolean hasFirst]
		 *
		 * '.' : valid_count=0~1; cannot appear after 'e'; [boolean hasDot]
		 *
		 * '0~9' : valid_count=1~n; [boolean hasDigit]
		 */

		s = s.trim();
		int n = s.length();
		if (n == 0)
			return false;

		boolean hasE, hasFirst, hasDot, hasDigit;
		hasE = hasFirst = hasDot = hasDigit = false;

		char c;
		for (int i = 0; i < n; i++) {
			c = s.charAt(i);

			if (c >= '0' && c <= '9') {
				hasFirst = hasDigit = true;
				continue;
			}

			switch (c) {
			case 'e':
				// already has 'e' or no digit before 'e'
				if (hasE || !hasDigit)
					return false;
				hasE = true;

				// reset for the exponential number
				hasFirst = hasDigit = false;
				hasDot = true; // the exponent must be an integer, hence
								// regard as if a dot exists already. Set
								// hasDot = false extending to accept any
								// (decimal) number as an exponent.
				continue;
			case '+':
			case '-':
				if (hasFirst)
					return false;
				hasFirst = true;
				continue;
			case '.':
				if (hasDot)
					return false;
				hasFirst = hasDot = true;
				continue;
			default:
				return false;
			}
		}

		return hasDigit;
	}
