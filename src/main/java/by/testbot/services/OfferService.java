package by.testbot.services;

import by.testbot.models.Offer;
import by.testbot.repositories.OfferRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {
    private OfferRepository offerRepository;

    public OfferService(OfferRepository offerRepository){
        this.offerRepository = offerRepository;
    }

    public List<Offer> getAll(){
        return offerRepository.findAll();
    }
}
