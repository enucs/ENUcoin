import java.time.Instant;
import java.util.ArrayList;

public class Main {
    public static Blockchain firstBlock() {
        return new Blockchain(0, Instant.now(), "Starting block", "0");
    }

    public static Blockchain nextBlock(Blockchain lastBlock) {
        int nextIndex = lastBlock.index + 1;
        return new Blockchain(nextIndex, Instant.now(), Integer.toString(nextIndex), lastBlock.hash);
    }

    public static void main(String[] args) {
        ArrayList<Blockchain> blockchains = new ArrayList<>();
        blockchains.add(firstBlock());
        Blockchain previousBlock = blockchains.get(0);

        for(int i = 0; i < 20; ++i) {
            Blockchain blockToAdd = nextBlock(previousBlock);
            blockchains.add(blockToAdd);
            previousBlock = blockToAdd;
        }

        for(Blockchain bc : blockchains) {
            System.out.println(String.format("%d: %s\n%s", bc.index, bc.data, bc.hash));
        }
    }
}