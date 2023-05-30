package BasicClasses;

public class Aggregation extends Print_Details{
    private Boolean Cost;

    public Aggregation(String papersize, String color, String sides, int Copies, String orientation) {
        super(papersize, color, sides, Copies, orientation);
    }
    public double Paper_Size_Cost(){
        String s = getPaperSize();
        String[][] Size = new String[5][2];
        Size = new String[][]{{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}};
        for(int i = 0;i<5;i++){
            if(Size[i][0].equals(s))
                return Float.parseFloat(Size[i][1]);
            }
        return 0;
    }
    public double Paper_Color_Cost(){
        String s = getColor();
        String[][] Color = new String[2][2];
        Color = new String[][]{{"Color", "20.00"}, {"Grayscale", "2.00"}};
        return 0;
    }
    public double Paper_Sides_Cost(){
        String s = getDoubleSided();
        String[][] Sides = new String[2][2];
        Sides = new String[][]{{"Single", "1"}, {"Double", "1.5"}};
        return 0;
    }
    public double Paper_Copies_Cost(){
        int n = getCopies();
        return n;
    }
    public double Cost_Search(){
        return 0;
    }

    public double Cost_Calculation(){
      return 0;
    }
}

class Item<T,S>{
    private T t;
    private S s;

    public void add(T t, S s) {
        this.t = t;
        this.s = s;
    }

    public T getFirst() {
        return t;
    }

    public S getSecond() {
        return s;
    }
}