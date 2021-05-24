package by.testbot.services;

import by.testbot.models.SpecialOffer;
import by.testbot.repositories.SpecialOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialOfferService {
    private SpecialOfferRepository specialOfferRepository;

    @Autowired
    public SpecialOfferService(SpecialOfferRepository specialOfferRepository){
        this.specialOfferRepository = specialOfferRepository;
    }

    public SpecialOffer save(SpecialOffer specialOffer){
        return specialOfferRepository.save(specialOffer);
    }


}
