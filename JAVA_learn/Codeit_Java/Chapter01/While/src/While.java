public class While {
        public static void main(String args[]){
            int num = 10000;
            int key = 153;
            int result = key;
            while(result<10000){
                result+=key;
            }
            System.out.println(result - key);
        }
}
