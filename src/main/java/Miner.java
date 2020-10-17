import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class Miner {


    public static final int handler = 1;
    public static List<Block> blockchain = new ArrayList<Block>();

    public static void main(String[] args) {
        blockchain.add(new Block("First Block", "0"));
        System.out.println("Mining Starting for 1st Block");
        blockchain.get(0).mineBlock(handler);

        blockchain.add(new Block("Second Block",blockchain.get(blockchain.size()-1).hash));
        System.out.println("Mining Starting for 2nd Block");
        blockchain.get(1).mineBlock(handler);

        blockchain.add(new Block("Mining 3rd Block",blockchain.get(blockchain.size()-1).hash));
        System.out.println("Trying to Mine block 3... ");
        blockchain.get(2).mineBlock(handler);

        System.out.println("\nBlockchain is Valid: " + isChainValid());

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println("\nThe block chain: ");
        System.out.println(blockchainJson);


        String blockJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);

        System.out.println(blockJson);


    }


    public static boolean isChainValid(){
        Block previous;
        Block current;
        for(int i=1; i<blockchain.size(); i++){
            current = blockchain.get(i);
            previous = blockchain.get(i-1);

            if(!current.hash.equals(current.calculateHash())){
                System.out.println("BlockChain is invalid");

                return false;

            }
            if(!previous.hash.equals(previous.calculateHash())){
                System.out.println("BlockChain is Quite Invalid");


                return false;
            }

        }

        return true;

    }
}
