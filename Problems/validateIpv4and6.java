public class Solution {
    public String validIPAddress(String IP) {
        //String should not be null and without any characters
        if(IP == null || IP.length() == 0 || IP.equls(""))
            return "Neither";

        int end = IP.length() - 1;
        //it should contain either . or : not both
        if((!IP.contains(".") && !IP.contains(":")) || (IP.contains(".") && IP.contains(":")))
            return "Neither";
        //check if each of the character is valid enough
        if(!isValidCharacter(IP,0) || !isValidCharacter(IP,end))
            return "Neither";

        String[] split = null;
        boolean ipv4 = false;
        boolean ipv6 = false;
        //Split with . for IPv4
        split = IP.split("\\.");
        if(split.length == 4)
            ipv4 = validateForIpv4(split);
        //Split with . for IPv6
        split = IP.split(":");
        if(split.length == 8)
            ipv6 = validateForIpv6(split);

        return ipv4 ? "IPv4" : (ipv6 ? "IPv6" : "Neither");
    }

    public boolean isValidCharacter(String IP,int index){
        //character should not be greater than f or F
        if(IP.charAt(index) > 70 && IP.charAt(index) < 90)
           return false;
        if(IP.charAt(index) > 102 && IP.charAt(index) < 122)
           return false;
        //character should be alphanumeric
        if(IP.charAt(index) < 48 || IP.charAt(index) > 122)
            return false;
        if(IP.charAt(index) > 57 && IP.charAt(index) < 65)
            return false;

        return true;
    }

    public boolean validateForIpv4(String[] split){
        boolean isValid = false;
        for(int i=0;i<split.length;i++){
            //the value should not be empty
            if(split[i].equals(""))
                    return false;
            try{
                int value = Integer.valueOf(split[i]);
                //the value should not having leading zero's for single, double or triple digit length
                if(value < 10 && split[i].length() > 1)
                    return false;
                else if((value > 9 && value < 100) && split[i].length() > 2)
                    return false;
                else if((value > 99 && value < 255) && split[i].length() > 3)
                    return false;
                //the value should be between 0 to 255
                if(value >= 0 && value <= 255)
                    isValid = true;
                else
                    return false;
            }
            catch(NumberFormatException e){ // for Integer conversion if there is a character in between then its not valid
                return false;
            }
        }
        return isValid;
    }

    public boolean validateForIpv6(String[] split){
        boolean isValid = false;
        for(int i=0;i<split.length;i++){
            //the value should not be empty
            if(split[i].equals(""))
                    return false;
            //the value length should not be greater than 4
            if(split[i].length() > 4)
                return false;
            //check if each character is valid alphnumeric
            for(int j=0;j<split[i].length();j++){
                char ch = split[i].charAt(j);
                if(isValidCharacter(split[i],j))
                    isValid = true;
                else
                    return false;
            }
        }
        return isValid;
    }
}
