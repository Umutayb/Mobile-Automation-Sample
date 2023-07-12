package common;

import lombok.Getter;

@Getter
public enum Environment {
    test("test-url"),
    dev("dev-url"),
    acceptance("acc-url");

    final String urlKey;

    Environment(String urlKey){
        this.urlKey = urlKey;
    }
}
