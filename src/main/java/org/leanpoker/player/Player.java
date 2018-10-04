package org.leanpoker.player;

import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonObject;
import org.leanpoker.models.CardModel;
import org.leanpoker.models.PlayerModel;
import org.leanpoker.parser.CardJsonParser;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {

		CardJsonParser cardJsonParser  = new CardJsonParser();
		PlayerModel playerModel = cardJsonParser.parseRequest(request);
    	// Check if we have any figure
    	
    	// Check how much money we have
    	
    	// Check or bet minimum raise
    	
    	
        return 0;
    }

    public static void showdown(JsonElement game) {
    }
    
    public static List<List<CardModel>> sortCardsByRank(List<CardModel> cardList) {
    	List<List<CardModel>> result = new ArrayList<>();
    	List<String> ranksAlreadyChecked = new ArrayList();
    	
    	for (int i = 0; i < cardList.size(); i++) {
    		CardModel currentCard = cardList.get(i);
    		if (!ranksAlreadyChecked.contains(currentCard.getRank())) {
    			
    			ranksAlreadyChecked.add(currentCard.getRank());
    			List<CardModel> foundFigure = new ArrayList<>();
    			foundFigure.add(currentCard);
    			
        		for (int k = 0; k < cardList.size(); k++) {
        			CardModel nextCard = cardList.get(k);
        			
        			if (!currentCard.equals(nextCard) && currentCard.getRank().equals(nextCard.getRank())) {
        				foundFigure.add(nextCard);
        			}
        		}
        		
        		if (foundFigure.size() > 1) {
    				result.add(foundFigure);
    			}
    		}
    	}
    	return result;
    }
}
