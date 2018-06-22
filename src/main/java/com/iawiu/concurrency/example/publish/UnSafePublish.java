package com.iawiu.concurrency.example.publish;


import com.iawiu.concurrency.annotactions.NotThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@NotThreadSafe
public class UnSafePublish {

    private static Logger log = LoggerFactory.getLogger(UnSafePublish.class);

    private String[] states = {"a", "b", "c"};

    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        UnSafePublish publish = new UnSafePublish();
        log.info("{}", Arrays.toString(publish.getStates()));

        publish.getStates()[0] = "d";
        log.info("{}", Arrays.toString(publish.getStates()));
    }
}
