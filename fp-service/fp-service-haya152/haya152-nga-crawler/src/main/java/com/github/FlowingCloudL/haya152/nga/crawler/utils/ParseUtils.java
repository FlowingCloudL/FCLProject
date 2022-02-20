package com.github.FlowingCloudL.haya152.nga.crawler.utils;

import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.github.FlowingCloudL.haya152.nga.crawler.entity.NGACommentsEntity;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class ParseUtils {
    public static List<NGACommentsEntity> parseNGAByPage(HtmlPage page, String tableName) {

        // 模拟点击, 获取生成了折叠内容的page, 然后转化成xml供jsoup解析
        String xmlPage = clickPage(page).asXml();
        // 解析为Document
        Document document = Jsoup.parse(xmlPage);
        // 获取所有评论Element
        Elements postboxes = document.getElementsByClass("forumbox postbox");

        List<NGACommentsEntity> list = new ArrayList<>();
        for (Element postbox : postboxes) {
            Element posterInfo = postbox.getElementsByClass("posterinfo").first();
            Integer floor = parseFloor(posterInfo);
            if (floor == 0) continue;
            Integer uid = parseUid(posterInfo);
            String name = parseName(posterInfo);
            Integer like = parseLike(postbox,floor);
            String date = parseDate(postbox,floor);
            String comments = parseComments(postbox,floor);
            Integer tag = parseTag(postbox,floor);

            NGACommentsEntity dto = new NGACommentsEntity(tableName,uid,name,floor,date,like,comments,tag);
            list.add(dto);
        }
        return list;
    }

    public static HtmlPage clickPage(HtmlPage page) {
        String buttonXPath = "//button[@name='collapseSwitchButton']";
        int size = page.getByXPath(buttonXPath).size();
        for (int i = 0; i < size; i++) {
            HtmlButton button = (HtmlButton) page.getByXPath(buttonXPath).get(i);
            try {
                page = button.click();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return page;
    }

    public static Integer parseUid(Element posterInfo) {
        return Integer.parseInt(posterInfo.getElementsByTag("div").first()
                .getElementsByTag("a").last().text());
    }

    public static String parseName(Element posterInfo) {
        String name = posterInfo.getElementsByClass("author b nobr").text();
        return name.replaceAll(" ","");
    }

    public static Integer parseFloor(Element posterInfo) {
        Integer floor;
        try {
            floor = floorToInteger(posterInfo.getElementsByClass("right").first().getElementsByTag("a").text());
        } catch (NullPointerException e) {
            floor = 0;
        }
        return floor;
    }

    public static Integer parseLike(Element postbox, Integer floor) {
        return likeToInteger(postbox.getElementById("postcontentandsubject"+floor)
                .getElementsByClass(" white").get(1).text());
    }

    public static String parseDate(Element postbox, Integer floor) {
        return postbox.getElementById("postdate"+floor).text();
    }

    public static String parseComments(Element postbox, Integer floor) {
        Element comments = postbox.getElementById("postcontent"+floor);
        StringBuilder str = new StringBuilder();
        for (Node child : comments.childNodes()) {
            str = parseComments_dp(str, child);
        }
        return str.toString();
    }
    public static StringBuilder parseComments_dp(StringBuilder str, Node root) {
        // 纯文本
        if (root instanceof TextNode){
            str.append(((TextNode) root).text().trim());
        }
        // <br>
        else if (root.nodeName().equals("br") && str.length() != 0) str.append("\r\n");
        // 引用
        else if (root.attr("class").equals("quote")) {
            addWrap(str);
            str.append("【引用】");
            for (Node child : root.childNodes()) {
                parseComments_dp(str, child);
            }
            addWrap(str);
            str.append("\r\n【/引用】");
            addWrap(str);
        }
        // 图片
        else if (root.nodeName().equals("img")) {
            String src = root.attr("src").trim();
            if (!src.equals("about:blank")) str.append(root);
        }
        // 链接
//        else if (root.nodeName().equals("a") && !root.hasAttr("class") && root.hasAttr("href")) {
//            str.append("<a href=\"").append(root.attr("href")).append("\">");
//            for (Node child : root.childNodes()) if (child instanceof TextNode) str.append(((TextNode)child).text().trim());
//            str.append("</a>");
//        }
        // 折叠
        else if (root.attr("class").equals("collapse_btn")) {
            addWrap(str);
            str.append("【折叠】");
            addWrap(str);
        }
        else if (root.attr("class").equals("collapse_content ubbcode")) {
            for (Node child : root.childNodes()) {
                parseComments_dp(str, child);
            }
            addWrap(str);
            str.append("【/折叠】");
            addWrap(str);
        }
        else {
            String eClass = root.attr("class");
            // 过滤 url
            if (eClass.equals("apd") || eClass.equals("block_txt white nobr") || eClass.equals("urltip")) return str;
            // 过滤 +R
            if (eClass.equals("block_txt block_txt_c2") || eClass.equals("block_txt block_txt_c0")) {
                if (str.length() != 0 && str.charAt(str.length()-1) != ' ') str.append(" ");
                return str;
            }
            for (Node child : root.childNodes()) {
                parseComments_dp(str, child);
            }
        }
        return str;
    }

    private static void addWrap(StringBuilder str) {
        if (str.length() != 0 && str.charAt(str.length()-1) != '\n') str.append("\r\n");
    }

    public static Integer parseTag(Element postbox, Integer floor) {
        Element comments = postbox.getElementById("postcontent"+floor);
        Integer tag = 0;
        if (!comments.getElementsByClass("quote").isEmpty()) return 1;
        for (Node child : comments.childNodes()) {
            if (child instanceof TextNode) {
                String cur = ((TextNode) child).text().trim();
                if (cur.equals("Reply to") || cur.equals("[quote]")) tag = 1;
                else if (cur.length() >= 4 && cur.charAt(0) == '['
                        && cur.charAt(1) == '同' && cur.charAt(2) == '传' && cur.charAt(3) == ']') tag = 2;
                break;
            }
        }

        return tag;
    }

    public static Integer floorToInteger(String floor) {
        return Integer.parseInt(floor.substring(1));
    }

    public static Integer likeToInteger(String like) {
        return like.equals("") ? 0 : Integer.parseInt(like);
    }
}
