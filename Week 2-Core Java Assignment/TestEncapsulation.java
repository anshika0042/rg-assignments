

class Encapsulate {
    private int num1;
    private int num2;
    public int getNum1() {
        return num1;
    }
    public void setNum1(int num1) {
        this.num1 = num1;
    }
    public int getNum2() {
        return num2;
    }
    public void setNum2(int num2) {
        this.num2 = num2;
    }
}

public class TestEncapsulation{
    public static void main(String []args){
        Encapsulate obj = new Encapsulate();
        obj.setNum1(1);
        obj.setNum2(2);
        System.out.println(obj.getNum1());
        System.out.println(obj.getNum2());
    }
}
