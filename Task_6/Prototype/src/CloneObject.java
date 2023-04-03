public class CloneObject implements Prototype {

    private Integer typeObj;

    public CloneObject(Integer typeObj) {
        this.typeObj = typeObj;
    }

    @Override
    public CloneObject copy() {
        return new CloneObject(typeObj);
    }

    public Integer getTypeObj() {
        return typeObj;
    }
}
