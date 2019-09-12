package be.technifutur.applicationMVC;

public interface MVCFactory<T> {
	
	T getModel();
	Controller<T> getController();
	Vue<T> getVue();
	
}
