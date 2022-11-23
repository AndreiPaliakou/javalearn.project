public class Exercise2 {
    public static void main(String[] args) {
        System.out.println("Hello world!!!");
        System.out.println("");
        System.out.println("");
        for(int i = 0; i < args.length; i++) {
            System.out.println("Аргумент № " + i + ": args [" + i + "] = " + args [i] + "    ");
        };
        System.out.println("");
        System.out.println("");
        double G;
        final double Pi = 3.14;
        int a = Integer.parseInt(args[0]);
        int p = Integer.parseInt(args[1]);
        double m1 = Integer.parseInt(args[2]);
        double m2 = Integer.parseInt(args[3]);
        G = (4*Pi*Pi*a*a*a/p/p)/(m1+m2);
        System.out.println("Ответ: G =  " + G + ".");
    }
}
