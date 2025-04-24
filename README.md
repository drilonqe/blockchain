# Project: Block Chain

Authors: Drilon Qerimi
### Grader Comment:
Please run mvn checkstyle:check to see your style errors and to correct them!
Additionally, your program seems to compile but not provide any driver to run the program. Please ensure that the driver is at least displayed and somewhat operational.

### Changelog 
+ Fixed style errors by adding Javadoc comments for constructors and methods in Block.java, BlockChain.java, and Hash.java.
+ Completed the command-line interface in BlockChainDriver.java, including commands: mine, append, remove, check, report, help, and quit.
+ Resolved previous grader feedback by ensuring the driver runs correctly and displays the interactive menu.
+ Cleaned up style issues (line length, indentation, Javadoc) as per mvn checkstyle:check recommendations.

The code now should run correctly and produce the desired result.


## Resources

*   (_TODO: fill in resources here!_)
+ I used Java Version 23.0.2
+ I used Visual Studio Code as an IDE
+ I used the classroom page made by prof. Osera as reference
source: https://osera.cs.grinnell.edu/ttap/data-structures-labs/ 
source: https://osera.cs.grinnell.edu/ttap/data-structures
+  Forked the repository from Github, made by Prof.Osera:
https://github.com/psosera/blockchain
+ In Block.java, I got help in Prof. Osera's office hours, where he helped me with
mining a Block and mining the nonce.
+ https://www.w3schools.com/java/java_user_input.asp used this resource to gain
insight of how to use scanner to get user input.
+ Got advice from classmate Fui as to how to read integer input from the user using
 Integer.parseInt and long input using Long.parseLong in BlockChainDriver.java
+ In  BlockChainDriver.java for writing the switch (command) logic properly source:
  https://www.w3schools.com/java/java_switch.asp
+ Got advice from classmate Fui as to how to implement isValidBlockchain() method
in BlockChain.java


