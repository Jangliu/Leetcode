/*
 * @lc app=leetcode id=1114 lang=java
 *
 * [1114] Print in Order
 */

// @lc code=start
class Foo {
    private boolean first = true;
    private boolean second = true;

    public Foo() {
        this.first = false;
        this.second = false;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        this.first = true;
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (true) {
            if (this.first) {
                printSecond.run();
                this.second = true;
                break;
            }
        }
        // printSecond.run() outputs "second". Do not change or remove this line.

    }

    public void third(Runnable printThird) throws InterruptedException {
        while (true) {
            if (this.second) {
                printThird.run();
                break;
            }
        }
        // printThird.run() outputs "third". Do not change or remove this line.
    }
}
// @lc code=end

