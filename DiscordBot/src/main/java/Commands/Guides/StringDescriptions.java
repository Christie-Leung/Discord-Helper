package Commands.Guides;

import java.util.ArrayList;
import java.util.List;

public class StringDescriptions {

    static List<String> addFriends = getAddFriend();
    static List<String> addFriendsImages = getAddImages();


    static List<String> getAddFriend() {
        List<String> desc = new ArrayList<>();
        desc.add("https://cdn.discordapp.com/attachments/821824091261763609/821834436630151238/unknown.png Following the action shown above, click on the person you would like to friend");
        //desc.add();

        return desc;
    }

    static List<String> getAddImages() {
        List<String> images = new ArrayList<>();
        images.add("https://cdn.discordapp.com/attachments/821824091261763609/821834436630151238/unknown.png");
        //desc.add();

        return images;
    }
}