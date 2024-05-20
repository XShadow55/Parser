package com.example.Parser.servise;

import com.example.Parser.Interface.InterfaceParser;
import com.example.Parser.model.LessonsUn;
import com.example.Parser.repository.RepositoryLessons;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

@Service
public class Parser implements InterfaceParser {
    private static RepositoryLessons repositoryLessons;

    public Parser(RepositoryLessons repositoryLessons) {
        this.repositoryLessons = repositoryLessons;
    }

    public static void parser() throws IOException {
        Integer id = 60;
        Logger logger = Logger.getAnonymousLogger();
        Document doc = Jsoup.connect("http://eetk.ru/78-2/82-2/88-2/").get();
        Elements menu = doc.getElementsByClass("wp-table-reloaded wp-table-reloaded-id-60");
        Integer el1 = menu.select("a").size();

        for (int i = 1;i<el1-1;i++) {
            Elements menus = doc.getElementsByClass("wp-table-reloaded wp-table-reloaded-id-"+id);
            String   h3 = doc.select("h3").get(i).text();
            List<String> list = Arrays.stream(h3.split(" ")).toList();
            LessonsUn lessonsUn = new LessonsUn((long)i,list.get(3),list.get(5),menus.select("a").get(0).attr("href"),menus.select("a").get(1).attr("href")
                    ,menus.select("a").get(2).attr("href"),menus.select("a").get(3).attr("href"));

            if (repositoryLessons.findById((long) i).isEmpty()){
                repositoryLessons.save(lessonsUn);
            }
            else {
                repositoryLessons.deleteById((long) i);
                repositoryLessons.save(lessonsUn);
            }
            id = id-2;


        }

    }




    public List<LessonsUn> lessons()  {
        return repositoryLessons.findAll();
    }
}
