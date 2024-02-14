package api.enums;

public enum APIResources {
    createUser("v2/user"),
    getUser("v2/user"),
    deleteUser("v2/user");
    private final String resource;
    APIResources(String resource) {
        this.resource = resource;
    }
    public String getResource(){
        return resource;
    }
}
