public class Main {
    private static int[] x =  {10, 13, 16, 19, 22, 25, 28, 31, 34, 37, 40, 43, 46, 49, 52};

    public static void main(String[] args) {
        System.out.printf("%24s%n", "* БИНДЕРЕВО ПОИСКА *");
        build(x);
    }

    public static void mark(int[] x, int left, int right, int level, int[] y){
        if (left == right) {
            y[left] = level;
            return;
        }
        int middle = (right + left) / 2;
        y[middle] = level;
        mark(x, left, middle - 1, level + 1, y);
        mark(x, middle + 1, right, level + 1, y);
    }

    public static void build(int[] x) {
        int[] levels = new int[x.length];
        mark(x, 0, x.length - 1, 0, levels);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < x.length; j++) {
                if(levels[j] == i) {
                    System.out.print(x[j]);
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
