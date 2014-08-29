package in.k2s.core.exception.base;

import in.k2s.core.interfaces.Message;

import java.util.ArrayList;
import java.util.List;

public class BaseBusinessException extends BaseException {
	
	private static final long serialVersionUID = 259814060914378429L;
	
	private List<Message> messages = new ArrayList<Message>();
	
	public BaseBusinessException() {
		super();
	}
	
	public BaseBusinessException(List<Message> messages, Throwable cause) {
		super(cause);
		this.messages = messages;
	}
	
	public BaseBusinessException(List<Message> messages) {
		this.messages = messages;
	}
	
	public BaseBusinessException(Message ... messages) {
		for(Message message : messages) {
			this.messages.add(message);
		}
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	public void addMessage(Message message) {
		messages.add(message);
	}

}