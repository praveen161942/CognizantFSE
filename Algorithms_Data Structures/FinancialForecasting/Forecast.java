public class Forecast {
    public static double futureValue(double current,double rate,int years){
        if(years==0) return current;
        return futureValue(current*(1+rate),rate,years-1);
    }
    public static void main(String[] args){
        double result=futureValue(10000,0.1,5);
        System.out.printf("Future value: ₹%.2f\n",result);
    }
}