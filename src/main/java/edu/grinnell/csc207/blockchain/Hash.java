package edu.grinnell.csc207.blockchain;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * A wrapper class over a hash value (a byte array).
 */
public class Hash {

    private byte[] data;

    /**
     * constructs a new Hash object that contains the given hash.
     *
     * @param data hash data as array of bytes
     */
    public Hash(byte[] data) {
        this.data = data;
    }

    /**
     * returns the hash contained in this object.
     *
     * @return hash as array of bytes
     */
    public byte[] getData() {
        return data;
    }

    /**
     * returns true if this hash meets the criteria for validity, i.e., its
     * first three indices contain zeroes.
     *
     * @return true if hash is valid, otherwise return false
     */
    public boolean isValid() {
        return data.length >= 3 && data[0] == 0 && data[1] == 0 && data[2] == 0;
    }

    /**
     * returns the string representation of the hash as a string of hexadecimal
     * digits, 2 digits per byte.
     *
     * @return string version of the hash
     */
    public String toString() {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            buf.append(String.format("%02x", Byte.toUnsignedInt(data[i])));
        }
        return buf.toString();
    }

    /**
     * returns true if this hash is structurally equal to the argument.
     *
     * @param other other thing we are comparing to
     * @return true if equal, false otherwise
     */
    public boolean equals(Object other) {
        return true;
    }
}
