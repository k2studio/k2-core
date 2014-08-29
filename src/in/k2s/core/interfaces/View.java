package in.k2s.core.interfaces;

import java.io.Serializable;
import java.util.List;

public interface View extends Serializable {
	
	public void addMessage(Message message);
	
	public List<Message> getMessages();
	
	public void setMessages(List<Message> messages);
	
	public void clearMessages();
	
	public boolean haveMessages();

}
