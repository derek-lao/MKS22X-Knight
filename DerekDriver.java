public class DerekDriver{
  public static void main(String[] args){
    // KnightBoard simple=new KnightBoard(3,3);
    // System.out.println(simple.solve(0,0));
    // System.out.println(simple.toString());
    // simple.clearOriginal();
    // System.out.println("The number of solutions are: " + simple.countSolutions(0,0));
    // System.out.println(simple.toString());

    // KnightBoard simple = new KnightBoard(3,4);
    // System.out.println(simple.solve(0,0));
    // System.out.println(simple.toString());
    // simple.clearOriginal();
    // System.out.println("The number of solutions are: " + simple.countSolutions(0,0));
    // System.out.println(simple.toString());

    // KnightBoard simple=new KnightBoard(4,4);
    // System.out.println(simple.solve(0,0));
    // System.out.println(simple.toString());
    // simple.clearOriginal();
    // System.out.println("The number of solutions are: " + simple.countSolutions(0,0));
    // System.out.println(simple.toString());

    KnightBoard simple=new KnightBoard(4,5);
    System.out.println(simple.solve(0,0));
    System.out.println(simple.toString());

    // KnightBoard simple=new KnightBoard(5,6);
    // System.out.println(simple.solve(0,0));
    // System.out.println(simple.toString());

    // KnightBoard simple=new KnightBoard(6,6);
    // System.out.println(simple.solve(0,0));
    // System.out.println(simple.toString());
    // simple.clearOriginal();
    // System.out.println("The number of solutions are: " + simple.countSolutions(0,0));
    // System.out.println(simple.toString());

    // KnightBoard simple=new KnightBoard(5,6);
    // System.out.println(simple.solve(0,0));
    // System.out.println(simple.toString());
    // simple.clearOriginal();
    // System.out.println("The number of solutions are: " + simple.countSolutions(0,0));
    // System.out.println(simple.toString());

    // KnightBoard simple=new KnightBoard(8,8);
    // System.out.println(simple.solve(0,0));
    // System.out.println(simple.toString());
    // simple.clearOriginal();
    // System.out.println("The number of solutions are: " + simple.countSolutions(0,0));
    // System.out.println(simple.toString());

    // KnightBoard simple=new KnightBoard(10,10);
    // System.out.println(simple.solve(0,0));
    // System.out.println(simple.toString());
    //
    KnightBoard stuff=new KnightBoard(10,10);
    stuff.optimizedFill();
    System.out.println(stuff.toString());
  }
}
