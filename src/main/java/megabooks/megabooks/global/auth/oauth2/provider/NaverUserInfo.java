package megabooks.megabooks.global.auth.oauth2.provider;

import java.util.Map;

public class NaverUserInfo implements Oauth2UserInfo {

    private Map<String, Object> attributes;
    private Map<String, Object> attributesResponse;

    public NaverUserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
        this.attributesResponse = (Map<String, Object>) attributes.get("response");
    }

    @Override
    public String getProviderId() {
        return (String) attributesResponse.get("id");
    }

    @Override
    public String getName() {
        return (String) attributesResponse.get("name");
    }

    @Override
    public String getImg() { return (String) attributesResponse.get("profile_image"); }

    @Override
    public String getEmail() {
        return (String) attributesResponse.get("email");
    }

    @Override
    public String getProvider() {
        return "naver";
    }
}
