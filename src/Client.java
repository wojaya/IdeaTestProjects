public class Client {

    public static void main(String[] args) {


        TestBound tb = new TestBound();
        TestBound1 tb1 = new TestBound1();
        TestBound2 tb2 = new TestBound2();
        TestBound3 tb3 = new TestBound3();
        TestBound4 tb4 = new TestBound4();
        TestBound5 tb5 = new TestBound5();


        Gen<TestBound> ob1 = new Gen<>(tb);
        ob1.showType();
        Gen<TestBound2> ob2 = new Gen<>(tb2);
        ob2.showType();
        Gen<TestBound3> ob3 = new Gen<>(tb3);
        ob3.showType();
        Gen<TestBound4> ob4 = new Gen<>(tb4);
        ob4.showType();
        Gen<TestBound5> ob5 = new Gen<>(tb5);
        ob5.showType();

        ob1.isSameFreq(ob1);

    }
}

class Gen<T extends TestBound> {
    T ob;

    Gen(T o) {
        ob = o;
    }

    T getOb() {
        return ob;
    }

    void showType() {
        System.out.println("Type of this is: " + ob.getClass().getName());
    }

    int getFreq() {
        return 1;
    }

    void isSameFreq(Gen<? super TestBound3> ob) {
        if (getFreq() == ob.getFreq()) {
            System.out.println("YEsYEsYEs");
        }
    }
}

interface GenInterface {
    void showGenInterface();
}

class TestBound {
    public void showTestBound() {
        System.out.println("This is show Test Bound");
    }
}

class TestBound1 extends TestBound {
    public void showTestBound() {
        System.out.println("This is show Test Bound111");
    }
}

class TestBound2 extends TestBound1 {
    public void showTestBound() {
        System.out.println("This is show Test Bound222");
    }
}

class TestBound3 extends TestBound2 {
    public void showTestBound() {
        System.out.println("This is show Test Bound333");
    }
}

class TestBound4 extends TestBound3 {
    public void showTestBound() {
        System.out.println("This is show Test Bound444");
    }
}

class TestBound5 extends TestBound4 {
    public void showTestBound() {
        System.out.println("This is show Test Bound555");
    }
}

class TT extends TestBound implements GenInterface {
    public void showGenInterface() {
        System.out.println("show Gen Interface.");
    }
}