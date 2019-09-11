package ru.ttv.interviewprepare.lesson3;

/**
 * @author Teplykh Timofey  09.09.2019
 */
public class PingPongThread extends Thread {
    private String word;
    private String otherWord;

    private PingPongMonitor pingPongMonitor;

    public PingPongThread(String word, String otherWord, PingPongMonitor pingPongMonitor) {
        this.word = word;
        this.pingPongMonitor = pingPongMonitor;
        this.otherWord = otherWord;
    }

    @Override
    public void run() {
//        super.run();
        synchronized (pingPongMonitor){
            for (int i = 0; i < 100 ; i++) {
                try {
                    while (pingPongMonitor.currentWord != word){
                        pingPongMonitor.wait();
                    }
                    System.out.println(word);
                    pingPongMonitor.currentWord = otherWord;
                    pingPongMonitor.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
