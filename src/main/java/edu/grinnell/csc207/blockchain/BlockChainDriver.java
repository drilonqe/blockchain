package edu.grinnell.csc207.blockchain;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * The main driver for the block chain program.
 */
public class BlockChainDriver {

    /**
     * The main entry point for the program.
     * 
     * @param args the command-line arguments
     *             Citation: https://www.w3schools.com/java/java_switch.asp ,
     *             Got advice from classmate Fui as to how to read integer input
     *             from user using Integer.parseInt and long input using
     *             Long.parseLong
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {
        if (args.length != 1) {
            return;
        }
        int initial = Integer.parseInt(args[0]);
        BlockChain blockchain = new BlockChain(initial);
        Scanner scanner = new Scanner(System.in);
        System.out.println(blockchain.toString());

        while (true) {
            System.out.println("command ?");
            String command = scanner.nextLine();

            switch (command) {
                case "mine":
                    System.out.println("Amount transferred? ");
                    int mineAmt = Integer.parseInt(scanner.nextLine());
                    Block minedBlock = blockchain.mine(mineAmt);
                    System.out.println("Amount = " + mineAmt
                            + ", Nonce = " + minedBlock.getNonce());
                    break;

                case "append":
                    System.out.println("Amount transferred? ");
                    int appendAmt = Integer.parseInt(scanner.nextLine());
                    System.out.println("Nonce? ");
                    long appendNonce = Long.parseLong(scanner.nextLine());
                    Block newBlock = new Block(blockchain.getSize(), appendAmt,
                            blockchain.getHash(), appendNonce);
                    blockchain.append(newBlock);
                    System.out.println(blockchain.toString());
                    break;

                case "remove":
                    blockchain.removeLast();
                    break;

                case "check":
                    if (blockchain.isValidBlockChain()) {
                        System.out.println("Blockchain is valid!");
                        break;
                    } else {
                        System.out.println("Blockchain is not valid!");
                        break;
                    }

                case "report":
                    blockchain.printBalances();
                    break;

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

                case "quit":
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid Command");

            }
        }

    }
}
