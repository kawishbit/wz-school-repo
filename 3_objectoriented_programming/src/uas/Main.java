package uas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

class User<T extends UserData> {
    T data;
    String username, password, email;
    private String role, roleDescription;

    User(String username, String password, String email, T data) {
        this.data = data;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = data.getRoleName();
        this.roleDescription = data.getRoleDescription();
    }

    public String getRole() {
        return this.role;
    }

    public String getRoleDescription() {
        return this.roleDescription;
    }

    public void displayData() {
        System.out.printf("Username: %s %n", this.username);
        System.out.printf("Email: %s %n", this.email);
        System.out.printf("Role: %s %n", this.role);
        System.out.printf("Role Description: %s %n", this.roleDescription);
        this.data.displayData();
    }
}

class UserData {
    String firstName, lastName, description, aboutMe;
    LocalDate birthday;

    UserData(String firstName, String lastName, String description, String aboutMe, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.aboutMe = aboutMe;
        this.birthday = birthday;
    }

    public String getRoleName() {
        return "Guest";
    }

    public String getRoleDescription() {
        return "Guest role description";
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public void displayData() {
        System.out.printf("Full Name : %s %n", this.getFullName());
        System.out.printf("Description : %s %n", this.description);
        System.out.printf("About Me : %s %n", this.aboutMe);
        System.out.printf("Birthday : %s %n", this.birthday.format(DateTimeFormatter.ISO_LOCAL_DATE));

    }

    public void sendMessage(String message) {
        System.out.printf("[%s]: %s %n", this.getFullName(), message);
    }
}

class Admin extends UserData {
    String serverName, serverImg;
    private final ArrayList<User<Moderator>> serverMods = new ArrayList<>();
    private final ArrayList<String> channels = new ArrayList<>();

    Admin(String firstName, String lastName, String description, String aboutMe, LocalDate birthday) {
        super(firstName, lastName, description, aboutMe, birthday);
    }

    @Override
    public String getRoleName() {
        return "Admin";
    }

    @Override
    public String getRoleDescription() {
        return "Admin role description";
    }

    public void addMod(User<Moderator> mod) {
        this.serverMods.add(mod);
    }

    public void removeMod(User<Moderator> mod) {
        this.serverMods.remove(mod);
    }

    public void addChannel(String channel) {
        this.channels.add(channel);
    }

    public void removeChannel(String channel) {
        this.channels.remove(channel);
    }

    public void sendMessage(String message, String emote) {
        this.sendMessage(message, emote, "Admin");
    }

    public void sendMessage(String message, String emote, String role) {
        System.out.printf("[%s][%s] [%s] : %s %n", role, this.getFullName(), emote, message);
    }

    public <T extends UserData> void ban(User<T> user) {
        System.out.printf("[%s] : %s has been banned from the server %n", this.getFullName(), user.username);
    }

    @Override
    public void displayData() {
        super.displayData();
        int i = 1;
        System.out.printf("Role : %s%n", this.getRoleName());
        System.out.printf("Server Name : %s%n", this.serverName);
        System.out.printf("Server Img : %s%n", this.serverImg);
        System.out.printf("Moderators :%n");
        System.out.println("=====================================================");
        for (User<Moderator> mod : this.serverMods) {
            System.out.printf("%d. %s%n", i, mod.data.getFullName());
            i++;
        }
        System.out.println("=====================================================");
        i = 1;
        System.out.printf("Channels :%n");
        System.out.println("=====================================================");
        for (String channel : this.channels) {
            System.out.printf("%d. %s%n", i, channel);
            i++;
        }
        System.out.println("=====================================================");
    }

}


class Moderator extends UserData {
    private int modLevel;
    private final ArrayList<String> tasks = new ArrayList<>();
    public String introduction;

    Moderator(String firstName, String lastName, String description, String aboutMe, LocalDate birthday) {
        super(firstName, lastName, description, aboutMe, birthday);
    }

    @Override
    public String getRoleName() {
        return "Moderator";
    }

    @Override
    public String getRoleDescription() {
        return "Moderator Role Description";
    }

    public void sendMessage(String message, String emote) {
        this.sendMessage(message, emote, "Moderator");

    }

    private void sendMessage(String message, String emote, String role) {
        System.out.printf("[%s][%s] [%s] : %s  %n", role, this.getFullName(), emote, message);
    }

    public void setLevel(int level) {
        this.modLevel = level;
    }

    public void addTask(String task) {
        this.tasks.add(task);
    }

    public void removeTask(String task) {
        this.tasks.remove(task);
    }

    public void mute(User<UserData> user) {
        if (!Objects.equals(user.data.getRoleName(), "Admin"))
            System.out.printf("[%s] : %s has been muted from the server %n", this.getFullName(), user.username);
        else System.out.println("You don't have the permission to mute this user");
    }

