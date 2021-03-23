package Commands.Guides;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class StringDescriptions {

    void getData(String system, String command) {

        URL url = null;
        try {
            url = new URL("localhost:8080/api/command/" + system + "/" + command);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection con = null;
        try {
            con = (HttpURLConnection) url.openConnection();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        try {
            con.setRequestMethod("GET");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        StringBuffer content = new StringBuffer();
        try {
            if (con.getResponseCode() == 200) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                    System.out.println(inputLine);
                }
                in.close();
                con.disconnect();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

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

    List<String> getBlock(int method) {
        List<String> desc = new ArrayList<>();
        if (method == 1) {
            desc.add("Click on the **top left icon** to access your friend directory.");
            desc.add("Find the person you would like to block");
            desc.add("**Right click** on them, and **click on \"Block\"**. Then, you should be all set!");
        } else {
            desc.add("In a server environment, **find the person** you would like to block.");
            desc.add("**Right click on the person** and a menu should pop up");
            desc.add("In the menu that pops up, **click on \"Block\"** and you should be all set!");
        }
        return desc;
    }

    List<String> getBlockImages(int method) {
        List<String> images = new ArrayList<>();
        if (method == 1) {
            images.add("https://cdn.discordapp.com/attachments/821824091261763609/822192307289325643/unknown.png");
            images.add("https://cdn.discordapp.com/attachments/821824091261763609/822206507058855986/unknown.png");
            images.add("https://cdn.discordapp.com/attachments/821824091261763609/822547077308612678/unknown.png");
        } else {
            images.add("https://cdn.discordapp.com/attachments/821824091261763609/821834436630151238/unknown.png");
            images.add("https://cdn.discordapp.com/attachments/821824091261763609/822209766846627860/unknown.png");
            images.add("https://cdn.discordapp.com/attachments/821824091261763609/822546509291061328/unknown.png");
        }
        return images;
    }

    List<String> getLang() {
        List<String> desc = new ArrayList<>();
        desc.add("Inside settings, find the **category called \"Langauges\"** and click on it");
        desc.add("Find the language you would like to switch to and click on it. Then, you should be all set!");
        return desc;
    }

    List<String> getLangImages() {
        List<String> images = new ArrayList<>();
        images.add("https://cdn.discordapp.com/attachments/821824091261763609/822551533001638008/unknown.png");
        images.add("https://cdn.discordapp.com/attachments/821824091261763609/822551835931181056/unknown.png");
        return images;
    }

    List<String> getAppearance() {
        List<String> desc = new ArrayList<>();
        desc.add("Inside settings, find the **category called \"Appearance\"** and click on it");
        desc.add("You can choose to change the theme to dark or light and the display to cozy or compact. Anything you choose will be reflected in the big box at the top.");
        desc.add("You can also change the size of the text and the spacing between by dragging the point across the bar. (Green is the default settings) **Note that these changes are reflected in the big box at the top too!");
        desc.add("Make sure you are happy with the changes by double checking the screen at the top!");
        return desc;
    }

    List<String> getAppearanceImages() {
        List<String> images = new ArrayList<>();
        images.add("https://cdn.discordapp.com/attachments/821824091261763609/822552460220432414/unknown.png");
        images.add("https://cdn.discordapp.com/attachments/821824091261763609/822552729905397860/unknown.png");
        images.add("https://cdn.discordapp.com/attachments/821824091261763609/822553152804356106/unknown.png");
        images.add("https://cdn.discordapp.com/attachments/821824091261763609/822553764581081098/unknown.png");
        return images;
    }

    List<String> getVoice() {
        List<String> desc = new ArrayList<>();
        desc.add("Inside settings, find the **category called \"Voice and Video\"** and click on it");
        desc.add("Here you can change the **input** (where it is collecting your sound) and the **output** (where it is giving off sound).");
        desc.add("You can also test to see if your **mic is working properly** by **clicking the \"Let's Check\"** button.");
        desc.add("Here you can choose to have the mic be from detecting **voice activity** past a certain volume, or **push to talk** which requires you to push a button in order for sound to be recorded. \n\nIf you chose **voice activity**, there should be a bar at the bottom for you to **adjust the sensitivity**.");
        desc.add("If you chose push to talk, please note that the full version will require discord to be downloaded. If you are in the browser, you would have to stay within the browser in order for this to work. \n\nOtherwise, you can set a keybind (which means that you would have to press this button to speak to the other person). You can also set a delay, which means that you would need to wait a bit after pressing the key to talk.");
        desc.add("Here, you can test if your camera works and choose which one to use");
        desc.add("Lastly, you can change these functions: \n**Echo Cancellation** - detects and prevents an echo \n**Noise Reduction** - in noisy areas, this would focus more on your talking and reduce background sounds \n**Automatic Gain Control** -- this adjusts your volume depending on your location and sound towards the mic (If you are further away and more quiet, it will boost your volume) \n\nYou can also **reset all your voice and video-related settings** at any time.");
        return desc;
    }

    List<String> getVoiceImages() {
        List<String> images = new ArrayList<>();
        images.add("https://cdn.discordapp.com/attachments/821824091261763609/822554161874337832/unknown.png");
        images.add("https://cdn.discordapp.com/attachments/821824091261763609/822555060227670076/unknown.png");
        images.add("https://cdn.discordapp.com/attachments/821824091261763609/822554977507213382/unknown.png");
        images.add("https://cdn.discordapp.com/attachments/821824091261763609/822555176392589342/unknown.png");
        images.add("https://cdn.discordapp.com/attachments/821824091261763609/822556370866798643/unknown.png");
        images.add("https://cdn.discordapp.com/attachments/821824091261763609/822559090998771732/unknown.png");
        images.add("https://cdn.discordapp.com/attachments/821824091261763609/822559342385299537/unknown.png");
        return images;
    }

/*
    List<String> getAccept() {
        List<String> desc = new ArrayList<>();
        desc.add();
        return desc;
    }

    List<String> getAcceptImages() {
        List<String> images = new ArrayList<>();
        images.add();
        return images;
    }

 */
}