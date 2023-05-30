package BasicClasses;


public class Print_Details {
        private String PaperSize;
        private String Color;
        private String DoubleSided;
        private int Copies;
        private String Orientation;

   public Print_Details(String papersize,String color, String sides,int Copies,String orientation){
            this.PaperSize = papersize;
            this.Color = color;
            this.DoubleSided = sides;
            this.Copies = Copies;
            this.Orientation = orientation;
   }
   public float Print_Cost(){

       return 0;
   }

    public String getPaperSize() {
        return PaperSize;
    }

    public void setPaperSize(String paperSize) {
        PaperSize = paperSize;
    }

    public String getDoubleSided() {
        return DoubleSided;
    }

    public void setDoubleSided(String doubleSided) {
        DoubleSided = doubleSided;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public int getCopies() {
        return Copies;
    }

    public void setCopies(int copies) {
        Copies = copies;
    }

    public String getOrientation() {
        return Orientation;
    }

    public void setOrientation(String orientation) {
        Orientation = orientation;
    }
}


