package base;

public class LettersRunnable extends Thread {
    StringBuilder stringBuilder;

    public LettersRunnable(StringBuilder sb) {
        this.stringBuilder = sb;
    }

    @Override
    public void run() {
        synchronized (stringBuilder) {
            for (int i = 0; i < 100; i++) {
                System.out.println(stringBuilder.toString());
            }
            stringBuilder.setCharAt(0, (char) (stringBuilder.charAt(0) + 1));
        }
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append('a');
        new LettersRunnable(sb).start();
        new LettersRunnable(sb).start();
        new LettersRunnable(sb).start();

    }


}
