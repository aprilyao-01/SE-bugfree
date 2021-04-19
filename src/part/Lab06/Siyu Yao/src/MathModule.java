
public class MathModule {
      public static void main(String[] args) {
           // TODO Auto-generated method stub
    	  //System.out.println(myMultiply(2000000000, 6));
    	  // result is -884901888
    	  // Because Int only have 32-bits, and the result is overflow,so java only represent lower 32bits and becomes negative number.
    	  
    	  try {
              int test = myMultiply(2000000000, 6);
              System.out.println(test);
          } catch(Exception e) {
              System.out.println(e.toString());
          }

    }
      public static int myMultiply(int firstNum, int secondNum) throws Exception {
    	  long newAnswer = (long)firstNum * secondNum;
    	  if (newAnswer > Integer.MAX_VALUE) {
              throw new Exception("Number too big");
          }
    	  if (newAnswer < Integer.MIN_VALUE) {
              throw new Exception("Number too SMALL");
          }
          return firstNum * secondNum; }
      
}

