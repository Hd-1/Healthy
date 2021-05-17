package data;

public class Training {
    String title;
    int banner;
    String description;
    String warning;
    String challenge;
    String steps;
    int image1;
    int image2;
    int image3;

    public Training(String title, int banner, String description, String warning, String challenge, String steps, int image1, int image2, int image3) {
        this.title = title;
        this.banner = banner;
        this.description = description;
        this.warning = warning;
        this.challenge = challenge;
        this.steps = steps;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBanner() {
        return banner;
    }

    public void setBanner(int banner) {
        this.banner = banner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public String getChallenge() {
        return challenge;
    }

    public void setChallenge(String challenge) {
        this.challenge = challenge;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public int getImage1() {
        return image1;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }

    public int getImage2() {
        return image2;
    }

    public void setImage2(int image2) {
        this.image2 = image2;
    }

    public int getImage3() {
        return image3;
    }

    public void setImage3(int image3) {
        this.image3 = image3;
    }
}
