package btl.Entity;

public class Entity {

    private static int no = 0;
    private String label;
    private String description;
    private String url;
    private String crawlTime;
    private String id;

    public Entity() {
    }

    public Entity(String label, String description, String url, String crawlTime) {
        this.label = label;
        this.description = description;
        this.url = url;
        this.crawlTime = crawlTime;
        this.id = label + no;
    }

    public void increaseNo() {
        no++;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCrawlTime() {
        return crawlTime;
    }

    public void setCrawlTime(String crawlTime) {
        this.crawlTime = crawlTime;
    }

    public String getRelationship(Object o) {
        return "";
    }

    @Override
    public String toString() {
        return label + "::" + description + "::" + url + "::" + crawlTime + "::" + id;
    }
}
