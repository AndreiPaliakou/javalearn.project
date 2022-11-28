public class Exercise2 {
    public static void main(String[] args) {
        System.out.println("Hello world!!!\n\n");
        for(int i = 0; i < args.length; i++) {
            System.out.println("Аргумент № " + i + ": args [" + i + "] = " + args [i] + "    \n\n");
        }
        double g;
        int a = Integer.parseInt(args[0]);
        int p = Integer.parseInt(args[1]);
        double m1 = Double.parseDouble(args[2]);
        double m2 = Double.parseDouble(args[3]);
        double degree = Math.pow(a, 3);
        double up = 4*Math.PI*Math.PI*degree;
        double down = p*p*(m1+m2);
        if (down != 0) {g = up/down;
        System.out.println("Ответ: g =  " + g + ".");
        }
    }
}
