package recior.cecior.util.settings;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import recior.cecior.util.json.IORHelper;
import recior.cecior.util.logger.Logger;

public class Setting {
	
	static Logger log = new Logger("SETTINGS");
	static String s = System.getProperty("user.dir");
	static File S = new File(s + "settings.json");
	public ArrayList<SettingPairS<SettingPair, Boolean>> SMAP = new ArrayList<>();

	//Example Classes
	SettingPair THREAD_TO_BE_USED;
	SettingPair DEFAULT_PROXY_LOC;
	SettingPair OUTPUT_LOC;
	
	//In future
	SettingPair CONFIG_LOC;
	
	//JSON
	static IORHelper J = new IORHelper(S);
	//JSON
	
	public static void save() {
		//code as your prefrence
	}
	
	public static File getFile() {
		return S;
	}
	
	public static void CreateSettings() {
		try {
			if(!S.exists()) {
			 S.createNewFile();
			} else {
				return;
			}
		} catch (IOException e) {
			log.log("Could not create new Settings File. Create new Manually.");
		}
	}
	
	public static void LOADSETTINGS() {
		J.read();
	}
	
}
