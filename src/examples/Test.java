package examples;

/**
 * Created by davlet on 6/7/17.
 */
class Test {

    private String name;

    Test(String name) {
        this.name =  name;
    }

    public void test(Test testp) {
        Test test = new Test("three");
        testp = test;

    }

    void changeparam(String s, Test test){
        test.name = s;
    }

    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        Test t1 = new Test("one");
        Test t2 = new Test("two");
        t1.test(t2);
        System.out.println(t2);
        t1.changeparam("asdf", t2);
        System.out.println(t2.name);

        Test test = t1;
        System.out.println(test);
        test = new Test("zxcvzxcv");
        System.out.println(test);
    }

}