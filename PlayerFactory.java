/**
 * Player Factory class.
 */
public class PlayerFactory  {
    /**
     * Default Ctr.
     */
    public PlayerFactory(){}

    /**
     * build player
     * @param type string of the player type
     * @return player type object
     */
    public Player buildPlayer(String type){
        switch (type.toLowerCase()){
            case "human":
                return new HumanPlayer();
            case "clever":
                return new CleverPlayer();
            case "whatever":
                return new WhateverPlayer();
            case "genius":
                return new GeniusPlayer();
            default:
                return null;
        }
    }


}


