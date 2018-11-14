import java.time.Instant;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Blockchain<String>> blockchains = new ArrayList<>();

        //Add genesis block to blockchain
        //This is a block without a previous hash so it needs to just have some dummy data
        Blockchain<String> previousBlock = new Blockchain<>(0, Instant.EPOCH, "Genesis block", "RW51Y3M/IE1vcmUgbGlrZSBldW51Y2hz");
        blockchains.add(previousBlock);

        Scanner input = new Scanner(System.in);
        String flag;

        do {
            System.out.print("Enter data: ");
            String data = input.nextLine();
            Blockchain<String> block = new Blockchain<>(previousBlock.index+1, Instant.now(), data, previousBlock.hash);
            blockchains.add(block);
            previousBlock = block;

            System.out.print("Enter more data (y/n): ");
            flag = input.nextLine();
            flag = flag.toLowerCase();

        } while(flag.equals("y"));

        input.close();

        for(Blockchain<String> b : blockchains) {
            System.out.println(b.toString());
        }
    }
}