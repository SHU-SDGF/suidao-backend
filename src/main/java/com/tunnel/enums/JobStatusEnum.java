package com.tunnel.enums;

/**
 * Possible States for a submitted job
 */
public enum JobStatusEnum {
	NOT_INITIATED, SUBMITTED, RUNNING , COMPLETED, 
	KILLED, FAILED,UNKNOWN, SUBMISSION_FAILURE
}
