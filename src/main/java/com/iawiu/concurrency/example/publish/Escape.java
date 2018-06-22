package com.iawiu.concurrency.example.publish;

import com.iawiu.concurrency.annotactions.NotRecommend;
import com.iawiu.concurrency.annotactions.NotThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@NotThreadSafe
@NotRecommend
public class Escape {

    private static Logger log = LoggerFactory.getLogger(Escape.class);

    private int thisCanBeEscape = 0;

    public Escape() {
        new InnerClass();
    }

    private class InnerClass {

        public InnerClass() {
            log.info("{}", Escape.this.thisCanBeEscape);
        }

    }

    public static void main(String[] args) {
        new Escape();
    }
}
