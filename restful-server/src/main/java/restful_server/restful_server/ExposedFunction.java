package restful_server.restful_server;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ExposedFunction {

	@Inject
	public ExposedFunction() {
	}
	
	
	public void calledFuntion() {
		System.out.println("Hello called function");
	}
}
