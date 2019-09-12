package be.technifutur.applicationRunner2;

import be.technifutur.applicationRunner2.Environnement;
import be.technifutur.applicationRunner2.InteractiveApplication;
import be.technifutur.applicationRunner2.InteractiveRunner;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.easymock.EasyMock;

import static org.junit.jupiter.api.Assertions.*;


public class InteractiveRunnerTest {

	    private InteractiveRunner runner;
	    private InteractiveApplication applicationMock;
	    private Environnement environnementMock;
	    public boolean called = false;

	    @BeforeEach
	    public void init() {
	        runner = new InteractiveRunner();
	        //applicationMock = createApplication();
	        applicationMock = EasyMock.createMock(InteractiveApplication.class);
	        runner.setApplication(applicationMock);
	        environnementMock = EasyMock.createMock(Environnement.class);
	        runner.setEnv(environnementMock);
	    }

	    @Test
	    public void testSetApplicationNotNull(){
	        assertAll(() -> assertNotNull(runner.getApplication()),
	                () -> assertSame(applicationMock, runner.getApplication()));

	    }

	    @Test
	    public void testGetScreenReturnTest1(){
	        applicationMock.start();
	        EasyMock.expect(applicationMock.isFinish()).andReturn(false);
	        EasyMock.expect(applicationMock.getScreen()).andReturn(new StringBuilder("toto"));
	        environnementMock.print("toto");
	        EasyMock.expect(environnementMock.nextLine()).andReturn("Ok");
	        applicationMock.newInput("Ok");
	        EasyMock.expect(applicationMock.isFinish()).andReturn(true); // 3 au lieu de 2 car il appelle 3 fois la methode
	        EasyMock.expect(applicationMock.hasLastScreen()).andReturn(true);
	        EasyMock.expect(applicationMock.getScreen()).andReturn(new StringBuilder("Bonjour Ok"));
	        environnementMock.print("Bonjour Ok");
	        applicationMock.stop();
	        EasyMock.replay(environnementMock,applicationMock);
	        runner.run();
	        EasyMock.verify(environnementMock,applicationMock);
	    }
	    String result = "";

	    private void setEnv(){
	        runner.setEnv(new Environnement() {
	            @Override
	            public void print(CharSequence out) {
	                result = out.toString();
	            }

	            @Override
	            public String nextLine() {
	                return null;
	            }
	        });
	    }
	    @Test
	    public void testRunCallsStart() {
	        applicationMock.start();
	        EasyMock.expect(applicationMock.isFinish()).andReturn(true);
	        EasyMock.expect(applicationMock.hasLastScreen()).andReturn(false);
	        applicationMock.stop();
	        EasyMock.replay(applicationMock);
	        runner.run();
	        EasyMock.verify(applicationMock);
//	        assertTrue(called);
	    }

//	    private InteractiveApplication createApplication() {
//	        return new InteractiveApplication() {
//	            private int cpt;
//	            @Override
//	            public void start() {
//
//	                InteractiveRunnerTest.this.called = true;
//
//	            }
//
//	            @Override
//	            public StringBuilder getScreen() {
//	                return new StringBuilder("test1");
//	            }
//
//	            @Override
//	            public boolean isFinish() {
//	                this.cpt++;
//	                return cpt > 1;
//	            }
//
//	            @Override
//	            public void newInput(String input) {
//
//	            }
//
//	            @Override
//	            public void stop() {
//
//	            }
//	        };
	    }
