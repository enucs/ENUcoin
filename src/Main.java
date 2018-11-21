import java.time.Instant;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Block> blockchains = new ArrayList<>();

        //Add genesis block to blockchain
        //This is a block without a previous hash so it needs to just have some dummy data
        Block previousBlock = new Block(0, Instant.EPOCH, new Transaction("", "", Instant.EPOCH, 0.0), "RW51Y3M/IE1vcmUgbGlrZSBldW51Y2hz");
        blockchains.add(previousBlock);

        Scanner input = new Scanner(System.in);
        String flag;

        do {
            System.out.print("Enter data: ");
            String data = input.nextLine();
            Block block = new Block(previousBlock.getIndex()+1, Instant.now(), new Transaction("a", "b", Instant.now(), 1.0), previousBlock.getHash());
            blockchains.add(block);
            previousBlock = block;

            System.out.print("Enter more data (y/n): ");
            flag = input.nextLine();
            flag = flag.toLowerCase();

        } while(flag.equals("y"));

        input.close();

        for(Block b : blockchains) {
            System.out.println(b.toJSON());
        }
    }
}