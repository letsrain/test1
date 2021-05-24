package by.testbot.services;

import by.testbot.models.Offer;
import by.testbot.models.SpecialOffer;
import by.testbot.models.User;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class LinkMakerService {
    private UserService userService;
    private SpecialOfferService specialOfferService;
    private OfferService offerService;

    private List<Offer> allOffers;

    @Autowired
    public LinkMakerService(UserService userService, SpecialOfferService specialOfferService, OfferService offerService){
        this.specialOfferService = specialOfferService;
        this.userService = userService;
        this.offerService = offerService;
    }

    public void makeLinks(User user){

        if(specialOfferService.allByUserId(user.getUser_id()).size() < 14) {

            allOffers = new ArrayList<>(offerService.getAll());
            
            System.out.println(allOffers.size());

            for (Offer offer : allOffers) {
                SpecialOffer specialOffer = new SpecialOffer();

                specialOffer.setAlreadyTaken(false);
                specialOffer.setClicked(false);

                specialOffer.setLink(shortLinkMaker(offer.getLink()));

                specialOffer.setOwner(user);

                specialOffer.setParentLink(offer.getLink());

                specialOfferService.save(specialOffer);
                specialOffer = null;
            }
        }


    }


    public String shortLinkMaker(String lonLink){
        String result ="";

        String action = "shorturl";
        String format = "json";
        String urlToShort = lonLink;

        String url = "http://zaimdozp.pw/win/yourls-api.php?signature=61e3be94f5" + "&action=" + action + "&url=" + urlToShort + "&format=" + format;

            try {
                Document doc = Jsoup.connect(url).ignoreContentType(true).get();
                System.out.println(doc.html());
                int s = doc.html().indexOf("shorturl");
                int e = doc.html().indexOf("statusCode");
                String r = doc.html().substring(s,e);
                r = (r.substring(r.indexOf("http"),r.lastIndexOf(",") -1));
                r= r.replaceAll("\\\\/", "/");
                System.out.println(r);

                result = r;

                log.info(doc.title());
            } catch (IOException e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }




        return result;
    }

}
