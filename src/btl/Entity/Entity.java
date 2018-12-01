package btl.Entity;

public class Entity {

    private String label;
    private String description;
    private String url;
    private String crawlTime;
    private String position;

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
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
    public String getRilationship(Object o) {
        return "";
    }
}
