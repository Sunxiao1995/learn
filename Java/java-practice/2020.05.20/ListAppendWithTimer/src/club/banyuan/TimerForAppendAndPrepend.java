package club.banyuan;

public class TimerForAppendAndPrepend implements Timer{
    private boolean isTimerStop = true ;
    private long recordingTime = 0;
    private long startTime = 0;
    private long stopTime = 0;

    @Override
    public void start() throws IllegalStateException {
        startTime = System.currentTimeMillis();
        while (!isTimerStop){
            throw new IllegalStateException();
        }
        isTimerStop = false;
    }

    @Override
    public void stop() throws IllegalStateException {
        stopTime = System.currentTimeMillis();
        while (isTimerStop){
            throw new IllegalStateException();
        }
        isTimerStop = true;
    }

    @Override
    public void reset() {
      recordingTime = 0;
      isTimerStop = true;
    }

    @Override
    public long getTimeMillisecond() {
        recordingTime = stopTime-startTime;
        return recordingTime;
    }
}
