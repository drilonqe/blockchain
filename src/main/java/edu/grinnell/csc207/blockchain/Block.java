package edu.grinnell.csc207.blockchain;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * A single block of a blockchain.
 */
public class Block {

    private int num;
    private int amount;
    private Hash prevHash;
    private Hash hash;
    private long nonce;

    public Block(int num, int amount, Hash prevHash) {
        this.num = num;
        this.amount = amount;
        this.prevHash = prevHash;
        // I do not know what to do beyond this
    }

    public Block(int num, int amount, Hash prevHash, long nonce) {
        this.num = num;
        this.amount = amount;
        this.prevHash = prevHash;
        this.nonce = nonce;
        // or this
    }
    
    public static byte[] calculateHash(String msg) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("sha-256");
    md.update(msg.getBytes());
    byte[] hash = md.digest();
    ByteBuffer.allocate(4).putInt(x).array();
    return hash;
}
    /**
     * returns the number of this block.
     *
     * @return block number
     */
    public int getNum() {
        return num;
    }

    /**
     * returns the amount transferred that is recorded in this block.
     *
     * @return transaction amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * returns the nonce of this block.
     *
     * @return nonce
     */
    public long getNonce() {
        return nonce;
    }
    
    /**
     * returns the hash of the previous block in the blockchain.
     * 
     * @return previous block hash
     */
    public Hash getPrevHash() {
        return prevHash;
    }
    
    /**
     * returns the hash of this block.
     * 
     * @return hash of block
     */
   public Hash getHash() {
        return hash;
    }
   
   public String toString(){
       return String.format("Block %d  (Amount: %d, Nonce: %d, prevHash: %s, hash: %s)",
                num, amount, nonce, prevHash.toString(), hash.toString());
   }
}
