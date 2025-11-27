class FriendsOOPS{
    String name;

    static int numberOfFriends; //! Static is used to kkeep track of an attribute which will be similar to all objects of the class

    FriendsOOPS(String name) {
        this.name = name;
        numberOfFriends++;
    }

}