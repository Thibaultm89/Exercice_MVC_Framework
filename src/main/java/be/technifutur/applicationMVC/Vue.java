package be.technifutur.applicationMVC;

public interface Vue<T> {
	
	void start();
	StringBuilder getScreen();
	void stop();
	void setModel(T model);
}
