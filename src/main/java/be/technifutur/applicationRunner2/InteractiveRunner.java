package be.technifutur.applicationRunner2;

public class InteractiveRunner implements Runnable {

	 private InteractiveApplication application;
	    private String input;
	    private Environnement environnement = new ConsoleEnvironnement();

	    public Environnement getEnvironnement(){
	        return environnement;
	    }

	    public void setEnv(Environnement env) {
	        if(env == null) {
	           throw new NullEnvironnementException();
	        }
	        this.environnement = env;
	    }

	    @Override
	    public void run() {
	        if(application != null) {
	            application.start();
	            while(!application.isFinish()) {
	                environnement.print(application.getScreen().toString());
	              //  if(!application.isFinish()) {
	                application.newInput(environnement.nextLine());
	                // }
	            }
	            if (application.hasLastScreen()) {
	            	environnement.print(application.getScreen().toString());
	            }
	            application.stop();
	        }
	    }

	    public InteractiveApplication getApplication() {
	        return this.application;
	    }

	    public void setApplication(InteractiveApplication application) {
	        this.application = application;
	    }
	}
