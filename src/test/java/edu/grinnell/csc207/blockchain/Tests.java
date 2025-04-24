package edu.grinnell.csc207.blockchain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Tests {
    // TODO: fill me in with tests that you write for this project!

    @Test
    @DisplayName("Placeholder Test")
    public void placeholderTest() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testFirstBlockValid() throws NoSuchAlgorithmException {
        BlockChain blockchain = new BlockChain(100);
        assertEquals(1, blockchain.getSize());
        String blocktoStr = blockchain.toString();
        assertTrue(blocktoStr.contains("Block 0")); // make sure first block is in String
    }

    @Test
    public void mineValidHashAndNonce() throws NoSuchAlgorithmException {
        BlockChain blockchain = new BlockChain(100);
        Block mined = blockchain.mine(50);
        assertTrue(mined.getHash().isValid()); // hash needs to be valid
        assertTrue(mined.getNonce() >= 0); // nonce should not be negative
    }

    @Test
    public void testRemoveLast() throws NoSuchAlgorithmException {
        BlockChain blockchain = new BlockChain(100);
        Block block1 = blockchain.mine(10);
        blockchain.append(block1);
        String afterAppend = blockchain.toString();
        assertTrue(afterAppend.contains("Block 1"));
        assertEquals(2, blockchain.getSize()); // size should be 2 after appending
        blockchain.removeLast();
        assertEquals(1, blockchain.getSize()); // size should be 1 after removing last
        String afterRemove = blockchain.toString();
        assertTrue(!afterRemove.contains("Block 1"));
    }

}
