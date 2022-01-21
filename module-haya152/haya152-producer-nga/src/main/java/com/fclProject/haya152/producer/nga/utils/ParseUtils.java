package com.fclProject.haya152.producer.nga.utils;

import com.fclProject.haya152.producer.nga.dto.NgaDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.util.*;

public class ParseUtils {
    public static List<NgaDto> parseNGAByPage(String pageAsXml) {

        List<NgaDto> list = new ArrayList<>();
        Document document = Jsoup.parse(pageAsXml);
        Elements postboxes = document.getElementsByClass("forumbox postbox");

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

            NgaDto dto = new NgaDto(uid,name,floor,date,like,comments,tag);
            list.add(dto);
        }

        return list;
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

    public static String parseQuote(Element postbox, Integer floor) {
        Element quote = postbox.getElementById("postcontent"+floor).getElementsByClass("quote").first();
        return quote.text();
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
        if (root instanceof TextNode){
            str.append(((TextNode) root).text().trim());
        }
        else if (root.nodeName().equals("br") && str.length() != 0) str.append("\r\n");
        else if (root.attr("class").equals("quote")) {
            str.append("\r\n【引用】");
            for (Node child : root.childNodes()) {
                str = parseComments_dp(str, child);
            }
            str.append("\r\n【/引用】\r\n");
        }
        else if (root.nodeName().equals("img")) {
            String src = root.attr("src").trim();
            if (!src.equals("about:blank")) str.append(root);
        }
        else if (root.attr("class").equals("collapse_btn")) {
            str.append("\r\n【折叠】为保护隐私，内容不予显示【/折叠】\r\n");
        }
//        else if (root.attr("class").equals("collapse_content ubbcode")) {
//            str.append("\r\n【折叠】");
//            for (Node child : root.childNodes()) {
//                str = parseComments_dp(str, child);
//            }
//            str.append("\r\n【/折叠】\r\n");
//        }
        else {
            for (Node child : root.childNodes()) {
                str = parseComments_dp(str, child);
            }
        }
        return str;
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
