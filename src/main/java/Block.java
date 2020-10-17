import java.util.Date;

//Block
public class Block {
    public String hash;
    public String previousHash;
    public String data;
    public long timeStamp;
    private int nonce;

    public Block(String data, String previousHash) {
        this.previousHash = previousHash;
        this.data = data;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }


    public String calculateHash(){
        String calculatedHash = StringUtils.apply256(previousHash + Long.toString(timeStamp) + Integer.toString(nonce) + data);
        return calculatedHash;
    }

    public void mineBlock(int handlerStatus){
        String target = new String(new char[handlerStatus]).replace('\0', '0');
        while (!hash.substring(0,handlerStatus).equals(target)){
            nonce++;
            hash = calculateHash();
        }
        System.out.println("BlockChain Mined  " + hash);
    }


}
