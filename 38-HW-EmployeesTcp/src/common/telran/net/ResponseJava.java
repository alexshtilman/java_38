package common.telran.net;

import java.io.Serializable;

public class ResponseJava implements Serializable{

	
	private static final long serialVersionUID = 1L;
	public TcpResponseCode code;
	public Serializable responseData;
	public ResponseJava(TcpResponseCode code, Serializable responseData) {
		super();
		this.code = code;
		this.responseData = responseData;
	}
	

}
