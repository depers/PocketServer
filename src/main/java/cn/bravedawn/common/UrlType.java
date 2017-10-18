package cn.bravedawn.common;

/**
 * Created by 冯晓 on 2017/10/18.
 */
public enum UrlType {

    WEIXIN("weixin", "mp.weixin.qq.com"),
    ZHIHU("zhihu", "zhihu.com"),
    JIANSHU("jianshu", "jianshu.com"),
    JUEJIN("juejin", "juejin.im"),
    WEIBO("weibo", "m.weibo.cn");


    private final String keyWord;
    private final String url;

    UrlType(String keyWord, String url) {
        this.keyWord = keyWord;
        this.url = url;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public String getUrl() {
        return url;
    }
}
