package com.william.mall_server;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
 
//使用Jsoup+Htmlunit下载动态js的内容
public class SpiderTest {
 
    public static void main(String[] args) throws IOException {
        System.out.println((55-12)/2);

        //Htmlunit模拟的浏览器，设置css,js等支持及其它的一些简单设置
        WebClient browser = new WebClient();
        browser.getOptions().setCssEnabled(false);
        browser.getOptions().setJavaScriptEnabled(true);
        browser.getOptions().setThrowExceptionOnScriptError(false);
        // http://pic.sogou.com/pics?query=%D1%EE%C3%DD&w=05009900&p=&_asf=pic.sogou.com&_ast=1576633586&sc=index&sut=3103&sst0=1576633585684

        //获取页面
        HtmlPage htmlPage = browser.getPage("https://stock.tuchong.com/search?term=%E9%97%B9%E9%92%9F%E5%9B%BE%E6%A0%87&no_overwrite=&use=0&type=&layout=&sort=0&category=0&size=100&search_from=suggest&exact=0&platform=weili&tp=%E9%97%B9%E9%92%9F&abtest=&royalty_free=0&image_source=&color=0&option=&has_person=0&face_num=&gender=0&age=&racial=&samemodel=0&price=0&image_format=&search_id=&is_ext_auth=0#428237986477507042");

//        System.out.println(htmlPage);
        //设置等待js的加载时间
        browser.waitForBackgroundJavaScript(3000);

        //使用xml的方式解析获取到jsoup的document对象
        Document doc = Jsoup.parse(htmlPage.asXml());
        Elements div = doc.select("#imgid");
        Elements uls = div.select("ul");
        for (Element ul : uls) {
            Elements lis = ul.select("li");
            for (Element li : lis) {
                Elements imgs = li.select("img");
                String src = imgs.attr("src");
                System.out.println(src);
            }
        }
    }
 
 
 
}
