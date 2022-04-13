package tw.com.hitrust.hello.vo;

import java.io.Serializable;

public class ResponseVO<E> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ResHeaderVO resHeader;
	
	private E resBody;
	
	private ReqHeaderVO reqHeader;
	
	private E reqBody;

	public ResHeaderVO getResHeader() {
		return resHeader;
	}

	public void setResHeader(ResHeaderVO resHeader) {
		this.resHeader = resHeader;
	}

	public E getResBody() {
		return resBody;
	}

	public void setResBody(E resBody) {
		this.resBody = resBody;
	}
	
	
}
