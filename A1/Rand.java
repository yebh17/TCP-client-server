import java.util.*;

class Rand{

    private static String[] arithOp = {"add","div","mul","sub","fadd","fdiv","fmul","fsub"};

    private static Random random = new Random();

    public static String randOperation()
    {
        int upperBound = arithOp.length;
        int position = random.nextInt(upperBound); 
        return arithOp[position];
    }
    
    public static int randIntegerValue()
    {
        int upperBound = 100;
        return random.nextInt(upperBound);
    }

    public static double randDecimalValue()
    {
        int upperBound = 100;
        return upperBound*random.nextDouble();
    }
}

