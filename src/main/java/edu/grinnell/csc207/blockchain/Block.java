package edu.grinnell.csc207.blockchain;

import java.nio.ByteBuffer;
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

    public Block(int num, int amount, Hash prevHash) throws NoSuchAlgorithmException {
        // citation: Prof Osera helped
        this.num = num;
        this.amount = amount;
        this.prevHash = prevHash;
        long possibleNonce = 0;

        while(true) {
        Hash possibleHash = calculateHash();
        if(possibleHash.isValid()) {
            this.nonce = possibleNonce;
            this.hash = possibleHash;
            break;
        }
        possibleNonce++;
        }
    }

    public Block(int num, int amount, Hash prevHash, long nonce) throws NoSuchAlgorithmException {
        // citation: Prof Osera helped
        this.num = num;
        this.amount = amount;
        this.prevHash = prevHash;
        this.nonce = nonce;
        this.hash = calculateHash();
    }
    
    public Hash calculateHash() throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("sha-256");
    // adding the block number 
    md.update(ByteBuffer.allocate(4).putInt(num).array());
    // adding the transaction amount
    md.update(ByteBuffer.allocate(4).putInt(amount).array());
    
    // add previous hash data
    if (prevHash != null) {
        md.update(prevHash.getData());
    }
    
    // adding nonce
    md.update(ByteBuffer.allocate(8).putLong(nonce).array());

    return new Hash(md.digest());
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
