package MyExceptions;

    public class TooManyThingsException extends Exception {
    private String announcement = "Remove some old items to insert a new item";


        public TooManyThingsException() {
            System.out.println(announcement);
        }
    }
