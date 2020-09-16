import java.util.ArrayList;

public class Main {
    public static int getSurvivingIndex(int n, int k) {
        ArrayList<Integer> Array = new ArrayList<>();
        ArrayList<Integer> Dead = new ArrayList<>();
        int index = 0;
        for(int i=0;i<n;i++){
            Array.add(i + 1);
        }
        while(true) {
            index += k - 1;
            index = index % Array.size();
            Dead.add(Array.remove(index));
            if (Array.size() == 1) {
                break;
            }
        }
        for(int i:Dead) {
            System.out.println(i + "번 군사가 죽습니다.");
        }
        return Array.get(0);
    }

    public static void main(String[] args) {
        System.out.println("김신은 " + getSurvivingIndex(20, 5) + "번 자리에 서있으면 됩니다.");
    }
}
