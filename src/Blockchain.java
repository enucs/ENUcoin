import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.Base64;

public class Blockchain<T> {
    public int index;
    public Instant timestamp;
    public T data;
    public String previousHash;
    public String hash;

    public Blockchain(int index, Instant timestamp, T data, String previousHash) {
        this.index = index;
        this.timestamp = timestamp;
        this.data = data;
        this.previousHash = previousHash;
        this.hash = makeHash();
    }

    private String makeHash() {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            String fullString = String.format("%s%s%s%s", index, timestamp.toString(), data, previousHash);
            byte[] hash = digest.digest(fullString.getBytes());

            return Base64.getEncoder().encodeToString(hash);

        } catch(NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }

        return "";
    }

    @Override
    public String toString() {
        return "Blockchain{" +
                "index=" + index +
                ", timestamp=" + timestamp +
                ", data=" + data +
                ", previousHash='" + previousHash + '\'' +
                ", hash='" + hash + '\'' +
                '}';
    }
}