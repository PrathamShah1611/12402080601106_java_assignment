// Demonstration of Inner Classes: Member, Local, Anonymous

class Outer {

    String msg = "thank you";

    // Member Inner Class
    class MemberInner {
        void show() {
            System.out.println("Member Inner Class: " + msg);
        }
    }

    // Local Inner Class
    void localInnerDemo() {
        class LocalInner {
            void show() {
                System.out.println("Local Inner Class: " + msg);
            }
        }

        LocalInner li = new LocalInner();
        li.show();
    }

    // Anonymous Inner Class
    void anonDemo() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous Inner Class: " + msg);
            }
        };

        r.run();
    }
}

// Main class MUST be public with same filename
public class InnerClassesDemo {

    public static void main(String[] args) {

        Outer o = new Outer();

        // Member Inner Class
        Outer.MemberInner mi = o.new MemberInner();
        mi.show();

        // Local Inner Class
        o.localInnerDemo();

        // Anonymous Inner Class
        o.anonDemo();
    }
}