    @Override
    public void displayData() {
        super.displayData();
        int i = 1;
        System.out.printf("Role : %s%n", this.getRoleName());
        System.out.printf("Intro : %s%n", this.introduction);
        System.out.printf("Level : %d%n", this.modLevel);
        System.out.printf("Tasks :%n");
        System.out.println("=====================================================");
        for (String task : this.tasks) {
            System.out.printf("%d. %s%n", i, task);
            i++;
        }
        System.out.println("=====================================================");
    }
}

class EventOrganizer extends UserData {
    private final ArrayList<String> events = new ArrayList<>();
    public String introduction;

    EventOrganizer(String firstName, String lastName, String description, String aboutMe, LocalDate birthday) {
        super(firstName, lastName, description, aboutMe, birthday);
    }

    @Override
    public String getRoleName() {
        return "Event Organizer";
    }

    @Override
    public String getRoleDescription() {
        return "Event Organizer Role Description";
    }

    @Override
    public void sendMessage(String message) {
        System.out.printf("[Event][%s] : %s %n", this.getFullName(), message);
    }

    public void addEvent(String event) {
        this.events.add(event);
    }

    public void removeEvent(String event) {
        this.events.remove(event);
    }

    @Override
    public void displayData() {
        super.displayData();
        int i = 1;
        System.out.printf("Role : %s%n", this.getRoleName());
        System.out.printf("Intro : %s%n", this.introduction);
        System.out.printf("Events : %n");
        System.out.println("=====================================================");
        for (String event : this.events) {
            System.out.printf("%d. %s%n", i, event);
            i++;
        }
        System.out.println("=====================================================");
    }
}

class PublicMember extends UserData {
    private LocalDateTime joinedAt;
    private final ArrayList<String> tags = new ArrayList<>();
    private final ArrayList<String> warns = new ArrayList<>();


    PublicMember(String firstName, String lastName, String description, String aboutMe, LocalDate birthday) {
        super(firstName, lastName, description, aboutMe, birthday);
    }

    @Override
    public String getRoleName() {
        return "Public Member";
    }

    @Override
    public String getRoleDescription() {
        return "Public Member Role Description";
    }

    public void setJoinedAt(LocalDateTime joinedAt) {
        this.joinedAt = joinedAt;
    }

    public void addTag(String tag) {
        this.tags.add(tag);
    }

    public void removeTag(String tag) {
        this.tags.remove(tag);
    }

    public void addWarn(String warn, User<Admin> admin) {
        this.warns.add("[" + admin.username + "] : " + warn);
    }

    public void removeWarn(String warn, User<Admin> admin) {
        this.warns.remove("[" + admin.username + "] : " + warn);
    }

    @Override
    public void displayData() {
        super.displayData();
        int i = 1;
        System.out.printf("Role : %s%n", this.getRoleName());
        System.out.printf("Joined At : %s%n", this.joinedAt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.printf("Tags : %n");
        System.out.println("=====================================================");
        for (String tag : this.tags) {
            System.out.printf("%d. %s%n", i, tag);
            i++;
        }
        System.out.println("=====================================================");
        System.out.printf("Warns : %n");
        i = 1;
        System.out.println("=====================================================");
        for (String warn : this.warns) {
            System.out.printf("%d. %s%n", i, warn);
            i++;
        }
        System.out.println("=====================================================");
    }

}

public class Main {
    public static void main(String[] args) {
        User<Admin> admin = new User<>("kawish", "asdasd123", "kawish@oop.com", new Admin("Kawish", "Behzad", "edscription user", "about me ", LocalDate.of(1998,6,10)));

        admin.data.serverName = "UntitledServer";
        admin.data.serverImg = "a.jpg";

        User<Moderator> moderator = new User<>("kawishmod", "asdasd123", "kawishmod@oop.com", new Moderator("KawishMod", "Behzad", "edscription user", "about me ", LocalDate.of(1998,6,10)));

        User<EventOrganizer> evOrg = new User<>("kawishenv", "asdasd123", "kawishenv@oop.com", new EventOrganizer("KawishEnv", "Behzad", "edscription user", "about me ", LocalDate.of(1998,6,10)));

        User<PublicMember> member = new User<>("kawishmember", "asdasd123", "kawishmember@oop.com", new PublicMember("KawishMember", "Behzad", "edscription user", "about me ", LocalDate.of(1998,6,10)));

        System.out.println("==============================EXPERIMENT=========================");

        admin.data.addChannel("Channel 1");
        admin.data.addChannel("Channel 2");
        admin.data.addMod(moderator);
        admin.data.ban(member);
        admin.data.sendMessage("test message", "🍕🍕🍕🍕🍕");
        admin.displayData();

    }
}
