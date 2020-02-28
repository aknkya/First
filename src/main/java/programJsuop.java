import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class programJsuop {



     public static void main(String[] args) throws IOException {
        final String url="https://www.ilan.gov.tr/kategori-ihale?type=21628";
         List<String> bilgiseti=new ArrayList<String>();

         try {
            final Document document=Jsoup.connect(url).get();
            //ihale kayıt no
            Elements element=document.select("div.inner-item > ul.admin-toolbar > li > div > div > div:nth-child(2) > div:nth-child(2) > span:nth-child(1)");
            // türü niteliği miktarı
            Elements element1=document.select("div.inner-item > ul.admin-toolbar > li > div > div > div:nth-child(2) > div:nth-child(2) > span");
             //işin yapılacağı yer
            Elements element2=document.select("div.inner-item > ul.admin-toolbar > li > div > div > div:nth-child(4) > div:nth-child(2)  > span");
            //ihale türü
            Elements element3=document.select("div.inner-item > ul.admin-toolbar > li > div > div > div:nth-child(6) > div:nth-child(2) > span");


            for(Element link:element){
                bilgiseti.add("----IHALE KAYIT NO--- \n");
                bilgiseti.add(link.text());
                bilgiseti.add(" \n");

            }
            for(Element link:element1){
                bilgiseti.add(" ----TURU NITELIGI MIKTARI---- \n");
                bilgiseti.add(link.text());
                bilgiseti.add(" \n");

            }
            for(Element link:element2){
                bilgiseti.add("---ISIN YAPILACAGI YER--- \n");
                bilgiseti.add(link.text());
                bilgiseti.add(" \n");

            }
            for(Element link:element3){
                bilgiseti.add("----IHALE TURU--- \n");
                bilgiseti.add(link.text());
                bilgiseti.add(" \n");

            }


            System.out.print(bilgiseti);


        } catch (IOException e) {
            e.printStackTrace();
        }


         FileWriter writer = new FileWriter("output.txt");
         for(String str: bilgiseti) {
             writer.write(str + System.lineSeparator());
         }
         writer.close();
     }
}
