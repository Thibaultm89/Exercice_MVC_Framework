package be.technifutur.applicationMVC;

import be.technifutur.applicationRunner2.InteractiveApplication;

public class ApplicationMVC<T> implements InteractiveApplication {
	
	private Controller<T> controller;
	private Vue<T> vue;
	private T model;
	
	@Override
	public void start() {
		this.controller.setModel(this.model);
		this.vue.setModel(this.model);
		this.controller.start();
		this.vue.start();
	}

	@Override
	public StringBuilder getScreen() {
		return this.vue.getScreen();
	}

	@Override
	public boolean isFinish() {
		return this.controller.isFinish();
	}

	@Override
	public void newInput(String input) {
		this.controller.newInput(input);
	}

	@Override
	public void stop() {
		this.controller.stop();
		this.vue.stop();
	}

	@Override
	public boolean hasLastScreen() {
		return this.controller.hasLastScreen();
	}
	
	public void setController(Controller<T> controller) {
		this.controller = controller;
	}
	
	public void setVue(Vue<T> vue) {
		this.vue = vue;
	}
	
	public void setModel(T model) {
		this.model = model;
	}

}
