package be.technifutur.applicationMVC;

import be.technifutur.applicationRunner2.InteractiveRunner;

public class MVCFramework {
	
	public <T> void start(MVCFactory<T> app) {
		T model = app.getModel();
		Controller<T> ctrl = app.getController();
		Vue<T> vue = app.getVue();
		
		InteractiveRunner runner = new InteractiveRunner();
		ApplicationMVC<T> appMVC = new ApplicationMVC<T>();
		appMVC.setController(ctrl);
		appMVC.setModel(model);
		appMVC.setVue(vue);
		runner.setApplication(appMVC);
		runner.run();
	}

}
