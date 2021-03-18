package Commands.Guides;

import java.util.ArrayList;
import java.util.List;

public class StringDescriptions {

    List<String> getAddFriend() {
        List<String> desc = new ArrayList<>();
        desc.add("Following the action shown below, **click on the person** you would like to friend");
        desc.add("Hover over their profile picture, and you should see the words **\"View Profile\"** pop up. Click on this");
        desc.add("Once you clicked in, you should see more information about the user. There should be a **\"Send a Friend Request\" button at the top right**. Click on that to send a friend request!");
        desc.add("If the button grays out and says \"Friend Request Sent\", you are all set! \n\nFor information on how to **accept a friend request**, please type **!friends accept**");
        return desc;
    }

    List<String> getAddImages() {
        List<String> images = new ArrayList<>();
        images.add("https://cdn.discordapp.com/attachments/821824091261763609/821834436630151238/unknown.png");
        images.add("https://cdn.discordapp.com/attachments/821824091261763609/822184852774191114/unknown.png");
        images.add("https://cdn.discordapp.com/attachments/821824091261763609/822185203237257256/unknown.png");
        images.add("https://cdn.discordapp.com/attachments/821824091261763609/822185690313392138/unknown.png");
        return images;
    }

    List<String> getAccept() {
        List<String> desc = new ArrayList<>();
        desc.add("If you have received a friend request, you should see the **top left icon with a notification**, please click on this.");
        desc.add("Once you have clicked in, make sure you are looking at the **friends page** by clicking the area shown in the image below.");
        desc.add("There should be a notification besides **\"Pending\"**, click on this, ");
        desc.add("You will see the person who have sent you a friend request, you can choose to **accept or ignore** it by clicking the **check mark** or **cross mark**.");
        desc.add("If you switch back to the **\"All\"** friends tab, you should be able to see the person you just added. \n\nFor more information on how to directly message them, please type **!friends message**");
        return desc;
    }

    List<String> getAcceptImages() {
        List<String> images = new ArrayList<>();
        images.add("https://cdn.discordapp.com/attachments/821824091261763609/822188302589100082/unknown.png");
        images.add("https://cdn.discordapp.com/attachments/821824091261763609/822188933194579978/unknown.png");
        images.add("https://cdn.discordapp.com/attachments/821824091261763609/822189245761454131/unknown.png");
        images.add("https://cdn.discordapp.com/attachments/821824091261763609/822189841881759794/unknown.png");
        images.add("https://cdn.discordapp.com/attachments/821824091261763609/822190330316980244/unknown.png");
        return images;
    }

    List<String> getRemove() {
        List<String> desc = new ArrayList<>();
        desc.add("Click on the **top left icon** to access your friends page.");
        desc.add("Make sure you are in your **Friends** page with **All** friends being listed. Then, find the person you would like to remove.");
        desc.add("Click on the right most icon with the three dots, it should say \"More\" when you hover over it.");
        desc.add("Click on **\"Remove Friend\"**. Then you're all set!");
        return desc;
    }

    List<String> getRemoveImages() {
        List<String> images = new ArrayList<>();
        images.add("https://cdn.discordapp.com/attachments/821824091261763609/822192307289325643/unknown.png");
        images.add("https://cdn.discordapp.com/attachments/821824091261763609/822193036271812648/unknown.png");
        images.add("https://cdn.discordapp.com/attachments/821824091261763609/822193386731733052/unknown.png");
        images.add("https://cdn.discordapp.com/attachments/821824091261763609/822193968270934076/unknown.png");
        return images;
    }

    List<String> getMessage(int method) {
        List<String> desc = new ArrayList<>();
        if (method == 1) {
            desc.add("Click on the **top left icon** to access your friend directory.");
            desc.add("Click on the person you would like to chat with.");
            desc.add("Now you're all set!");
        } else if (method == 2) {
            desc.add("**Right click** on the person that you would like to chat with.");
            desc.add("In the menu that pops up, click \"Message\"");
            desc.add("This will bring you to the regular messaging screen which means you're all set!");
        } else {
            desc.add("Click on the **top left icon** to access your friends page.");
            desc.add("Make sure you are in your **Friends** page with **All** friends being listed. Then, find the person you would like to message.");
            desc.add("Click on the **\"Message Icon\"**.");
            desc.add("This will bring you to the regular messaging screen which means you're all set!");
        }
        return desc;
    }

    List<String> getMessageImages(int method) {
        List<String> images = new ArrayList<>();
        if (method == 1) {
            images.add("https://cdn.discordapp.com/attachments/821824091261763609/822192307289325643/unknown.png");
            images.add("https://cdn.discordapp.com/attachments/821824091261763609/822206507058855986/unknown.png");
            images.add("https://cdn.discordapp.com/attachments/821824091261763609/822206841873891338/unknown.png");
        } else if (method == 2) {
            images.add("https://cdn.discordapp.com/attachments/821824091261763609/821834436630151238/unknown.png");
            images.add("https://cdn.discordapp.com/attachments/821824091261763609/822209766846627860/unknown.png");
            images.add("https://cdn.discordapp.com/attachments/821824091261763609/822206841873891338/unknown.png");
        } else {
            images.add("https://cdn.discordapp.com/attachments/821824091261763609/822192307289325643/unknown.png");
            images.add("https://cdn.discordapp.com/attachments/821824091261763609/822193036271812648/unknown.png");
            images.add("https://cdn.discordapp.com/attachments/821824091261763609/822210356553842708/unknown.png");
            images.add("https://cdn.discordapp.com/attachments/821824091261763609/822206841873891338/unknown.png");
        }
        return images;
    }

/*
    List<String> getAccept() {
        List<String> desc = new ArrayList<>();
        desc.add();
    }

    List<String> getAcceptImages() {
        List<String> images = new ArrayList<>();
        images.add();
    }

 */
}