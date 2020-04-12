package com.spittr.exception;

//@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Spittle not found", value = HttpStatus.NOT_FOUND)
public class SpittleNotFoundException  extends RuntimeException  {
	
	
	private static final long serialVersionUID = 12345L;
	
	private long spittleId;
	
	public long getSpittleId() {
		return spittleId;
	}

	public SpittleNotFoundException() {
		super();
	}
	
	public SpittleNotFoundException(long spittleId) {
		this.spittleId = spittleId;
	}

}
