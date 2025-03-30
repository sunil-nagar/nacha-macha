package src.nm.parse;

public class LineChomper {

    private String buffer;
    private String bit;

    public LineChomper(String s) {
        this.buffer = s;
    }

    public String chomp(int i) {
        bit = buffer.substring(0, i);
        buffer = buffer.substring(i);
        return bit;
    }

    public static void main(String[] args) {
        String line = "01abcd23efg45678h9";
        LineChomper lineChomper = new LineChomper(line);
        System.out.println(lineChomper.chomp(2));
        System.out.println(lineChomper.chomp(4));
        System.out.println(lineChomper.chomp(2));
        System.out.println(lineChomper.chomp(3));
        System.out.println(lineChomper.chomp(5));
        System.out.println(lineChomper.chomp(1));
        System.out.println(lineChomper.chomp(1));
    }
}

