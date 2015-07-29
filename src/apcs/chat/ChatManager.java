package apcs.chat;

import java.util.ArrayList;

import com.tywilly.WillyEngine.Engine;
import com.tywilly.WillyEngine.entity.text.Text;
import com.tywilly.WillyEngine.scene.SceneManager;

public class ChatManager {

	static ArrayList<Text> chat = new ArrayList<Text>();
	
	public static void addMessage(String message){
		
		Text msg = new Text(10, Engine.display.getHeight() - 50, 4, 18, message);
		
		if(chat.size() >= 5){
			
			chat.remove(0);
			
		}
		
		for(int i=0;i<chat.size();i++){
			chat.get(i).setY(chat.get(i).getY() - 25);
		}
		
		chat.add(msg);
		
		SceneManager.getCurrentScene().addEntity(msg);
		
	}
	
}
