import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingStack<T> {
    private Stack<T> stack = new Stack<>();
    private Lock locker = new ReentrantLock();
    private Condition isFull = locker.newCondition();
    private Condition isEmpty = locker.newCondition();
    private static final int CAPACITY = 10; // Змініть, якщо потрібно іншу ємність

    public void push(T item) {
        locker.lock();
        try {
            while (stack.size() == CAPACITY) isFull.await(); // Чекаємо, поки стек не стане не повним
            stack.push(item);
            isEmpty.signal(); // Сигналізуємо, що стек тепер не пустий
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
    }

    public T pop() {
        locker.lock();
        try {
            while (stack.isEmpty()) {
                isEmpty.await(); // Чекаємо, поки стек не стане не пустим
            }
            T item = stack.pop();
            isFull.signal(); // Сигналізуємо, що стек тепер не повний
            return item;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } finally {
            locker.unlock();
        }
    }

    public static void main(String[] args) {
        BlockingStack<Integer> stack = new BlockingStack<>();

        Thread pushThread = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                stack.push(i);
                try {
                    Thread.sleep(100); // Додатковий час для демонстрації синхронізації
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread popThread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                int popped = stack.pop();
                System.out.println("Thread 1 popped: " + popped);
            }
        });

        Thread popThread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                int popped = stack.pop();
                System.out.println("Thread 2 popped: " + popped);
            }
        });

        pushThread.start();
        popThread1.start();
        popThread2.start();
    }
}

