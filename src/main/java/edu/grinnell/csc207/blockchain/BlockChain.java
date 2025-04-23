package edu.grinnell.csc207.blockchain;

import java.security.NoSuchAlgorithmException;

/**
 * A linked list of hash-consistent blocks representing a ledger of
 * monetary transactions.
 */
public class BlockChain {
    private static class Node {
        Block block;
        Node next;

        public Node(Block block) {
            this.block = block;
            this.next = null;
        }

    }

    private Node first; // first element
    private Node last; // last element
    private int size; // number of blocks

    /**
     * creates a BlockChain that possess a single block the starts
     * with the given initial amount. Note that to create this block,
     * the prevHash field should be ignored when calculating the
     * block's own nonce and hash.
     * 
     * @param initial starting amount for first block
     */
    public BlockChain(int initial) throws NoSuchAlgorithmException {
        Block firstBlock = new Block(0, initial, null);

        first = new Node(firstBlock);
        last = first;

        size = 1;

    }

    /**
     * mines a new candidate block to be added to the list. The
     * returned Block should be valid to add onto this list.
     * 
     * @param amount transaction amount
     * @return new block
     */
    public Block mine(int amount) throws NoSuchAlgorithmException {
        return new Block(getSize(), amount, getHash());

    }

    /**
     * Returns the number of blocks in the blockchain.
     *
     * @return size of the blockchain
     */
    public int getSize() {
        return size;
    }

    /**
     * appends block to the blockchain
     * 
     * @param blk valid block to append
     */
    public void append(Block blk) {
        Node newBlock = new Node(blk);
        last.next = newBlock;
        last = newBlock;
        size++;
    }

    /**
     * removes the last block from the chain
     * 
     * @return true if block was removed, false otherwise.
     */
    public boolean removeLast() {
        if (size == 1) {
            return false;
        }
        Node cur = first;
        while (cur.next != last) {
            cur = cur.next;
        }
        cur.next = null;
        last = cur;
        size--;
        return true;
    }

    /**
     * returns the hash of the last block in the chain.
     *
     * @return hash
     */
    public Hash getHash() {
        return last.block.getHash();
    }

    /**
     * walks the blockchain and ensures that its blocks
     * are consistent and valid.
     * 
     * @return true is blocks are valid, false otherwise
     */
    public boolean isValidBlockChain() {
        return true;
        // still need to implement
    }

    /**
     * prints Alice's and Bob's respective balances
     * in the form Alice: <amt>, Bob: <amt> on a single line
     */
    public void printBalances() {
        // need to implement
    }

    /**
     * the string representation of each of Blockchain blocks
     * 
     * @return a string representation of the BlockChain
     */
    public String toString() {
        return null;
        // need to implement
    }
}
