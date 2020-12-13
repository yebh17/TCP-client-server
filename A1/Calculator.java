import java.util.*;

public class Calculator
{
    public static int calculate(String operation,int value1,int value2)
    {
        
        switch(operation)
        {
            case "add":
                return value1 + value2;
            case "sub":
                return value1 - value2;
            case "mul":
                return value1 * value2;
            case "div":
                return value1/value2;
            default:
                return 0;

            
        }
    }

    public static double calculate(String operation,double value1,double value2)
    {
        Formatter formatter = new Formatter(); 
        
        switch(operation)
        {
            case "fadd":
                return value1 + value2;

            case "fsub":
                return value1 - value2;

            case "fmul":
                return value1 * value2;
         
            case "fdiv":
                return value1/value2;

            default:
                return 0;
        }
    }

}
