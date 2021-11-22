package recior.cecior.util.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

import recior.cecior.util.logger.Logger;
import recior.cecior.util.settings.Setting;
import recior.cecior.util.settings.SettingPair;
import recior.cecior.util.settings.SettingPairS;

public class IORHelper {

	Logger log = new Logger("JSONHELPER");
	public BufferedReader READER;
	public ArrayList<String> LINES = new ArrayList<>();
	public HashMap RMAP = new HashMap<>();
	public String FWRITE;
	public File file;
	
	public IORHelper(File file) {
		if(file !=null && !(file.isDirectory()) && file.isFile()) {
			if(file.canRead()) {
				if(file.getAbsolutePath().endsWith(".ior")) {
					try {
						BufferedReader RD = new BufferedReader(new FileReader(file));
						this.READER = RD;
						this.file = file;
					} catch (FileNotFoundException e) {
						log.log("Did " + file.getAbsolutePath() + " get deleted?");
						log.log("Creating settings.json again.");
						Setting.CreateSettings();
					}
				}
			} else {
				log.log("Cannot read the file!");
			}
		}
	}
	
	public void read() {
		if(this.READER !=null) {
			String LINE;
			try {
				while((LINE = this.READER.readLine()) !=null){
					this.LINES.add(LINE);
				}
			} catch (IOException e) {
				log.log("Could not read Settings!");
			}
		} else {
			log.log(":/ Problem Detected, ReRun the Program or Open Issue on GitHub.");
		}
	}
	
	public void ParseThis(int mode) {
		
		//TODO BETTER.
		if(mode == 1) {
		int i;
		for(i = 0; i < this.LINES.size(); i++) {
			String LINE = this.LINES.get(i);
			String LLINE = LINE.trim();
			String KEY = LLINE.split("||")[0];
			String LLLINE = LLINE.split("||")[1];
			int VALUE = Integer.valueOf(LLLINE);
			if(this.isNumeric(LLINE)) {
			 this.RMAP.put(KEY, VALUE);
			} else {
				this.RMAP.put(KEY, LLLINE);
			}
		 }
		
		}
	}
		
		private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

		public boolean isNumeric(String strNum) {
		    if (strNum == null) {
		        return false; 
		    }
		    return pattern.matcher(strNum).matches();
		}
	
	
	//ADDS FINAL string + contcats them. ex - Help:1\n six:2
	public void addSetting(ArrayList<SettingPairS<SettingPair, Boolean>> SPAIR) {	 
		StringBuilder ST = new StringBuilder();
		int i;
		for(i =0; i > SPAIR.size(); i++) {
			StringBuilder SK = new StringBuilder();
			if(SPAIR.get(i).getValue()) {
			 SettingPair THIS = SPAIR.get(i).getKey();
			 SK.append(THIS.getKey());
			 SK.append("||");
			 SK.append(THIS.getValue());
			 ST.append(SK.toString());
			 ST.append("\n");
			}
		}
	}
	
	public void write() {
		 FileOutputStream WRITER = null;
		    try {
		        WRITER = new FileOutputStream(this.file);
		        WRITER.write(this.FWRITE.getBytes("UTF-8"));
		    } catch (IOException e) {
		        try {
					WRITER.close();
				} catch (IOException e1) {
					log.log("How did you manage to get this error?????");
				}
		        log.log("could not write the settings :C!");
		    }
	}
	
}
