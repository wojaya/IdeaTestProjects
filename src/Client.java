public class Client {

    public static void main(String[] args) {
        TT tt = new TT();
        Gen<TT> iob = new Gen<>(tt);
        iob.showType();
        iob.getOb().showTestBound();
        iob.getOb().showGenInterface();

    }
}

class Gen<T extends TestBound & GenInterface> {
    T ob;

    Gen(T o) {
        ob = o;
    }

    T getOb() {
        return ob;
    }

    void showType() {
        System.out.println("Type of T is: " + ob.getClass().getName());
    }
}

interface GenInterface {
    void showGenInterface();
}

class TestBound {
    public void showTestBound() {
        System.out.println("show Test Bound");
    }
}

class TT extends TestBound implements GenInterface {
    public void showGenInterface() {
        System.out.println("show Gen Interface.");
    }
}