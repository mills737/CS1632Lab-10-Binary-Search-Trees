import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        runTree(100, 1, 10000);
        runTree(1000, 1, 10000);
        runTree(10000, 1, 10000);
    }
    private static List<Integer> generateRandomList(int n, int min, int max){
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(random.nextInt(max - min + 1) + min);
        }
        return list;
    }
    private static void runTree(int size, int min, int max){
        double averageHeight = 0;
        double averageFindCost = 0;
        for(int i = 0; i < 3; i++) {
            BinarySearchTree bt = new BinarySearchTree();
            List<Integer> n = generateRandomList(size,min,max);
            for(Integer num : n){
                bt.recurInsert(num);
            }
            averageHeight += bt.getHeight(bt.root);
            double totalNodesVisted = 0;
            for(Integer num : n){
                totalNodesVisted+= bt.findCount(num);
            }
            double averageNodes = totalNodesVisted / n.size();
            averageFindCost += averageNodes;
            System.out.println("Trial " + (i+1) + ": Height: " + bt.getHeight(bt.root) + " Average nodes visited: " + averageNodes);
        }
        System.out.println("Average Height (" + size + " ints): " + averageHeight / 3);
        System.out.println("Average Nodes Visited: " + averageFindCost / 3);
    }
}