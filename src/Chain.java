import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class Chain {

	public static ArrayList<Block> blockchain = new ArrayList<>();
	public static int difficulty=5;

	public static Boolean isChainValid() {
		Block currBlock;
		Block prevBlock;
		String hashTarget=new String(new char[difficulty]).replace('\0', '0');

		// loop through blockchain to check hashes
		for (int i = 1; i < blockchain.size(); i++) {
			currBlock = blockchain.get(i);
			prevBlock = blockchain.get(i - 1);

			// compare registered hash and calculated hash
			if (!currBlock.hash.equals(currBlock.calcHash())) {
				System.out.println("Current Hashes not equal");
				return false;
			}

			// compare previous hash and registered previous hash
			if (!prevBlock.hash.equals(currBlock.prevHash)) {
				System.out.println("Previous Hashes not equal");
				return false;
			}
			
			//check if hash is solved
			if(!currBlock.hash.substring(0, difficulty).equals(hashTarget)) {
				System.out.println("This block hasn't been mined");
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		blockchain.add(new Block("Genesis Block", "0"));
		System.out.println("Trying to Mine block 1...");
		blockchain.get(0).mineBlock(difficulty);
		
		blockchain.add(new Block("Second Block", blockchain.get(blockchain.size() - 1).hash));
		System.out.println("Trying to Mine block 2...");
		blockchain.get(1).mineBlock(difficulty);
		
		blockchain.add(new Block("Third Block", blockchain.get(blockchain.size() - 1).hash));
		System.out.println("Trying to Mine block 3...");
		blockchain.get(2).mineBlock(difficulty);

		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		System.out.println("\nThe block chain: ");
		System.out.println(blockchainJson);
	}

}
