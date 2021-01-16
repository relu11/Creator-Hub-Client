package Models;


import java.util.ArrayList;

public class FollowerState extends ViewerState {
    public FollowerState() {
    }

    public FollowerState(String name, String country, String email) {
        super(name, country, email);
    }

    public FollowerState(String id, String name, String country, String email, boolean banned, ArrayList<String> warnings) {
        super(id, name, country, email, banned, warnings);
    }

}
