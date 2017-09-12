package bkm.com.ng.developers;

/**
 * Created by lenovo on 9/8/2017.
 */

public class DevelopersList {
    private String name;
    private String desc;
    private String imageUrl;

    public DevelopersList(String name, String desc, String imageUrl) {
        this.name = name;
        this.desc = desc;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }


    public String getDesc() {
        return desc;
    }

    public String getImageUrl() {
        return imageUrl;
    }


}
