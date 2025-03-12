package edu.grinnell.csc207.blockchain;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * The main driver for the block chain program.
 */
public class BlockChainDriver {
   
    /**
     * The main entry point for the program.
     * @param args the command-line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {
        if (args.length != 1) {
            return; 
        }
    int initial = Integer.parseInt(args[0]);
    BlockChain blockchain = new BlockChain(initial);
    Scanner scanner = new Scanner(System.in);

    System.out.println(blockchain.toString());

    while(true) {
        System.out.println("command ?");
        String command = scanner.nextLine();

        switch(command) {
             case "help":
                    System.out.println("Valid commands:");
                    System.out.println("    mine: discovers the nonce for a given transaction");
                    System.out.println("    append: appends a new block onto the end of the chain");
                    System.out.println("    remove: removes the last block from the chain");
                    System.out.println("    check: checks that the blockchain is valid");
                    System.out.println("    report: reports the balances of Alice and Bob");
                    System.out.println("    help: prints this list of commands");
                    System.out.println("    quit: quits the program");
                    break;
            
        }
    }

    }  
}
