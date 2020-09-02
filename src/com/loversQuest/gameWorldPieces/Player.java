package com.loversQuest.gameWorldPieces;

import com.loversQuest.IO.GraphicClass;

import java.io.IOException;

public class Player {

    private String name;
    private Location currentLocation;

    //  making item instance for testing
//    Item item = new Item("WhiteClaw", 1);
    public RuckSack ruckSack = new RuckSack();
    GraphicClass graphicImage = new GraphicClass();

//    RuckSack ruckSack = new RuckSack(item.getName(), item.getQuantity());

    // CTOR
    public Player(String name, Location currentLocation) {
        this.name = name;
        this.currentLocation = currentLocation;
    }

    // BUSINESS METHODS

    //go function can result in navigating to "NOTHING" area. need to error check if
    // indicated direction is not a room and prevent movement.
    public boolean go(String directionInput) throws IOException {

        String direction = directionInput.toLowerCase();

        switch (direction) {
            case "east":
                if (validateLocation(this.currentLocation.getEast())) {
                    this.setCurrentLocation(this.currentLocation.getEast());
                    this.printCurrentAscii();
                } else {
                    System.out.println("You can't go that way");
                }
                break;
            case "west":
                if (validateLocation(this.currentLocation.getWest())) {
                    this.setCurrentLocation(this.currentLocation.getWest());
//                    When player goes to a location successfully
//                    print ASCII art associated to current location
                    this.printCurrentAscii();
                } else {
                    System.out.println("You can't go that way");
                }
                break;
            case "south":
                if (validateLocation(this.currentLocation.getSouth())) {
                    this.setCurrentLocation(this.currentLocation.getSouth());
                    this.printCurrentAscii();
                } else {
                    System.out.println("You can't go that way");
                }
                break;
            case "north":
                if (validateLocation(this.currentLocation.getNorth())) {
                    this.setCurrentLocation(this.currentLocation.getNorth());
                    this.printCurrentAscii();
                } else {
                    System.out.println("You can't go that way");
                }
                break;
            default:
                System.out.println("bad input, try again");
                return false;
        }
        return true;
    }

    // checks if a given location is a place a player can move
    public boolean validateLocation(Location destination){
        return !destination.getName().equals("NOTHING");
    }

    public void look() {
        System.out.println(this.getCurrentLocation().getDescription());
    }

    public void addItem(String item) {
        // call item.addItem() to add item/quantity to ruckSack
        ruckSack.addItem(item);
    }

    public void displayItems() {
        ruckSack.displayRuckSackContents();
    }

    // SETTERS/GETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getCurrentLocation() {

        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }


    public String interact(){
        return currentLocation.getOccupant().getName();
    }

    public void printCurrentAscii() throws IOException {
        if (this.currentLocation.getName().toLowerCase().equals("laundryroom")){
            graphicImage.printLocation("laundryRoom.txt");
        } else if(this.currentLocation.getName().toLowerCase().equals("barracks")){
            graphicImage.printLocation("home.txt");
        }
    }
}
