import java.util.Date;

public class Block {

	public String hash;
	public String prevHash;
	private String data; // 블록의 데이터를 지니고 있음
	private long timeStamp;
	private int nonce;

	// Block Constructor
	public Block(String data, String prevHash) {
		this.data = data;
		this.prevHash = prevHash;
		this.timeStamp = new Date().getTime();
		this.hash = calcHash();
	}

	// Calculate new hash based on blocks contents
	public String calcHash() {
		String calcHash = StringUtil.applySHA256(prevHash + Long.toString(timeStamp) + Integer.toString(nonce) + data);
		return calcHash;
	}

	public void mineBlock(int difficulty) {
		String target = new String(new char[difficulty]).replace('\0', '0');
		while (!hash.substring(0, difficulty).equals(target)) {
			nonce++;
			hash = calcHash();
		}
		System.out.println("Block Mined!!!");
		System.out.println("hash: " + hash);
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * Block genesisBlock = new Block("Genesis Block", "0");
	 * System.out.println("Data: " + genesisBlock.data);
	 * System.out.println("prevhash: " + genesisBlock.prevHash);
	 * System.out.println("hash: " + genesisBlock.hash + "\n");
	 * 
	 * Block secondBlock = new Block("Second Block", genesisBlock.hash);
	 * System.out.println("Data: " + secondBlock.data);
	 * System.out.println("prevhash: " + secondBlock.prevHash);
	 * System.out.println("hash: " + secondBlock.hash + "\n");
	 * 
	 * Block thirdBlock = new Block("Third Block", secondBlock.hash);
	 * System.out.println("Data: " + thirdBlock.data);
	 * System.out.println("prevhash: " + thirdBlock.prevHash);
	 * System.out.println("hash: " + thirdBlock.hash + "\n"); }
	 */

}
