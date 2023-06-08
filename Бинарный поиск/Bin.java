public class Bin {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();
            //DataInputStream dataInputStream = new DataInputStream(System.in);
                int[] array = new int[x];
                for (int i = 0; i < x; i++) {
                    array[i] = scanner.nextInt();
                }
                int call_size = scanner.nextInt();
                int[] call = new int[call_size];
                for (int i = 0; i < call_size; i++) {
                    call[i] = scanner.nextInt();
                }

                for (int j = 0; j < call_size; j++) {
                    boolean b = findInArray(call[j], array);
                    int l = findIndexOrNextIndex(call[j], array);
                    int r = UpperBound(call[j], array);
                    if (b) {
                        System.out.println("1 " + l + " " + r);
                    } else {
                        System.out.println("0 " + l + " " + r);
                    }
                }
            }        

        public static boolean findInArray(int call, int [] array) {
            int left = 0;
            int right = array.length;
            while (left < right) {
                int i = left + ((right - left) >> 1);
                if (call == array[i]) {
                    return true;
                }
                else if (call < array[i]) {
                    right = i;
                }
                else  {
                    left = i + 1;
                }
            }
            return false;
        }

        public static int UpperBound(int call, int[] array) {
            int left = 0;
            int right = array.length;
            while (left < right) {
                int i = left + ((right - left) >> 1);
                if (call < array[i])
                    right = i;
                else if (call >= array[i])
                    left = i + 1;
            }
            return left;
        }

        public static int findIndexOrNextIndex(int call, int[] array){
            int left = 0;
            int right = array.length;
            while (left < right) {
                int i = left + ((right - left) >> 1);
                if (call <= array[i])
                    right = i;
                else if (call > array[i])
                    left = i + 1;
            }
            return left;
        }
    }
