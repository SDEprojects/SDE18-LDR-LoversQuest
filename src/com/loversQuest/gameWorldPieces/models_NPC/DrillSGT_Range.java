package com.loversQuest.gameWorldPieces.models_NPC;

import com.loversQuest.gameWorldPieces.Location;
import com.loversQuest.gameWorldPieces.NonPlayerCharacters;
import com.loversQuest.gameWorldPieces.Player;

public class DrillSGT_Range extends NonPlayerCharacters {
    public static int shootingScore = 0;


    public DrillSGT_Range(String name, String description, Location location, NPC_Properties properties){
        super(name, description,location, properties);
    }

    @Override
    public String interact(Player player) {
        String returnMsg = "get contact? shoot back! (with Knife hand)";
        /**
         * TODO: write DrillHwak_eyes interact, meet player at range and shoot
         */
        return returnMsg;
    }


    public static int getShootingScore() {
        return shootingScore;
    }

    public static void setShootingScore(int shootingScore) {
        DrillSGT_Range.shootingScore = shootingScore;
    }
}
