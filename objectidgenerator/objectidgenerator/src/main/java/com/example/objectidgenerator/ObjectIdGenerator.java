package com.example.objectidgenerator;

import java.nio.ByteBuffer;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ObjectIdGenerator {

    private static final int TIMESTAMP_LENGTH = 4;
    private static final int RANDOM_LENGTH = 5;
    private static final int COUNTER_LENGTH = 3;

    private static final AtomicInteger counter = new AtomicInteger(new Random().nextInt(0xFFFFFF));
    private static final byte[] randomValue = new byte[RANDOM_LENGTH];

    static {
        new Random().nextBytes(randomValue);
    }

    public static String generate() {
        ByteBuffer buffer = ByteBuffer.allocate(12);

        // 4-byte timestamp
        int timestamp = (int) (System.currentTimeMillis() / 1000);
        buffer.putInt(timestamp);

        // 5-byte random value
        buffer.put(randomValue);

        // 3-byte counter
        int count = counter.getAndIncrement() & 0xFFFFFF;
        buffer.put((byte) (count >> 16));
        buffer.put((byte) (count >> 8));
        buffer.put((byte) count);

        // Convert to hexadecimal string
        StringBuilder hexString = new StringBuilder();
        for (byte b : buffer.array()) {
            hexString.append(String.format("%02x", b));
        }

        return hexString.toString();
    }
}
