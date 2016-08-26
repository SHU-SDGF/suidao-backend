package com.tunnel.core;

import org.springframework.stereotype.Component;

import com.tunnel.enums.JobsEnum;

import java.util.UUID;

/**
 * Generates a unique random generator on each call
 * Created by Wayne Cao on 6/22/2016.
 */
@Component
public class RandomUnqIdGenerator {

    /**
     * Unique random generator prefixed by the passed the jobName
     *
     * @param jobName The Jobs enum
     * @return Unique string of the format <job name>_3b1b6c57-a799-4b63-bfdf-a581ea8fe808
     */
    public String generateUnqSeq(JobsEnum jobName) {
        return jobName + "_" + UUID.randomUUID().toString();
    }
}
