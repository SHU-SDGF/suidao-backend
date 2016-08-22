package com.tunnel.enums;

public enum UserActivityEnum {

	LOGGED_OUT("User has logged out"), SESSION_EXPIRED("Session expired"), BROWSER_CLOSE("User closed the broswer"), LOGGED_IN(
			"User has logged in"), APP_SHUTDOWN("Application has been shutdown");

    private String msg;

	UserActivityEnum(String msg) {
		this.msg = msg;
	}

	public String message() {
		return msg;
	}

}
