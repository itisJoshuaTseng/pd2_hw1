import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RegExp {
    public static int findString(String line, String str1) {
        int linelength = line.length();
        int str1length = str1.length();
        if (str1length > linelength) {
            return -1;
        }
        for (int i = 0; i <= linelength - str1length; i++) {
            int j;
            for (j = 0; j < str1length; j++) {
                // Ensure that i+j does not exceed the length of the line string
                if (i + j >= linelength || line.charAt(i + j) != str1.charAt(j)) {
                    break;
                }
            }
            if (j == str1length) {
                return i;
            }
        }
        return -1;
    }

    public static int findStringMultipul(String line, String str2, int times) {
        int linelength = line.length();
        int str2length = str2.length();
        int count = 0;
        if (str2length > linelength) {
            return -1;
        }
        for (int i = 0; i <= linelength - str2length; i++) {
            int j;
            for (j = 0; j < str2length; j++) {
                // Ensure that i+j does not exceed the length of the line string
                if (i + j >= linelength || line.charAt(i + j) != str2.charAt(j)) {
                    break;
                }
            }
            if (j == str2length) {
                count++;
            }
        }
        if (count >= times) {
            return 1;
        } else {
            return -1;
        }
    }

    public static int ReverseString(String line) {
        String reversedLine = new StringBuilder(line).reverse().toString();
        if (line.equals(reversedLine))
            return 1;
        else
            return 0;
    }

    public static String amXb2m(String line) {
        int a_nums = 0,b_nums = 0;
        for (int i = 0; i < line.length(); i++) {
            if(a_nums == 0){
                if(line.charAt(i) == 'A') a_nums = 1;
            }
            else{
                if(line.charAt(i) == 'B') b_nums++;
                else b_nums = 0;
            }
            if(a_nums + b_nums == 3) return "Y";
            
            
            // if (line.charAt(i) == 'A') {
            //     // i++;
            //     countNumberofstraightA++;

            // } else {
            //     StringBuilder thegoalB_string = new StringBuilder();
            //     for (int k = 0; k < countNumberofstraightA * 2; k++) {
            //         thegoalB_string.append('B');
            //     }
            //     int result = findString(line, thegoalB_string.toString());
            //     if (result != -1 && result > i)
            //         return 1;
            // }
        }
        return "N";
    }

    public static void main(String[] args) {
        args = new String[]{"tc1","abc","b","3"};
        String str1 = args[1];
        String str2 = args[2];
        int s2Count = Integer.parseInt(args[3]);

        // For your testing of input correctness
        /*
         * System.out.println("The input file:"+args[0]);
         * System.out.println("str1="+str1);
         * System.out.println("str2="+str2);
         * System.out.println("num of repeated requests of str2 = "+s2Count);
         */
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line;
            String[] result = new String[4];
            while ((line = reader.readLine()) != null) {
                // You main code should be invoked here
                line = line.toUpperCase();
                str1 = str1.toUpperCase();
                str2 = str2.toUpperCase();
                if (ReverseString(line) == 1) {
                    result[0] = "Y";
                } else {
                    result[0] = "N";
                }
                if (findString(line, str1) == -1) {
                    result[1] = "N";
                } else {
                    result[1] = "Y";
                }
                if (findStringMultipul(line, str2, s2Count) == 1) {
                    result[2] = "Y";
                } else {
                    result[2] = "N";
                }
                result[3] =  amXb2m(line);
                

                StringBuilder resultString = new StringBuilder();
                for (int i = 0; i < result.length; i++) {
                    resultString.append(result[i]);
                    if (i < result.length - 1) {
                        resultString.append(",");
                    }
                }
                System.out.println(resultString);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
