package multithreading;

public class ConsumerProducerProblem {

    // Indicates which thread is allowed to print next.
    // true  -> Character thread can print.
    // false -> Number thread can print.
    private boolean characterTurn = true;

    /**
     * Prints a number.
     * If it's the character thread's turn, the number thread waits.
     */
    public synchronized void printNumber(int number) throws InterruptedException {

        // Wait until it becomes the number thread's turn.
        while (characterTurn) {
            wait();
        }

        // Print the current number.
        System.out.println(number);

        // Give turn back to the character thread.
        characterTurn = true;

        // Wake up the waiting character thread.
        notify();
    }

    /**
     * Prints a character.
     * If it's the number thread's turn, the character thread waits.
     */
    public synchronized void printCharacter(char character) throws InterruptedException {

        // Wait until it becomes the character thread's turn.
        while (!characterTurn) {
            wait();
        }

        // Print the current character.
        System.out.println(character);

        // Give turn to the number thread.
        characterTurn = false;

        // Wake up the waiting number thread.
        notify();
    }

    public static void main(String[] args) {

        // Shared object used for synchronization between both threads.
        ConsumerProducerProblem printer = new ConsumerProducerProblem();

        // Thread responsible for printing numbers.
        Thread numberThread = new Thread(() -> {

            for (int i = 1; i <= 26; i++) {
                try {
                    printer.printNumber(i);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

        });

        // Thread responsible for printing characters.
        Thread characterThread = new Thread(() -> {

            for (char c = 'a'; c <= 'z'; c++) {
                try {
                    printer.printCharacter(c);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

        });

        // Start both threads.
        numberThread.start();
        characterThread.start();
    }
}