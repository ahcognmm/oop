package btl.entity;

public class Organization extends Entity {

    private String[] relationship ={"establish","join","sponsor"};

    public Organization() {
    }

    public Organization(String label, String description, String url, String crawlTime) {
        super(label, description, url, crawlTime);
        increaseNo();
    }

    @Override
    public String getRelationship(Object o) {
        if (o instanceof Country) {
            return "locate";
        }
        if (o instanceof Event){
            return "establish";
        }
        return super.getRelationship(o);
    }
}
