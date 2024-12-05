public class Buffer {
    private String value;
    private long timestamp;
    public void insertValue(String value) {
            this.value = value;
            this.timestamp = System.currentTimeMillis();

            notifyAll();
    }

    public String getValue(long timestampCurrent) {

        while(this.timestamp < timestampCurrent) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return this.value;
    }

}
