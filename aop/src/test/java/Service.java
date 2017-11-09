 @Service
    public class Service {

        private int counter = 1;
        @TryAgain(exception={NullPointerException.class})
        public void method() {
            if(counter != 3){
                counter++;
                throw new NullPointerException();
            }

        }
    }

