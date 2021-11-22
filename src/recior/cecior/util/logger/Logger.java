package recior.cecior.util.logger;

public class Logger {

	String NAME;
	
	public Logger(String NAME) {
		if(NAME !=null) {
		 this.NAME = NAME;
		} else {
			this.log();
		}
	}
	
	public void log(String Message) {
		if(!(this.NAME == null) && !(this.NAME.isEmpty())) {
		 StringBuilder SB = new StringBuilder();
		 SB.append("[");
		 SB.append(this.NAME);
		 SB.append("]: ");
		 SB.append(Message);
		 System.out.println(SB.toString());
		} else {
			this.log();
		}
	}
	
	void log() {
		if(!(this.NAME == null) && !(this.NAME.isEmpty())) {
		 StringBuilder SB = new StringBuilder();
		 SB.append("[");
		 SB.append(this.getClass());
		 SB.append("]: ");
		 SB.append("Error while Logging! either Name null or exception!");
		 System.out.println(SB.toString());
		}
	}
}

